package com.sid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.entities.Compte;
import com.sid.entities.Operation;
import com.sid.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;

	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}

	@RequestMapping("/consulterCompte")
	public String consulte(Model model, String codeCompte, 
			@RequestParam(name="page",defaultValue = "0")int page,
			@RequestParam(name="size",defaultValue = "4")int size) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = banqueMetier.consulterCompte(codeCompte);
			Page<Operation> pageOperation = banqueMetier.listOperation(codeCompte, page, size);
			int []pages=new int[pageOperation.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("listeOperation", pageOperation.getContent());
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}

		return "comptes";

	}
//@PostMapping("/saveOperation")
	 @RequestMapping(value ="/saveOperation", method=RequestMethod.POST) 
	public String saveOperation(Model model, String typeOperation, String codeCompte, double montant,
			String codeCompte2) {
		try {
			if (typeOperation.equals("VERS")) {
				banqueMetier.verser(codeCompte, montant);
			}
			if (typeOperation.equals("RETR")) {
				banqueMetier.retirer(codeCompte, montant);
			}
			if (typeOperation.equals("VIRE")) {
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}

		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
}
