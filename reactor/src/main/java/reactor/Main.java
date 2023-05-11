package reactor;

import reactor.core.publisher.Flux;

public class Main {
	public static void main(String[] args) {
		
		Flux<String> publisher = Flux.just("Mensaje 1", "Mensaje 2", "Mensaje 3");

	    
	    
	    publisher.subscribe(m -> System.out.println("Consumer 1. Received: " + m),
	    					e -> System.out.println("Consumer 1. Error: " + e),
	    					() -> System.out.println("Consumer 1. Completed: ")
	    		
	    		);
	    
	    publisher.subscribe(m -> System.out.println("Consumer 2. Received: " + m),
				e -> System.out.println("Consumer 2. Error: " + e),
				() -> System.out.println("Consumer 2. Completed: ")
	
	);
	    
	    //Forma de hacerlo con Mono
	    
	    /*Mono<Void> consumer1 = publisher.doOnNext(msg -> System.out.println("Consumer 1. Received: " + msg)).then()
		.doOnSubscribe(msg -> System.out.println("Consumer 1. Subscribe: " + msg));
Mono<Void> consumer2 = publisher.doOnNext(msg -> System.out.println("Consumer 2. Received: " + msg)).then();

*/
	    /*
	    consumer1.subscribe();
	    consumer2.subscribe();
		*/
	}
}
