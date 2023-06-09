package Project03;

import java.util.ArrayList;

/**

 * Class for organizing <code>ElephantSeal</code> data input by the user into an <code>ArrayList</code>.

 * Allows user to add and remove data, get averages, smallest and largest, oldest and youngest,

 * and other information relating to the ElephantSeals in the list. 

 * @author carterstrubbe

 *

 */

public class Herd {

	private ArrayList<ElephantSeal> herd;	

	/**

	 * Constructor.

	 * Initializes the <code>ArrayList</code> to be filled with <code>ElephantSeal</code>s.

	 */

	public Herd() {

		this.herd = new ArrayList<ElephantSeal>();

	} // Ending bracket of constructor

	/**

	 * Method allowing <code>ElephantSeal</code> data to be added to <code>herd</code> ArrayList.

	 * @param newName the name to be set for this element at next index of <code>herd</code> ArrayList.

	 * @param newAge the age to be set for this element at next index of <code>herd</code> ArrayList.

	 * @param newWeight the weight to be set for this element at next index of <code>herd</code> ArrayList.

	 */

	public void addElephantSeal(String newName, int newAge, double newWeight) {

		ElephantSeal temp = new ElephantSeal(newName, newAge, newWeight);

		herd.add(temp);

	} // Ending bracket of method addElephantSeal

	/**

	 * Method allowing <code>ElephantSeal</code> data to be added to <code>herd</code> ArrayList.

	 * @param newElephantSeal the <code>ElephantSeal</code> to be set at next index of <code>herd</code> ArrayList.

	 */

	public void addElephantSeal(ElephantSeal newElephantSeal) {

		herd.add(newElephantSeal);

	} // Ending bracket of method addElephantSeal

	/**

	 * Takes the sum of the ages for all elements of <code>herd</code> and divides by size of <code>herd</code>.

	 * @return int value equal to average of all ages

	 */

	public int averageAge() {

		int sum = 0;

		int average;

		for(int i = 0; i < herd.size(); ++i) {

			sum += herd.get(i).getAge();

		} // Ending bracket of for loop

		average = sum / herd.size();	

		return average;

	} // Ending bracket of method averageAge

	/**

	 * Takes the sum of the weights for all elements of <code>herd</code> and divides by size of <code>herd</code>.

	 * @return int value equal to average of all weights

	 */

	public int averageWeight() {

		int sum = 0;

		int average;

		for(int i = 0; i < herd.size(); ++i) {

			sum += herd.get(i).getWeight();

		} // Ending bracket of for loop

		average = sum / herd.size();	

		return average;

	} // Ending bracket of method averageWeight

	/**

	 * Method to get ElephantSeal at a given index of <code>herd</code>.

	 * @param index the index of which we are referencing

	 * @return ElephantSeal equal to <code>herd</code> at the given index.

	 */

	public ElephantSeal getElephantSeal(int index) {

		return herd.get(index);

	} // Ending bracket of method getElephantSeal

	/**

	 * Total amount of ElephantSeals within <code>herd</code>.

	 * @return int equal to value of the size of the ArrayList.

	 */

	public int getSize() {

		return herd.size();

	} // Ending bracket of method getSize

	/**

	 * Method to find a specific ElephantSeal given a String name.

	 * Utilizes the compareName method of ElephantSeal to compare the String

	 * entered with the names of the <code>herd</code> ArrayList.

	 * @param name String of ElephantSeal being compared to <code>herd</code>.

	 * @return ElephantSeal equal to the String entered

	 */

	public ElephantSeal findElephantSeal(String name) {

		ElephantSeal rv = null;

		for(int i = 0; i < herd.size(); ++i) {

			if ((herd.get(i)).compareName(name)) {

				rv = herd.get(i);

			} // Ending bracket of if

		} // Ending bracket of for loop	

		return rv;

	} // Ending bracket of method findElephantSeal	

	/**

	 * Method to find largest(heaviest) ElephantSeal in <code>herd</code>.

	 * Utilizes a for loop to compare each element to the next in order

	 * and stores the largest in rv.

	 * @return ElephantSeal with the largest weight.

	 */

	public ElephantSeal largestElephantSeal() {

		ElephantSeal rv = herd.get(0);

		for(int i = 1; i < herd.size(); ++i) {

			if(herd.get(i).getWeight() > rv.getWeight()) {

				rv = herd.get(i);

			} // Ending bracket of if

		} // Ending bracket of for loop		

		return rv;

	} // Ending bracket of class largestElephantSeal

	/**

	 * Method to find the oldest ElephantSeal in <code>herd</code>.

	 * Utilizes a for loop to compare each element to the next in order

	 * and stores the highest in rv.

	 * @return ElephantSeal with the highest age.

	 */

	public ElephantSeal oldestElephantSeal() {

		ElephantSeal rv = herd.get(0);

		for(int i = 1; i < herd.size(); ++i) {

			if(herd.get(i).getAge() > rv.getAge()) {

				rv = herd.get(i);

			} // Ending bracket of if

		} // Ending bracket of for loop

		return rv;

	} // Ending bracket of class oldestElephantSeal

	/**

	 * Method to remove an ElephantSeal from <code>herd</code>.

	 * Utilizes the compareName method of ElephantSeal class.

	 * @param name String being compared to each element of <code>herd</code>

	 * to be removed.

	 */

	public void removeElephantSeal(String name) {

		for(int i = 0; i < herd.size(); ++i) {

			if(herd.get(i).compareName(name)) {

				herd.remove(i);

			} // Ending bracket of if

		} // Ending bracket of for loop

	} // Ending bracket of method removeElephantSeal	

	/**

	 * Method to find the smallest ElephantSeal in <code>herd</code>.

	 * Utilizes a for loop to compare each element to the next in order

	 * and stores the smallest in rv.

	 * @return Elephant seal with the lowest weight.

	 */

	public ElephantSeal smallestElephantSeal() {

		ElephantSeal rv = herd.get(0);

		for(int i = 1; i < herd.size(); ++i) {

			if(herd.get(i).getWeight() < rv.getWeight()) {

				rv = herd.get(i);

			} // Ending bracket of if

		} // Ending bracket of for loop		

		return rv;

	} // Ending bracket of method smallestElephantSeal	

	@Override

	/**

	 * Standard method to convert all elements of <code>herd</code>

	 * to a string.

	 */

	public String toString() {

		return herd.toString();

	} // Ending bracket of method toString	

	/**

	 * Method to find the youngest ElephantSeal in <code>herd</code>.

	 * Utilizes a for loop to compare each element to the next in order

	 * and stores the lowest age in rv.

	 * @return ElephantSeal with the lowest age.

	 */

	public ElephantSeal youngestElephantSeal() {

		ElephantSeal rv = herd.get(0);

		for(int i = 1; i < herd.size(); ++i) {

			if(herd.get(i).getAge() < rv.getAge()) {

				rv = herd.get(i);

			} // Ending bracket of if

		} // Ending bracket of for loop

		return rv;

	} // Ending bracket of method youngestElephantSeal
