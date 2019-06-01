import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Timer;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

/**
 * @author skumar571
 *
 */
public class HighSchoolPanel extends GamePanel implements ActionListener {

	/**
	 * @author william 
	 * 
	 */

	private Character student;
	private JButton AP;
	private JButton study;
	private JButton sports;
	private JButton clubs;
	private JButton SAT;
	private int time;
	private ImageIcon charIcon;
	private JButton charButton;
	private WholeUI u;
	BorderLayout border;
	private JButton tr;
	private Timer t;
	private GameTimer theTimerTask;

	private ImageIcon schoolIcon;
	private JButton schoolButton;
	private JButton pauseButton;
	
	private JLabel label_6;
	private JLabel timeLeft;
	private int pauseClicks;
	private LuckBasedEvent randomEvents;
	
	
	/**
	 * 
	 * creates a high school panel object, which is one of the panels on which the game is displayed on
	 * @param ts the tab switcher fr the panel 
	 * @param s the character object for the game 
	 * @param u the ui manager for the game 
	 */
	public HighSchoolPanel(TabSwitcher ts, Character s, WholeUI u){
		JPanel p = new JPanel();

		p.setSize(super.HEIGHT, 200);
		time = 100;
		t = new Timer();
		theTimerTask = new GameTimer(this);
		if(time >= 0)
		timeLeft = new JLabel("Days left until college apps: " + time);
		p.add(timeLeft);
		pauseClicks = 0;
		
		student = s;
		randomEvents = new LuckBasedEvent(student);
		this.u = u;

		schoolIcon = new ImageIcon(getClass().getResource("School.jpg"));
		
		schoolButton = new JButton(schoolIcon);
		
		schoolButton.setContentAreaFilled(false);
		schoolButton.addActionListener(this);
		add(schoolButton, BorderLayout.EAST);

		if (student.getPersonality() > 80) {
			charIcon = new ImageIcon(getClass().getResource("CharacterIcon.jpg"));
		} else if (student.getPersonality() > 50) {
			charIcon = new ImageIcon(getClass().getResource("mehface.jpg"));
		} else if (student.getPersonality() > 20) {
			charIcon = new ImageIcon(getClass().getResource("sadface.jpg"));
		} else {
			charIcon = new ImageIcon(getClass().getResource("bigdepress.jpg"));
		}

		label_6 = new JLabel("");
		p.add(label_6);
		charButton = new JButton(charIcon);
//charButton.setBorder(BorderFactory.createEmptyBorder());
		charButton.setContentAreaFilled(false);
		charButton.addActionListener(this);

		SAT = new JButton("Take the SAT");
		SAT.setFont(new Font("/fonts/NotoSans-Black.ttf", 5, 15));

		SAT.addActionListener(this);

		add(p, BorderLayout.WEST);
		p.setLayout(new GridLayout(0, 1, 0, 0));
		p.add(charButton);

		/*
		 * 
		 * label_7 = new JLabel(""); p.add(label_7);
		 */
		AP = new JButton("Take AP Class");
		AP.addActionListener(this);
		p.add(AP);
		MaterialUIMovement.add(AP, MaterialColors.BLUE_200);

		sports = new JButton("Do school sports");
		sports.addActionListener(this);
		p.add(sports);
		MaterialUIMovement.add(sports, MaterialColors.BLUE_200);

		study = new JButton("study");
		study.addActionListener(this);
		p.add(study);

		MaterialUIMovement.add(study, MaterialColors.BLUE_200);

		clubs = new JButton("Join clubs");
		clubs.addActionListener(this);
		p.add(clubs);

		MaterialUIMovement.add(clubs, MaterialColors.BLUE_200);

		tr = new JButton("View Transcript");
		tr.addActionListener(this);
		p.add(tr);

		MaterialUIMovement.add(tr, MaterialColors.BLUE_200);

		p.add(SAT);

		MaterialUIMovement.add(SAT, MaterialColors.BLUE_200);
		
		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		p.add(pauseButton);
		MaterialUIMovement.add(pauseButton, MaterialColors.BLUE_200);

		
	}

