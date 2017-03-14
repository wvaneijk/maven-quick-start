package com.polteq;

import java.util.ArrayList;
import java.util.List;


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

public class Order {

	public List<String> items;
	public MongoDB mongoclient = new MongoDB();

	public Order(String clientName) {
		items = new ArrayList<String>();
		items.add(0, clientName);
	}

	public void add(String clientName, String item) {
		items.add(item);
	}
}