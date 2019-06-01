import java.awt.event.*;	
import javax.swing.*;

import mdlaf.*;
import mdlaf.animation.*;
import javax.swing.*;
import java.awt.*;

import java.awt.*;

/**
 * @author sidharth
 *
 */
public class Main extends JFrame {

	
	private static WholeUI tabPanel;
	private Character student;
	
	/**
	 * Creates a new window as well as a new character the player will play as. The window
	 * can close on demand and has a tab panel.
	 * @param title the title of the window
	 */
	public Main(String title) {
		
		

		super(title);
		student = new Character();
		
		
		setBounds(100, 100, 1200, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    
	 //   ApplicationPanel a = new ApplicationPanel();
	    tabPanel = new WholeUI(student);
	    
	    add(tabPanel);
	  
	    
	    
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		
		try { 
		    UIManager.setLookAndFeel(new MaterialLookAndFeel ());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		Main w = new Main("College App Sim 2019");
		
		
	}
  
}