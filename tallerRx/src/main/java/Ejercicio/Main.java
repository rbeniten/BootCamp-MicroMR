package Ejercicio;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Main {
	
	public static void main(String[] args) {
       
		
        Observable<String> observable = Observable.just("Hola", "Me", "Llamo", "Ruben");

        Observer<String> observer1 = new Observer<String>() {
			
			public void onSubscribe(Disposable d) {
				System.out.println("El observer uno se ha subscrito a " + d.toString());
				
			}
			
			public void onNext(String t) {
				 System.out.println("Observer 1: " + t);
			}
			
			public void onError(Throwable e) {
				System.out.println("Ha ocurrido un error : " + e.getMessage());
				
			}
			
			public void onComplete() {
				System.out.println("Se ha completado el observer 1");
				
			}
		};
		
		Observer<String> observer2 = new Observer<String>() {
					
					public void onSubscribe(Disposable d) {
						System.out.println("El observer 2 se ha subscrito a " + d.toString());
						
					}
					
					public void onNext(String t) {
						 System.out.println("Observer 2: " + t);
					}
					
					public void onError(Throwable e) {
						System.out.println("Ha ocurrido un error : " + e.getMessage());
						
					}
					
					public void onComplete() {
						System.out.println("Se ha completado el observer 2");
						
					}
		};
		
		observable.subscribe(observer1);
		observable.subscribe(observer2);
       
    }

}
