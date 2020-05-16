package com.sid.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sid.dao.ClientRepository;
import com.sid.dao.CompteRepository;
import com.sid.dao.ConseillerRepository;
import com.sid.dao.GerantRepository;
import com.sid.entities.Client;
import com.sid.entities.Compte;
import com.sid.entities.CompteCourant;
import com.sid.entities.CompteEpargne;
import com.sid.entities.Conseiller;
import com.sid.entities.Gerant;
import com.sid.metier.IBanqueMetier;
@Controller
public class ClientController {
	@Autowired
 private GerantRepository gerantRepository;
	@Autowired
	private ConseillerRepository conseillerRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
private CompteRepository compteRepositpory;
	@Autowired
	private IBanqueMetier banquemetier;
	
	@RequestMapping(value = "/ajouterClient")
	public String ajouterClient( Model model) {
		
		Client cl=new Client();
		model.addAttribute("client",cl);
		List<Conseiller> listeConseiller=conseillerRepository.getConseiller();
		model.addAttribute("listeConseiller",listeConseiller);
		return "ajouterClient";
		
	}
	
	//,@Valid Client c, BindingResult bindingResult
	
	
	  @RequestMapping(value = "/saveclient", method = RequestMethod.POST) 
	  public String saveClient(@ModelAttribute("client") Client client, Model model, String codeCpt, String typeCpte){
//		  if (bindingResult.hasErrors()) {
//				return "ajouterClient";
//			}
		  try {
			if(typeCpte.equals("CC")) {
					Compte cc=compteRepositpory.save(new CompteCourant(codeCpt, new Date(), 2000, client, 6000));
			  }
			if(typeCpte.equals("CE")) {
					  Compte cv=compteRepositpory.save(new CompteEpargne(codeCpt, new Date(), 2000, client, 5.5));}
			
		} catch (Exception e) {
			//model.addAttribute("errorK", e);
			System.out.println("error");
		}
	  return "redirect:/ajouterClient"; }
	  
	
	 
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String updateClient(@ModelAttribute("client") Client client, Model model,String codeCpt, String typeCpte,double 
				soldeCpt) {
		clientRepository.saveAndFlush(client);
		//compteRepositpory.saveAndFlush(new CompteCourant("jkkkkk", new Date(), 2000, client, 6000));
		try {
				if(typeCpte.equals("CompteCourant")) {
						Compte cc=compteRepositpory.saveAndFlush(new CompteCourant(codeCpt, new Date(), soldeCpt, client, 6000));
				  }
				if(typeCpte.equals("CompteEpargne")) {
						  Compte cv=compteRepositpory.saveAndFlush(new CompteEpargne(codeCpt, new Date(), soldeCpt, client, 5.5));}
			} catch (Exception e) {
				System.out.println("error");
			}
			return "redirect:/listeClient";
		}

	  
	
		@RequestMapping(value = "/listeClient")
		public String listeClient(Model model) {
			List<Client> listeClient = clientRepository.findAll();
			model.addAttribute("listeCli", listeClient);
//			Compte c=compteRepositpory.findById("yoyo10").get();
//			model.addAttribute("ccc",c);
//			System.out.println("eroooooooor");
			return "listeClient";
		}
		
		
		
		@RequestMapping(value = "/edit/{code}" ,method = RequestMethod.GET)
		public ModelAndView editerClient(@PathVariable(name="code") long id,Model model) {
			ModelAndView mav=new ModelAndView("editeClient2");
			Client client= clientRepository.getOne(id);
			mav.addObject("client", client);
			List<Conseiller> listeConseiller = conseillerRepository.getConseiller();
			model.addAttribute("listeConseiller", listeConseiller);
			Compte c=compteRepositpory.getcompt(id);
			model.addAttribute("cx",c.getSolde());
			model.addAttribute("xc",c.getCodeCompte());
			model.addAttribute("ccx",c.getClass().getSimpleName());
			return mav;
		}
		
		@GetMapping(path = "/deleteClient")
		public String deletClient(long id) {
			clientRepository.deleteById(id);;
			return "redirect:/listeClient";
		}

		
}


