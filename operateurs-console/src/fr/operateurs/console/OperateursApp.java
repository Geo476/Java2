package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		
		System.out.print("***** Application Opérateurs ***** \n\n Veuillez saisir le premier nombre...");
		int i, j;
		int sum, dif, pdt, mod;
		float quo;
		
		Scanner sis = new Scanner(System.in);
		i = sis.nextInt();
		System.out.println("Veuillez saisir le second nombre...");
		
		j=sis.nextInt();
		
		
		sum = i+j;
		dif = i-j;
		pdt = i*j;
		quo = i/(float)j;
		mod = i%j;
			
		
		
		System.out.println(i + " + " + j + " = " + sum );
		System.out.println(i + " - " + j + " = " + dif );
		System.out.println(i + " * " + j + " = " + pdt );
		System.out.println(i + " / " + j + " = " + quo );
		System.out.println(i + " % " + j + " = " + mod );
		
		

	}

}
