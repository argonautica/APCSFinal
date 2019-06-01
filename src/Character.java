import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
/**
 * @author skumar571
 *
 */
public class Character {

	private int money;
	private int iq;
	private int SAT_Score;
	private double essayScore;
	private int extracurricularIndex;
	
	private int happiness;
	
	//value 0 = the character is BIG DEPRESSED
	//value 100 = the user is happy
	
	
	private String name;
	private int personality;
	private double GPA;
	private ArrayList<College> collegesApplied;
	private boolean hasAdvisor;
	private CollegeAdvisor advisor;
	private int[] choices;
	private boolean cram;
	private ArrayList<String> classesTaken;
	private int luck;
	
	private HashMap<String, Boolean> apClasses;
	
	/**
	 * 
	 */
	public Character(){
		
		
		this.name = new String();
		collegesApplied = new ArrayList<College>();
		money = (int)(Math.random()*1000) + 500;
		iq = (int)(Math.random()*30) + 90;
		GPA = 3.0;
		extracurricularIndex = 0;
		SAT_Score = 1000;
		hasAdvisor = false;
		personality = 50;
		happiness = 50;
		advisor = new CollegeAdvisor(this);
		//luck is 0 for like super unlucky and 10 for very lucky
		luck = (int)(Math.random()*11);
		

		apClasses = new HashMap<>(); 
		
		apClasses.put("AP Research", false);
		apClasses.put("AP Seminar" 
				, false);
		apClasses.put("AP Art History" 
				, false);
		apClasses.put("AP Biology" 
				, false);
		apClasses.put("AP Calculus AB"
				, false);
		apClasses.put("AP Calculus BC" 
				, false);
		apClasses.put("AP Chemistry", false);
		apClasses.put("AP Chinese Language and Culture" 
				, false);
		apClasses.put("AP Computer Science A" 
				, false);
		apClasses.put("AP Computer Science Principles" 
				, false);
		apClasses.put("AP English Language and Composition" 
				, false);
		apClasses.put("AP English Literature and Composition" 
				, false);
		apClasses.put("AP Environmental Science" 
				, false);
		apClasses.put("AP European History" 
				, false);
		apClasses.put("AP French Language and Culture" 
				, false);
		apClasses.put("AP German Language and Culture" 
				, false);
		apClasses.put("AP Government and Politics (Comparative)" 
				, false);
		apClasses.put("AP Government and Politics (US)" 
				, false);
		apClasses.put("AP Human Geography" 
				, false);
		apClasses.put("AP Italian Language and Culture" 
				, false);
		apClasses.put("AP Japanese Language and Culture" 
				, false);
		apClasses.put("AP Latin" 
				, false);
		apClasses.put("AP Macroeconomics"  
				, false);
		apClasses.put("AP Microeconomics" 
				, false);
		apClasses.put("AP Music Theory" 
				, false);
		apClasses.put("AP Physics 1: Algebra-Based" 
			 , false);
		apClasses.put("AP Physics 2: Algebra-Based" 
				, false);
		apClasses.put("AP Physics C: Electricity and Magnetism" 
				, false);
		apClasses.put("AP Physics C: Mechanics" 
				, false);
		apClasses.put("AP Psychology" 
				, false);
		apClasses.put("AP Spanish Language and Culture" 
				, false);
		apClasses.put("AP Spanish Literature and Culture" 
				, false);
		apClasses.put("AP Statistics" 
				, false);
		apClasses.put("AP Studio Art Drawing" 
				, false);
		apClasses.put("AP Studio Art 2-D Design" 
				, false);
		apClasses.put("AP Studio Art 3-D Design" 
				, false);
		apClasses.put("AP US History" 
				, false);
		apClasses.put("AP World History"  
			, false);
		
		
		
		cram = false;
		
		choices = new int[6]; 
		
		
		classesTaken = new ArrayList<>();
		classesTaken.add("Biology");
		classesTaken.add("PE 9");
		classesTaken.add("Literature and Writing");

		
	}
	
	/*
	 * choices
	 * 
	 * ap classes
	 * 
	 * 
	 */
	
	/**
	 * @return returns the random ap class that was added to the student's transcript and list of classes
	 */
	public String addAPClass() {
		
		
				ArrayList<String> keysAsArray = new ArrayList<String>(apClasses.keySet());
				Random r = new Random();
				
				String s = keysAsArray.get(r.nextInt(keysAsArray.size()));
				
				apClasses.remove(s);
				
				
				classesTaken.add(s);
				
				System.out.println(s);

				return s;
				
				
	}
	
	
	public String getName() {
		
		
		return name;
	}
	
	
	/**
	 * @return returns the letter grade for a class based on the student's gpa
	 */
	public String getLetterGrade() {
		String grade;
		if (getGPA() > 4) {
			if (Math.random() < (getGPA() - 4.0)) {
				return "A";
			} else {
				return "B";
			}
		} else if (getGPA() > 3) {

			if (Math.random() < (getGPA() - 3.0)) {

				return "C";
			} else {

				return "D";
			}

		} else if (getGPA() > 2) {

			if (Math.random() < (getGPA() - 2.0)) {

				return "C";
			} else {

				return "D";
			}
		} else {
			return "F";
		}
		

	}
	
	
	
