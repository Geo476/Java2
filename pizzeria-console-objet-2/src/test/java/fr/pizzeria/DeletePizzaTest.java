package fr.pizzeria;

import static org.junit.Assert.*;


import java.util.Scanner;

import org.junit.Test;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.action.DeletePizza;



public class DeletePizzaTest {

	
	
	
	
	@Test
	public void testDeletePizza() {
	
		Scanner scanner = new Scanner(System.in);
		PizzaDao pizzaDao = new PizzaDaoArray();
		
		
		IhmUtil utils = new IhmUtil(scanner, pizzaDao);
		new DeletePizza(utils);
		
		
		
		fail("Not yet implemented");
	}

}
