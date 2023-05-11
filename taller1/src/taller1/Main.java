package taller1;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(18,6,4,15,55,78,12,9,8);
		
		Long numbersUp10 = numbers.stream().filter(number -> number > 10).count();
		
		System.out.println(numbersUp10);
	}

}
