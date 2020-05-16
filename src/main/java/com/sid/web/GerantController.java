package com.sid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sid.dao.ConseillerRepository;
import com.sid.dao.GerantRepository;
import com.sid.entities.Conseiller;
import com.sid.entities.Gerant;

@Controller
public class GerantController {
	@Autowired
 private GerantRepository gerantRepository;
	@Autowired
	private ConseillerRepository conseillerRepository;
	@RequestMapping(value="/ajouterGerant")
	public String ajouterGerant( Model model) {
		model.addAttribute("gerant", new Gerant());
		return "ajouterGerant";
		
	}
	@RequestMapping(value="/ajoutedugerant")
	public String saveGerant(Model model, Gerant g) {
		gerantRepository.save(g);
		return "redirect:/ajouterGerant";
	}

}
