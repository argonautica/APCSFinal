import javax.swing.JOptionPane;

/**
 * @author johnny 
 *
 */
public class CollegeAdvisor {

	private Character student;
	/**
	 * creates a college advisor object 
	 * @param s character to give advice to 
	 */
	public CollegeAdvisor(Character s) {
		student = s;
	}
	
	/**
	 * 
	 * gives advice to the student
	 * @return returns the string of advice based on the student's stats 
	 */
	public String getAdvice() {
		if (student.getGPA() < 3.5 && student.getSAT() < 1300) {
			return "your GPA is too low and your SAT score is suboptimal. Yeah definitely study";
		} else if (student.getGPA() < 3.5) {
			return "your GPA is too low. You need to study more!";
		} else if (student.getSAT() < 1300) {
			return "your SAT score is too low. Take it again!";
		} else if (student.getSAT() > 1300 && student.getGPA() > 3.5 && student.getEC() < 5) {
			return "your SAT score and GPA look great, but you're not doing enough extracurricular activities at school";
		}else {
			return "everything seems fine as is!";
		}
	}
}
