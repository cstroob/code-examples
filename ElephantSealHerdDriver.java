package Project03;

import java.util.Scanner;

/**

 * Main driver class for <code>Herd</code> allowing the user to input 

 * data on elephant seal herd via <code>Scanner</code>. Outputs and updates full <code>ArrayList</code>

 * with all data user has entered and prompts user after each entry to add entry, remove entry, or exit.

 * Also outputs average weight, average age, largest and smallest elephant seals, and oldest and youngest

 * elephant seals. Terminates input stream when completed.

 * 

 * @author carterstrubbe

 * Project03

 * Date: 2022-02-17

 * Due date: 2022-02-16

 */

public class ElephantSealHerdDriver {

	private static Scanner kb;

	private static Herd herd;

	public static void main(String[] args) {	

		// initialize scanner

		kb = new Scanner(System.in);

		herd = new Herd();	

		System.out.println("New Zealand Wildlife: Elephant Seals");

		System.out.println();	

		boolean exit = false;

		do {

			if(herd.getSize() == 0) {

				System.out.println("Please enter the name, age, and weight of the first "

						+ "Elephant Seal, in that order, separated with a space: "

						+ "[Example. Joe 8 541.7]");

				herd.addElephantSeal(kb.next(), kb.nextInt(), kb.nextDouble());

			} else {

				System.out.println("Herd Data:");

				System.out.println();

				System.out.println("Name:     Age:    Weight:");

				System.out.println(herd.toString());

				System.out.println();

				System.out.println("Largest Elephant Seal: " + herd.largestElephantSeal().getName() + ", Weight: " + herd.largestElephantSeal().getWeight());

				System.out.println("Smallest Elephant Seal: " + herd.smallestElephantSeal().getName() + ", Weight: " + herd.smallestElephantSeal().getWeight());

				System.out.println("Youngest Elephant Seal: " + herd.youngestElephantSeal().getName() + ", Age: " + herd.youngestElephantSeal().getAge());

				System.out.println("Oldest Elephant Seal: " + herd.oldestElephantSeal().getName() + ", Age: " + herd.oldestElephantSeal().getAge());

				System.out.println("Average Weight: " + herd.averageWeight());

				System.out.println("Average Age: " + herd.averageAge());

				System.out.println();

				System.out.println();

				System.out.println("Please choose from the following options:");

				System.out.println("Add new Elephant Seal[Enter 1]");

				System.out.println("Remove an Elephant Seal[Enter 2]");

				System.out.println("Exit Program[Enter 0]");

				System.out.println();		

				int option = kb.nextInt();	

				if(option == 0) {

					exit = true;

				} else if(option == 1) {

					System.out.println("Please enter the name, age, and weight of the next "

							+ "Elephant Seal, in that order, separated with a space: "

							+ "[Example. Joe 8 541.7]");

					herd.addElephantSeal(kb.next(), kb.nextInt(), kb.nextDouble());

				} else {

					System.out.println("Please enter the name of the elephant seal you would like to remove: ");

					herd.removeElephantSeal(kb.next());

				} // Ending bracket of nested if			

			} // Ending bracket of if

		} while(exit == false);		

		// Close input stream

		kb.close();

	} // Ending bracket of method main

} // Ending bracket of class ElephantSealHerdDriver
