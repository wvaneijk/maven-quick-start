package com.polteq;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
	//Maak een onderdeel van een webshop waarmee orders aangemaakt kunnen worden. 
	//Orders worden aangemaakt op naam van een klant, 
	//een eenmaal aangemaakte order kan niet worden overgezet op een ander klant.  
	//Natuurlijk moet het wel mogelijk zijn om de order op basis van de klantnaam op te halen. 
	//Een voltooide order is een lijst van producten waarover een totaal bedrag berekend wordt. 
	//Elk product heeft een naam om dit product te identificeren en natuurlijk een prijs per eenheid. 
	//Afhankelijk van het type product is er een prijs op basis van:
	//•	het gewicht, namelijk: prijs * (gewicht / GRAMS_PER_UNIT) 
	//•	het volume, namelijk: prijs * (volume / LITERS_PER_UNIT) 
	//De standaardwaarde voor GRAMS_PER_UNIT is 100 gram en de standaardwaarde voor LITERS_PER_UNIT is 0,75 liter.


    public static void main (String[] args) {
	Customer customer = new Customer();
	Product product = new Product();
	customer.createCustomer("William");
	product.listAllProducts();
	customer.addProductToCart("William", "Hagelslag");	
	customer.addProductToCart("William", "Bier");
	customer.addProductToCart("William", "Allesreiniger");
    }
    
	
	public void greet(){
		List<String> greetings = new ArrayList<>();
		greetings.add("Hello");
		for (String greeting : greetings){
			System.out.println("Greeting: " +greeting);
		}
	}
	
	public void createOrder(){
	
	}
	
	public void addOrder(String user, String product){
		
	}
	
    public Application() {
        System.out.println ("Inside Application");
    }
}