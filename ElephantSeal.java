package Project03;

/**

 * Class storing data related to each individual elephant seal.

 * Utilizes methods to get and set name, age, and weight of the seals as 

 * well as compare methods.

 * @author carterstrubbe

 *

 */

public class ElephantSeal {

	private String name;

	private int age;

	private double weight;

	/**

	 * Constructor.

	 * Sets values to prevent null values

	 */

	public ElephantSeal() {

		this.setName("");

		this.setAge(0);

		this.setWeight(0);

	} // Ending bracket of default no args constructor

	/**

	 * Constructor

	 * @param newName value of <code>name</code> to be set to

	 * @param newAge value of <code>age</code> to be set to

	 * @param newWeight value of <code>weight</code> to be set to

	 */

	public ElephantSeal(String newName, int newAge, double newWeight) {

		this.setName(newName);

		this.setAge(newAge);

		this.setWeight(newWeight);

	} // Ending bracket of constructor

	/**

	 * Accessor method to get the <code>name</code>

	 * @return String the value of <code>name</code>

	 */

	public String getName() {

		return this.name;

	} // Ending bracket of method getName

	/**

	 * Mutator method to set the <code>name</code>

	 * @param newName the value of <code>name</code> to be set.

	 */

	public void setName(String newName) {

		this.name = newName;

	} // Ending bracket of method setName	

	/**

	 * Accessor method to get the <code>age</code>

	 * @return int the value of <code>age</code>

	 */

	public int getAge() {

		return this.age;

	} // Ending bracket of method getAge

	/**

	 * Mutator method to set the <code>age</code>

	 * @param newAge the value of <code>age</code> to be set.

	 */

	public void setAge(int newAge) {

		this.age = newAge;

	} // Ending bracket of method setAge

	/**

	 * Accessor method to get the <code>weight</code>

	 * @return double the value of <code>weight</code>

	 */

	public double getWeight() {

		return this.weight;

	} // Ending bracket of method getWeight

	/**

	 * Mutator method to set the <code>weight</code>

	 * @param newWeight the value of <code>weight</code> to be set.

	 */

	public void setWeight(double newWeight) {

		this.weight = newWeight;

	} // Ending bracket of method setWeight

	/**

	 * Method to compare the <code>name</code> of two elephant seals.

	 * @param nameComparedTo the String to compare the other name to.

	 * @return Boolean true or false indicating if names are the same.

	 */

	public boolean compareName(String nameComparedTo) {

		return this.getName().equals(nameComparedTo);

	} // Ending bracket of method compareName	

	/**

	 * Method to compare the <code>name</code> of two elephant seals.

	 * @param sealComparedTo the other seal to compare to

	 * @return -1, 0, or 1 depending on how the comparison goes

	 */

	public int compareTo(ElephantSeal sealComparedTo) {

		return this.getName().compareTo(sealComparedTo.getName());

	} // Ending bracket of method compareTo	

	@Override

	/**

	 * Method to translate data of elephant seal to a <code>String</code>.

	 * @return the <code>toString</code> value of the elephant seal.

	 */

	public String toString() {

		String temp;

		temp = String.format("%-10s %-5s %-9s\n", this.getName(), this.getAge(), 

				this.getWeight());

		return temp;

	} // Ending bracket of method toString

} // Ending bracket of class ElephantSeal
