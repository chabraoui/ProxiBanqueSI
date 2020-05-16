package com.sid.web;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sid.dao.ClientRepository;
import com.sid.dao.ConseillerRepository;
import com.sid.dao.GerantRepository;
import com.sid.entities.Client;
import com.sid.entities.Conseiller;
import com.sid.entities.Gerant;

@Controller
public class ConseillerController {
	@Autowired
	private GerantRepository gerantRepository;
	@Autowired
	private ConseillerRepository conseillerRepository;
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/listeConseiller")
	public String consulterConseiller(Model model) {
		List<Conseiller> listeConseill = conseillerRepository.findAll();
		model.addAttribute("listeCons", listeConseill);
		return "listeConseiller";
	}

	@RequestMapping(value = "/edit/conseiller/{id}" ,method = RequestMethod.GET)
	public ModelAndView editerConseiller(@PathVariable(name="id") long id,Model model) {
		ModelAndView mav=new ModelAndView("editeConseiller");
		Conseiller conseiller= conseillerRepository.getOne(id);
		mav.addObject("conseiller", conseiller);
		List<Gerant> listeGerant = gerantRepository.getGerant();
		model.addAttribute("listeGerant", listeGerant);
		return mav;
	}
	
	/*
	 * @RequestMapping(value="/ajouterConseiller") public String
	 * ajouterConseiller(Model model, Conseiller conseiller, Gerant gerant) {
	 * Conseiller e=new Conseiller(); conseiller.setGerant(gerant);
	 * model.addAttribute("gerante",gerantRepository.findAll());
	 * model.addAttribute("conseiller",conseiller); model.addAttribute("gerant",
	 * gerant); return "ajouterConseiller"; }
	 */

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajouterConseiller")
	public String ajouterConseiller(Model model) {
		Conseiller c = new Conseiller();
		model.addAttribute("conseiller", c);
		List<Gerant> listeGerant = gerantRepository.getGerant();
		model.addAttribute("listeGerant", listeGerant);
		return "ajouterConseiller";
	}

	@RequestMapping(value = "/ajouteduconseiller", method = RequestMethod.POST)
	public String saveConseiller(@ModelAttribute("conseiller") Conseiller conseiller, Model model) {
		conseillerRepository.save(conseiller);

		return "redirect:/ajouterConseiller";
	}

	@GetMapping(path = "/deleteConseiller")
	public String deletConseiller(long id){
				Client cl=clientRepository.getCl(id);
		cl.setConseiller(conseillerRepository.getOne(1L));
		conseillerRepository.deleteById(id);
		return "redirect:/listeConseiller";
	}

	/*
	 * @RequestMapping(value = "/ajouteduconseiller") public String
	 * saveConseiller(Model model, Conseiller conseiller) { Gerant gerant =
	 * gerantRepository.getOne(2L); conseiller.setGerant(gerant);
	 * conseillerRepository.save(conseiller);
	 * 
	 * return "redirect:/ajouterConseiller"; }
	 */
	/*
	 * 
	 */

	
	
	
	
	
	
	
}
