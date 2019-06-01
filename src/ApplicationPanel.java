import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import java.awt.GridLayout;


public class ApplicationPanel extends GamePanel implements ActionListener{

	/**
	 * @author william
	 * 
	 * creates the panel that represents the user�s college app information, and a variety of colleges
	 */

	 
	private ArrayList<College> colleges;
	private Character student;
	private TabSwitcher ts;
	private boolean appDone;
	private WholeUI u;
	
	private JButton button1, button2, button3, button4, button5, button6, button7;
	private JButton submitButton;
	private JLabel moneyLabel;
	
	/**
	 * @param ts the tab switcher that allows to add and switch tabs
	 * @param s player's character in the game 
	 * @param u sets up tabs and manages them 
	 */
	public ApplicationPanel(TabSwitcher ts, Character s, WholeUI u) {
		appDone = false;
		this.u = u;
		// TODO Auto-generated constructor stub
		this.ts = ts;
		student = s;
		moneyLabel = new JLabel("money: $" + student.getMoney());
		
		
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0, 1, 0, 0));
		p.add(moneyLabel);
		//p.add(Box.createVerticalStrut(300));
		colleges = new ArrayList<College>();
		
		
		// add the ec 
		
		colleges.add(new College("Barvard", 1600, 4.0, 0.7, 5, 100));
		
		colleges.add(new College("WestEastern", 1300, 3.7, 0.2, 50));
		colleges.add(new College("De Anza", 0, 0, 0, 10));
		
		
		
		
		colleges.add(new College("MIT", 1600, 4.3, .7,  5, 90));
		colleges.add(new College("Duke" , 1400, 3.5, .6, 8, 70));
		colleges.add(new College("UCB", 1550, 4.0, .7, 3,  90));
		button1 = new JButton("Barvard($100)");
		button1.addActionListener(this);
		p.add(button1);
		MaterialUIMovement.add(button1, MaterialColors.BLUE_200);
		
		
		
		
		button4 = new JButton("MIT($100)");
		button4.addActionListener(this);
		p.add(button4);
		MaterialUIMovement.add(button4, MaterialColors.BLUE_200);
		
		
		button5 = new JButton("Duke($70)");
		button5.addActionListener(this);
		p.add(button5);
		MaterialUIMovement.add(button5, MaterialColors.BLUE_200);
		
		button6 = new JButton("UCB($90)");
		button6.addActionListener(this);
		p.add(button6);
		MaterialUIMovement.add(button6, MaterialColors.BLUE_200);
		
		button2 = new JButton("State College($50)");
		button2.addActionListener(this);
		p.add(button2);
		MaterialUIMovement.add(button2, MaterialColors.BLUE_200);
		
		button3 = new JButton("Community College($10)");
		button3.addActionListener(this);
		p.add(button3);
		MaterialUIMovement.add(button3, MaterialColors.BLUE_200);
		
		submitButton = new JButton("Submit Applications?");
		submitButton.addActionListener(this);
		p.add(submitButton);
		MaterialUIMovement.add(submitButton, MaterialColors.BLUE_200);
		add(p);
		
		
	}
	
	/**
	 * Displays a list of colleges and gives the option of applying
	 * @param p the PApplet the panel is drawn in
	 */


	public boolean appCompleted(){
		return appDone;
	}
	
	/** (non-Javadoc)
	 * 
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @param e the actionevent that takes place
	 *
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button1)){
			if (student.getMoney() >= 100) {
				student.changeMoney(-100);
				//System.out.println(student.getMoney());
				student.addCollegeApp(colleges.get(0));
				button1.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		if(e.getSource().equals(button2)){
			if(student.getMoney() >= 50) {
				student.changeMoney(-50);
				//System.out.println(student.getMoney());
				student.addCollegeApp(colleges.get(1));
				button2.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		if(e.getSource().equals(button3)){
			if(student.getMoney() >= 10) {
				student.changeMoney(-10);
				student.addCollegeApp(colleges.get(2));
				button3.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		if(e.getSource().equals(button4)){
			if(student.getMoney() >= 90) {
				student.changeMoney(-90);
				student.addCollegeApp(colleges.get(3));
				button4.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		if(e.getSource().equals(button5)){
			if(student.getMoney() >= 70) {
				student.changeMoney(-70);
				student.addCollegeApp(colleges.get(4));
				button5.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		
		if(e.getSource().equals(button6)){
			if(student.getMoney() >= 90) {
				student.changeMoney(-90);
				student.addCollegeApp(colleges.get(5));
				button6.removeActionListener(this);
			}else {
				JOptionPane.showMessageDialog(this, "too broke :(");
			}
		}
		
		
		
		
		
		if(e.getSource().equals(submitButton)){
			int answer = JOptionPane.showConfirmDialog(this, "Submit Your Applications?");
			if (answer == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Click to the Result Panel to discover your college decisions");
				appDone = true;
			//	System.out.println(");
				u.addResult();
			}
		}
		moneyLabel.setText("Money: $" + student.getMoney());
	}

	/** (non-Javadoc)
	 * @see GamePanel#paintComponent(java.awt.Graphics)
	 * 
	 * @param g the graphics to draw
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	   
	    
	  
	  }
}
