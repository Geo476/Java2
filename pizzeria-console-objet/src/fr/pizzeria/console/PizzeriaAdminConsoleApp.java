package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
String nom;
/*
* Ci-dessous les variables sont declar�es en "Global"
* Cela permet d'y acc�der � partir de n'importe quelle fonction
*/
public static String[] menu = { // Phrases du menu principal
"***** Pizzeria Administration *****",
"1. Lister les pizzas",
"2. Ajouter une nouvelle pizza",
"3. Mettre a jour une pizza",
"4. Supprimer une pizza",
"99. Sortir",
};
public static Scanner reader = new Scanner(System.in);  // D�claration du "Reader" pour les saisies utilisateur
/*public static String[][] pizzas = { // Tableau r�pertoriant les pizzas
{"0", "PEP", "Peperoni", "12.50"},
{"1", "MAR", "Margherita", "14.00"},
{"2", "REI", "Reine", "11.50"},
{"3", "FRO", "4 fromages", "12.00"},
{"4", "CAN", "Cannibale", "12.50"},
{"5", "SAV", "Savoyarde", "13.00"},
{"6", "ORI", "Orientale", "13.50"},
{"7", "IND", "Indienne", "14.00"},
};*/
public static Pizza[] pizzas={new Pizza(0,"PEP","Peperoni",12.5),
new Pizza(1,"MAR","Margherita",14), 
new Pizza(2,"REI","Reine",11.5),
new Pizza(3,"FRO","4 fromages",12),
new Pizza(4,"CAN","Cannibale",12.5),
new Pizza(5,"SAV","Savoyarde",13),
new Pizza(6,"ORI","Orientale",13.5),
new Pizza(7,"IND","Indienne",14)};
/**
* Recopie int�gralement le tableau de pizzas
* En y ajoutant la pizza pass�e en param�tre
* La copie du tableau est alors affect�e au tableau initial
* Cela permet la cr�ation
* @param newPizza
*/

/**
* Recopie int�gralement le tableau de pizzas
* En laissant de c�t� la pizza dont le code est pass� en param�tre
* La copie du tableau est alors affect�e au tableau initial
* Cela permet la suppression
* @param code
*/
public static void removePizzaFromArray(String code) {

Pizza[] newMenu = new Pizza[pizzas.length - 1];
int index = 0;
for (int i = 0; i < pizzas.length; i++) {

if (!code.equals(pizzas[i].code)) {
for (int j = 0; j < 4; ++j) {
newMenu[index] = pizzas[i];
}
index++;
}
}
pizzas = newMenu;
}

/**
* Une fonction utile qui va permettre d'afficher le tableau de pizzas
* Format� en fonction des param�tres
* @param initial
* @param action
*/
public static void printPizzaList(boolean initial, String action) {

String separateur = initial ? " -> ": " - ";
for (Pizza p: pizzas) {
System.out.println(p.code + separateur + p.nom + " (" + p.prix + " €)");
}
System.out.println(Pizza.nbPizzas + " pizzas créées depuis l'initialisation du programme");
if (!initial) {
System.out.println("Veuillez choisir la pizza à " + action + ".");
System.out.println("(99 pour abandonner)."); 

}
}

/**
* La fonction qui va lancer la cr�ation d'une pizza
*/
public static void createPizza() {
Pizza[] newMenu = new Pizza[pizzas.length + 1];

for (int i = 0; i < pizzas.length; ++i) {
newMenu[i] = pizzas[i];
}

System.out.println("Veuillez saisir le code");
String code = reader.next();

System.out.println("Veuillez saisir le nom (sans espace)");
String name = reader.next();

System.out.println("Veuillez saisir le prix");
double price = reader.nextDouble();
newMenu[pizzas.length] = new Pizza(pizzas.length,code,name,price);

pizzas = newMenu;
}

/**
* Une fonction utile qui récup l'ID d'une pizza dans le tableau
* en fonction de son code
* @param code
* @return
*/
public static int getIdFromCode(String code) {

for(int i = 0; i < pizzas.length; i++) {
if (pizzas[i].code.equals(code))
return i;
}
return -1; 
}

/**
* La fonction qui affiche le menu de modification des pizzas en boucle
* Traitement des saisies utilisateur
*/
public static void updatePizza() {
while (true) {
printPizzaList(false, "modifier");

String code = reader.next();
Integer pizzaId = getIdFromCode(code);

if (pizzaId != -1) {
System.out.println("Veuillez saisir le code");
String newCode = reader.next();
pizzas[pizzaId].code = newCode;

System.out.println("Veuillez saisir le nom (sans espace)");
String name = reader.next();
pizzas[pizzaId].nom = name;

System.out.println("Veuillez saisir le prix");
double price = reader.nextDouble();
pizzas[pizzaId].prix = price;
break;
}
else if (code.equals("99")) {
break;
}
} 
}

/**
* La fonction qui affiche le menu de suppression des pizzas en boucle
* Traitement des saisies utilisateur
*/
public static void deletePizza() {

while (true) {
printPizzaList(false, "supprimer");

String code = reader.next();

if (code.equals("99")) {
break;
}
else if (getIdFromCode(code) != -1) {
removePizzaFromArray(code); 
break;
}
}
}

/**
* Affichage du message de fin de programme
*/
public static void printBye() {
System.out.println("Aurevoir :(");
}

/**
* La fonction qui affiche le menu principal en boucle
* Traitement des saisies utilisateur
*/
public static void printMenu() {

boolean flag = false;
while (!flag) {
for (String s: menu) {
System.out.println(s);
}

int choice = reader.nextInt();

switch (choice) {
case 1:
printPizzaList(true, null);
break;
case 2:
createPizza();
break;
case 3:
updatePizza();
break;
case 4:
deletePizza();
break;
case 99:
printBye();
flag = true;
break;
}
}
reader.close();
}

/**
* Point d'entr�e du programme
* On execute la fonction qui va afficher le menu principal
* en boucle
* @param args
*/
public static void main(String[] args) {
printMenu();
}
}
