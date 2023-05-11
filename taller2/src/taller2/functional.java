package taller2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;


public class functional {
	
	public static void main(String[] args) {
		
			List<Product> shopping = List.of( 
					new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL), 
					new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED), 
					new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED), 
					new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED), 
					new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED), 
					new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
			
			//Implementacion
			BigDecimal precioTotal = BigDecimal.ZERO;
			
			
			precioTotal = shopping.stream().map(producto -> producto.price
												.multiply(new BigDecimal(producto.tax.percent).divide(new BigDecimal(100)))
												.add(producto.price))
												.reduce(BigDecimal.ZERO, BigDecimal::add);
			
			System.out.println(precioTotal.setScale(2, RoundingMode.HALF_UP));
			
			
			System.out.println("Lista de productos que empiezan por C ordenadas");
			
			List<Product> productStartWithC = shopping.stream().filter((product) -> product.name.startsWith("C"))
																		.sorted((p1,p2) -> p1.price.compareTo(p2.price))
																		.collect(Collectors.toList());
			
			System.out.println(productStartWithC);
	}

}
