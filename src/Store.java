import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;



public class Store extends GamePanel implements ActionListener{

	/**
	 * @author johnny 
	 * 
	 * creates the panel that represents the users college app information, and a variety of colleges
	 */

	 
	private ArrayList<College> colleges;
	private Character student;
	private TabSwitcher ts;
	private JButton button1, button2, button3;
	private JButton counselor;
	private ImageIcon trollImage;
	private JButton trollButton;
	private ImageIcon storeArt;
	private JButton cramButton;
	private JLabel label;
	private JPanel panel2;
	
	/**
	 * Constructs a store object with the title of "Welcome to the store!"
	 * along with a border layout
	 */
	public Store(){
		
		super("Welcome to the Store! ");
		setLayout(new BorderLayout());

		
	}
	
	/**
	 * Constructs a store object with all of it's images and buttons that the 
	 * player can interact with
	 * @param ts the tab switcher that the player can use to switch tabs
	 * @param s the Character that the player is playing as
	 */
	public Store(TabSwitcher ts, Character s) {
		
		student = s;
		// TODO Auto-generated constructor stub
		this.ts = ts;
		
	
		
		storeArt = new ImageIcon(getClass().getResource("bookstore.jpg"));
		
		
		
		trollImage = new ImageIcon(getClass().getResource("trollface.jpg"));
		
		//System.out.println(student.getMoney());
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		//p.add(Box.createVerticalStrut(300));
		add(panel, BorderLayout.SOUTH);
		add(panel);
	
		JPanel panel2 = new JPanel();
		//add(panel2, BorderLayout.SOUTH);
		panel2.setLayout(new GridLayout(0, 1, 0, 0)	);
		
		button1 = new JButton("Buy SAT Prep Book($100)");
		button1.addActionListener(this);
		panel2.add(button1);		
		MaterialUIMovement.add(button1, MaterialColors.BLUE_200);
		
		
		// ap that they have 
		button2 = new JButton("Buy tutoring for AP Chemistry($50)");
		button2.addActionListener(this);
		panel2.add(button2);
		MaterialUIMovement.add(button2, MaterialColors.BLUE_200);
		
		
		button3 = new JButton("Buy online classes($100)");
		button3.addActionListener(this);
		panel2.add(button3);
		MaterialUIMovement.add(button3, MaterialColors.BLUE_200);

		counselor = new JButton("Buy College Counselor($300)");
		counselor.addActionListener(this);
		panel2.add(counselor);
		MaterialUIMovement.add(counselor, MaterialColors.BLUE_200);
		
		trollButton = new JButton("BRIBE COLLEGE OFFICIALS($500)");
		trollButton.addActionListener(this);
		panel2.add(trollButton);
		MaterialUIMovement.add(trollButton, MaterialColors.BLUE_200);
		
		cramButton = new JButton("Buy Cram Book ($50)");
		cramButton.addActionListener(this);
		panel2.add(cramButton);
		MaterialUIMovement.add(cramButton, MaterialColors.BLUE_200);
		// money is stored in this label but cannot be changed
		
		label = new JLabel("Lol: " + s.getMoney());
		panel2.add(label);
		add(panel2, BorderLayout.WEST);
		add(new JLabel(storeArt) , BorderLayout.EAST);
		
	}
	

	@Override
	/**
	 * Checks if the player has interacted with a button and does the action that
	 * corresponds with the certain button that is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(button1)) {
			
			if (student.getMoney() >= 100) {
				student.changeMoney(-100);
				System.out.println("alsdkjsa");
				
			} else {

				JOptionPane.showMessageDialog(this, "too broke :(");

			}
			// System.out.println(student.getMoney());
		}
		if (e.getSource().equals(button2)) {
			if (student.getMoney() >= 50) {
				student.changeMoney(-50);
				// System.out.println("alsdkjsa");

			} else {

				JOptionPane.showMessageDialog(this, "too broke :(");

			}
			// System.out.println(student.getMoney());
		}
		if (e.getSource().equals(button3)) {
			if (student.getMoney() >= 100) {
				student.changeMoney(-100);
				// System.out.println("alsdkjsa");

			} else {

				JOptionPane.showMessageDialog(this, "too broke :(");

			}
			// System.out.println(student.getMoney());
		}

		if (e.getSource().equals(counselor)) {
			if (student.getMoney() >= 300) {
				student.buyAdvisor();
				student.changeMoney(-300);
				JOptionPane.showMessageDialog(this, "Your college counselor will give you \nvaluable advice at various times of the year.");
				// System.out.println("alsdkjsa");

			} else {

				JOptionPane.showMessageDialog(this, "too broke :(");

			}
		}

		if (e.getSource().equals(cramButton)) {
			if (student.getMoney() > 50) {
				student.changeMoney(-50);

				student.buyCram();
				JOptionPane.showMessageDialog(this, "Cram book was bought");

			} else {

				JOptionPane.showMessageDialog(this, "too broke :(");

			}

		}

		if (e.getSource().equals(trollButton)) {
			if(student.getMoney() >= 500) {
				student.changeMoney(-500);
				JOptionPane.showMessageDialog(this, trollImage);
				JOptionPane.showMessageDialog(this, "SIKE");
			}else {
				JOptionPane.showMessageDialog(this, "too broke");
			}

		}

		this.repaint();

	}

	/**
	 * Displays the amount of money that the character has on the super paint component
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
		//g.drawImage(storeArt, -100, 0, 1000, 600, this);
		g.setColor(new Color(100, 255, 0));
	    g.drawString("Lol: " + student.getMoney(), 200, 300);
	   
		label.setText("Money: $" + student.getMoney());
		 
		
	    
	  }

}