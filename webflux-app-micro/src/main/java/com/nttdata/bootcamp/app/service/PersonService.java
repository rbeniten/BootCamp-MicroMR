package com.nttdata.bootcamp.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.app.domain.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonService {
	
	public Flux<Person> allPersons(){
		
		Flux<Person> fluxPerson1 =  WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> fluxPerson2 =  WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> fluxPerson3 =  WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> fluxPerson4 =  WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);
		
		return Flux.merge(fluxPerson1, fluxPerson2,fluxPerson3,fluxPerson4);
	}

}
