package fr.pizzeria.console;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class PizzeriaAdminConsoleApp {

	

	
	public static void main(String[] args) {

		int i,j,k;
		String ch;
		float l;
		
		
		
		// Création Carte des Pizzas
		
		Object TableauPizza[][]= { 
				
				{"PEP","Pépéroni",12.50}, 
				{"MAR","Margarita",14.00},
				{"REI","Reine",11.50},
				{"FRO","4 Fromages",12.00},
				{"CAN","Cannibale",12.50},
				{"SAV","Savoyarde",13.00},
				{"ORI","Orientale",13.50},
				{"IND","Indienne",14.00},
		
		};
		

		
		
		
		
		do {
		
		
		System.out.print(" \n\n***** Pizzeria Administration ***** \n "
				+ "1.Lister les pizzas \n "
				+ "2.Ajouter une nouvelle pizza \n"
				+ "3.Mettre à jour une pizza \n"
				+ "4.Supprimer une pizza \n"
				+ "99.Sortir \n");


		Scanner ent = new Scanner(System.in);
		i = ent.nextInt();
	

		
			
			switch(i){
			
			// Menu Affichage Carte
				case(1) : System.out.print("Liste des pizzas \n\n");
				
				for (j=0; j<TableauPizza.length; j++){
					
					System.out.println(TableauPizza[j][0] + "-> " + TableauPizza[j][1] + " (" + TableauPizza[j][2] + "€)" );
					
					
				}
				
				
				break;
				
				
				
			// Menu Ajout Carte	
				case(2) : System.out.print("Ajout d'une nouvelle pizza \n\n");
				
				
				Object TableauPizzaT[][] = new Object[TableauPizza.length+1][3];
				
				// Réécriture Carte pizza
				
				for (j=0; j<TableauPizza.length;j++) {
					
					for (k=0; k<3 ; k++) {
						
						TableauPizzaT[j][k]=TableauPizza[j][k];
						
					}
					
					
				}
				
				// Enregistrement nouvelle entrée
				
				System.out.print("Veuillez saisir le code: ");
				
				ch = ent.next();
				
				TableauPizzaT[TableauPizza.length][0] = ch;
				
				
				System.out.print("Veuillez saisir le nom (sans espace): ");
				
				ch = ent.next();
				
				TableauPizzaT[TableauPizza.length][1] = ch;
				
				System.out.print("Veuillez saisir le prix: ");
				
				l = ent.nextFloat();
				
				TableauPizzaT[TableauPizza.length][2] = l;
				
				
				TableauPizza = TableauPizzaT;
				
				break;
				
				
				
				
				
				
				
			// Menu Modification Carte
				case(3) : System.out.print("Mise à jour d'une pizza \n\n");
				
// Affichage
				for (j=0; j<TableauPizza.length; j++){
					
					System.out.println(TableauPizza[j][0] + "-> " + TableauPizza[j][1] + " (" + TableauPizza[j][2] + "€)" );					
				}

// Choix modif				
					System.out.println("Veuillez choisir la pizza à modifier: ");
					ch = ent.next();
					
					for(j=0; j<TableauPizza.length ; j++){
						
						
												
						if (ch.equals(TableauPizza[j][0]) ){
						
// Enregistrement modif
							System.out.print("Veuillez saisir le code: ");
						
						ch = ent.next();
						
						TableauPizza[j][0] = ch;
						
						
						System.out.print("Veuillez saisir le nom (sans espace): ");
						
						ch = ent.next();
						
						TableauPizza[j][1] = ch;
						
						System.out.print("Veuillez saisir le prix: ");
						
						l = ent.nextFloat();
						
						TableauPizza[j][2] = l;
						}
						
						else
						continue;
					}
					
				
				break;
				
				
				
				
				
				case(4) : System.out.print("Suppression d'une pizza \n\n");
				break;
				
				case(99) : System.out.print("Au revoir :( \n\n");
				break;
				
			}
		
			
		}
		
		
		while (i!=99);
		
		}

}