	public void setName(String name) {
		
		
		this.name = name;
	}
	
	/**
	 * @return returns the string array full of student's ap classes
	 */
	public ArrayList<String> returnAP(){
		return classesTaken;
	}
	
	/**
	 * @return returns the "luck" stat of the student
	 */
	public int getLuck() {
		return luck;
	}
	
	/**
	 * returns whether cram book is owned
	 * @return true or false whether the student owns the cram book 
	 */
	public boolean getCram() {
		
		return cram;
	}
	
	/**
	 * buys a cram book 
	 */
	public void buyCram() {
		
		cram = true;
	}
	
	/**
	 * @return returns the "happiness" stat of the character
	 */
	public int getHappiness() {
		
		return happiness;
	}
	/**
	 * buys an advisor 
	 */
	public void buyAdvisor(){
		hasAdvisor = true;
	}
	
	/**
	 * @return returns true or false whether student owns the advisor 
	 */
	public boolean advisorStatus() {
		return hasAdvisor;
	}
	
	/**
	 * @return returns the advisor 
	 */
	public CollegeAdvisor getAdvisor() {
		return advisor;
	}
	/**
	 * @return returns the "personality" stat of the character
	 */
	public int getPersonality(){
		return personality;
	}
	/**
	 * changes the personality stat of the character
	 * @param n amount to increment personality by 
	 */
	public void changePersonality(int n){
		personality += n;
		if(personality < 0){
			personality = 0;
		}
		if(personality > 100){
			personality = 100;
		}
	}
	
	/**
	 * 
	 * changes the amount of money the user has
	 * @param amount the amount to increment the character's money field buy
	 */
	public void changeMoney(int amount){
		money += amount;
	}
	/**
	 * return's the character's money 
	 * @return money that user has
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * returns the gpa of the character
	 * @return returns the character's gpa field
	 */
	public double getGPA(){
		return GPA;
	}
	
	/**
	 * 
	 *returns the sat score of the character
	 * @return the sat score of the user
	 * 
	 */
	public int getSAT(){
		return SAT_Score;
	}
	/**
	 * 
	 * generate a sat score based on the user's iq 
	 * @return returns the result of a new sat test taken 
	 */
	public int takeSAT(){
		int result = (int)(((double)iq/130)*1550 + Math.random()*50);
		if(result >= 1600){
			return 1600;
		}else{
			return (result/10)*10;
		}
	}
	
	/**
	 * returns the iq field of the user
	 * @return iq stat of the user
	 */
	public int getIQ(){
		return iq;
	}
	/**
	 * adds extracurriculars to user
	 * @param e increments the extracurricular index of the user
	 */
	public void addEC(int e){
		extracurricularIndex += e;
	}
	/**
	 * 
	 *  returns the amount of extracurriculars the character has
	 * @return returns the extracurricular index field of the user
	 */
	public int getEC(){
		return extracurricularIndex;
	}
	
	/**
	 * sets the character's sat field to the new store
	 * @param s new sat score
	 */
	public void setSAT(int s){
		SAT_Score = s;
	}
	
	/**
	 * 
	 * adds college to list of apps
	 * @param c college that application has been created to 
	 */
	public void addCollegeApp(College c){
		collegesApplied.add(c);
	}
	
	/**
	 * boosts gpa based on tutoring 
	 * 
	 */
	public void getTutoring(){
		double newGPA = GPA + 0.5*Math.random();
		if(newGPA < 5.0){
			GPA = newGPA;
		}
	}
	
	/**
	 * 
	 * changes the character's iq stat by b
	 * @param b the amount to increment iq by
	 */
	public void changeIQ(int b){
		iq = iq + b;
	}
	/**
	 * 
	 * changes the gpa field by set amount
	 * @param amt amount to change gpa by
	 */
	public void changeGPA(double amt){
		double newGPA = GPA + amt;
		if(newGPA < 5.0){
			GPA = newGPA;
		}
	}
	/**
	 * shows the list of colleges that character applies to 
	 * @return returns the arraylist of schools that character has applied to 
	 */
	public ArrayList<College> getAppliedSchools(){
		return collegesApplied;
	}
	/**
	 * adds a random ap class to the student's transcript, taking it out of the list of ap classes. It also changes gpa based on the student's iq
	 */
	public void takeAP(){
		double d = Math.random();
		if(iq > 125){
			changeGPA(0.06);
		}else if(iq > 115){
			if(d > 0.2){
				changeGPA(0.06);
			}else{
				changeGPA(-0.10);
			}
		}else if(iq > 105){
			if(d > 0.7){
				changeGPA(0.06);
			}else{
				changeGPA(-0.10);
			}
		}else{
			changeGPA(-0.10);
		}
		
	}
	
	/**
	 * returns the colleges that the student got into 
	 * @return the results of the college applications
	 */
	public boolean[] appResults(){
		boolean[] result = new boolean[collegesApplied.size()];
		for(int i = 0; i < result.length; i++){
			result[i] = collegesApplied.get(i).gotIn(this);
		}
		return result;
	}
	
	/**
	 * returns all the classes that the student has taken/is taking 
	 * @return arraylist with the list of the classes on the student's transcript
	 */
	public ArrayList<String> getClassesTaken(){
		return classesTaken;
	}
}