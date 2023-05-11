package com.nttdata.bootcamp.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.bootcamp.app.domain.Person;
import com.nttdata.bootcamp.app.service.PersonService;

import reactor.core.publisher.Flux;

@Controller
public class PersonListController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/person-list")
	public String personList(final Model model) {
		final Flux<Person> personlist = personService.allPersons();
		
		model.addAttribute("personlist", personlist);
		
		return "personlist";
	}

}
