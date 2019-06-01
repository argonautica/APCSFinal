
/**
 * @author william
 *
 */
public class LuckBasedEvent {

	private Character student;
	/**
	 * Constructs a new luck based event which either helps the player or makes tha game a bit harder
	 * @param c the character that the player is playing as
	 */
	public LuckBasedEvent(Character c) {
		student = c;
	}
	
	/**
	 * Displays a message describing the luck based event that the character encounters
	 * and changes the character's stats accordingly
	 * @return a message describing the even that the character has gone through
	 */
	public String getLuckEvent() {
		double d = Math.random() * 11;
		String[] unluckyEvents = {"You were sick :(", "You failed your pop quiz"};
		if(d < student.getLuck()) {
			int c = (int)(Math.random() * student.getClassesTaken().size());
			student.changeGPA(.05);
			return "You aced your test in " + student.getClassesTaken().get(c);
		}else {
			int f = (int)(Math.random() * unluckyEvents.length);
			student.changeGPA(-.05);
			return unluckyEvents[f];
		}
		
		
	}

	
}