	/** (non-Javadoc)
	 * 
	 * calls super paint component, and draws the timer
	 * @param g the graphics to draw on 
	 * @see GamePanel#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		
		  super.paintComponent(g); 
		
		  if(time >= 0) {
			  g.drawString("Days left till College Apps: " + time, 300, 900);
			  timeLeft.setText("Days left till College Apps: " + time);
		  }
		  
		  
		  g.setColor(Color.BLACK);
		    g.fillRect(250, 75, super.getWidth() * 3 / 8, super.getHeight() / 12);
		    
		    
		    g.drawString("Student's current Happiness level: " + student.getPersonality(), 250, 75);
		    g.setColor(Color.green);
		    g.fillRect(250, 75, student.getPersonality() * super.getWidth() * 3 / 8 / 100, super.getHeight() / 12);
		    
		    
		    
		  
		  
	}

	/** (non-Javadoc)
	 * generates specific output based on the action that is performed and displayes specific output 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @param e the event that is performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(time == 0) {
			  JOptionPane.showMessageDialog(this, "The year is almost over. Now you must apply to colleges! Good Luck!");
			  
		  }
		if (student.getPersonality() > 80) {
			charIcon = new ImageIcon(getClass().getResource("CharacterIcon.jpg"));
			charButton.setIcon(charIcon);
		} else if (student.getPersonality() > 50) {
			charIcon = new ImageIcon(getClass().getResource("mehface.jpg"));
		} else if (student.getPersonality() > 20) {
			charIcon = new ImageIcon(getClass().getResource("sadface.jpg"));
		} else {
			charIcon = new ImageIcon(getClass().getResource("bigdepress.jpg"));
		}
		

		if (time <= 1) {
			AP.removeActionListener(this);
			study.removeActionListener(this);
			sports.removeActionListener(this);
			clubs.removeActionListener(this);
			JOptionPane.showMessageDialog(this, "The year is almost over. Now you have to colleges! Good Luck!");
		
			u.addApp();
			u.switchToTab(4);
		}
		if (e.getSource().equals(AP)) {
			student.takeAP();
			student.changeIQ((int) (Math.random() * 5));
			student.changePersonality(-5);
			if(time > 3) {
				time-=3;
			}
			JOptionPane.showMessageDialog(this, "You are now taking : " + student.addAPClass());
//AP.removeActionListener(this);
		}
		if (e.getSource().equals(sports)) {
			student.addEC(2);
			student.changeIQ(-2);
			student.changeGPA(-0.05);
			student.changePersonality(5);
			if(time > 3) {
				time-=3;
			}
			//time--;
		}
		if (e.getSource().equals(study)) {
			if (student.getCram()) {
				student.changeIQ(3);
				student.changePersonality(-5);

			} else {
				student.changeIQ(2);
				student.changePersonality(-3);

			}

			student.changeGPA(Math.random() / 4);
			if(time > 3) {
				time-=3;
			}
			time--;
		}
		if (e.getSource().equals(clubs)) {
			student.addEC(1);
			student.changeIQ(2);
			student.changePersonality(2);
			if(time > 3) {
				time-=3;
			}
			//time--;
		}
		if (e.getSource().equals(SAT)) {
			int newSAT = student.takeSAT();
			student.changePersonality(-10);
			if (newSAT > student.getSAT()) {
				student.setSAT(newSAT);
			}
			if(time > 3) {
				time-=3;
			}
			//time--;
		}
		if (e.getSource().equals(schoolButton)) {
			
			int temp = (int)(student.getGPA() * 100);
			JOptionPane.showMessageDialog(this, "Your GPA: " + temp/100. + "\nYour SAT: " + student.getSAT());
			
			if(time > 3) {
				time-=3;
			}
		}

		if (e.getSource().equals(tr)) {

			u.addTr();
			u.switchToTab(4);
			JTable a = new JTable();

//	a.setLayout(new FlowLayout());

			String[][] data = { { "ac", "ask" }

			};

//a = new JTable(data);
			a.setVisible(true);

			add(a);

//JOptionPane.showMessageDialog(this, student.returnAP().toString());

		}

		if (e.getSource().equals(charButton)) {
			if (student.getPersonality() > 80) {
				JOptionPane.showMessageDialog(this,
						"your character feels happy \n this means that your character will perform \n on tests!");
			} else if (student.getPersonality() > 50) {
				JOptionPane.showMessageDialog(this, "your character is feeling okay");
			} else if (student.getPersonality() > 20) {
				JOptionPane.showMessageDialog(this,
						"your character is feeling kinda sad \n this might have a negative impact on\n your character's performance in school");
			} else {
				JOptionPane.showMessageDialog(this, "your character feels BIG DEPRESS \n HELP THEM OUT");
			}
		}

		if (time % 3 == 0 && time > 0 && student.advisorStatus()) {
			JOptionPane.showMessageDialog(this, student.getAdvisor().getAdvice());
		}

		if(time % 10 == 0 && time >=0) {
			JOptionPane.showMessageDialog(this, randomEvents.getLuckEvent());
		}
		
		if(e.getSource().equals(pauseButton)) {
			pauseClicks++;
			if(pauseClicks % 2 == 1) {
				
				
				AP.removeActionListener(this);
				study.removeActionListener(this);
				sports.removeActionListener(this);
				clubs.removeActionListener(this);
				
				t.cancel();
				t.purge();
				//System.out.println("Timer canceled");
				pauseButton.setText("Restart");
				
				
				
				
				
				
			}else {
				pauseButton.setText("Pause");
				startTimer();
				
				AP.addActionListener(this);
				study.addActionListener(this);
				sports.addActionListener(this);
				clubs.addActionListener(this);
				
				
				
				
			}
		}
		
		this.repaint();
		
		
	}

	/**
	 * starts the timer for this panel 
	 */
	public void startTimer() {
		t = new Timer();
		theTimerTask = new GameTimer(this);
		t.scheduleAtFixedRate(theTimerTask, 0, 1000);
	}
	
	
	
	/**
	 * increments time field of this object 
	 * @param t amount to increment the time by 
	 */
	public void changeTime(int t) {
		time += t;
	}
	
	/**
	 * returns the time of the timer
	 * @return returns the time field of this object
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * 
	 * returns the ui object 
	 * @return returns the ui object 
	 */
	public WholeUI getU() {
		return u;
	}
}