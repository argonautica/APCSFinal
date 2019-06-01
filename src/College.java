
/**
 * @author william
 *
 */

public class College {

	private String name;
	private int SAT;
	private double GPA;
	// 1 if very random, 0 if not random at all
	private double randomness;
	private int appFee;
	private int ec;

	/**
	 * Creates a college object with a given name
	 * 
	 * @param name
	 *            the name of the college
	 */
	public College(String name, int SAT, double grades, double rand, int fee) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.SAT = SAT;
		GPA = grades;
		randomness = rand;
		appFee = 100;
		ec = 0;
	}

	/**
	 * creates a college object with the name of the college, the minimum sat,
	 * grades and ecs required, the price of the application, and the randomness of
	 * acceptance
	 * 
	 * @param name
	 *            the name of the character
	 * @param SAT
	 *            the sat score required for the sat
	 * @param grades
	 *            the gpa required for acceptance to the school
	 * @param rand
	 *            randomness of acceptance for the school
	 * @param ecs
	 *            amount of extracurriculars required for entrance
	 * @param fee
	 *            price of the college application
	 */
	public College(String name, int SAT, double grades, double rand, int ecs, int fee) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.SAT = SAT;
		GPA = grades;
		randomness = rand;
		appFee = 100;
		ec = ecs;
	}

	/**
	 * returns whether the student gets into the school or not
	 * 
	 * @param c
	 *            the character that is applying
	 * @return boolean whether the student gets in or not
	 */
	public boolean gotIn(Character c) {

		if (c.getGPA() >= GPA && c.getGPA() >= GPA && c.getEC() >= ec && c.getSAT() >= SAT) {

			double d = Math.random() * randomness;

			return ((1 - randomness) + d > .5);

		} else {
			return false;
		}
	}

	/**
	 * returns the name of the college
	 * 
	 * @return returns the name of the college
	 */
	public String getName() {
		return name;
	}
}
