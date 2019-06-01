import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * @author william
 *
 */
public class GameTimer extends TimerTask{

	private HighSchoolPanel jp;
	/**
	 * creates a gametimer
	 * @param p the high school panel to add a timer to 
	 * 
	 */
	public GameTimer(HighSchoolPanel p) {
		
		jp = p;
	}
	
	/** (non-Javadoc)
	 * 
	 * starts the timer
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		jp.changeTime(-1);
		jp.repaint();
		if(jp.getTime() == 0) {
			
			jp.getU().addApp();
		}
		
	}
}
