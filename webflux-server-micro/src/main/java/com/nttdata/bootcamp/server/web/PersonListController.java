package com.nttdata.bootcamp.server.web;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.server.domain.Person;

import reactor.core.publisher.Flux;

@RestController
public class PersonListController {
	
	@GetMapping("/person-list-1")
	public Flux<Person> personList1(){
		
		return Flux.just(
				new Person("John", "Doe",18)
			).delayElements(Duration.ofSeconds(1));
		
	}
	
	@GetMapping("/person-list-2")
	public Flux<Person> personList2(){
		
		return Flux.just(
				new Person("Alice", "Johnson",53)
			).delayElements(Duration.ofSeconds(2));
		
	}
	
	@GetMapping("/person-list-3")
	public Flux<Person> personList3(){
		
		return Flux.just(
				new Person("Emily", "Brown",7)
			).delayElements(Duration.ofSeconds(3));
		
	}
	
	@GetMapping("/person-list-4")
	public Flux<Person> personList4(){
		
		return Flux.just(
				new Person("Sophie", "Jones",87)
			).delayElements(Duration.ofSeconds(4));
		
	}

}
