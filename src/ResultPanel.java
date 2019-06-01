import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.firebase.client.FirebaseClient.Student;
//import com.firebasetest.client.FirebaseClient;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class ResultPanel extends GamePanel implements ActionListener{
	
	private Character student;
	private JButton seeResults;
	private JLabel label;
	JLabel image, text;
	
	/**
	 * Creates a new tab displaying which colleges the player got into along with a celebratory gif
	 * @param c the character that the player plays as
	 */
	public ResultPanel(Character c){
		JPanel p = new JPanel();
		student = c;
		
		seeResults = new JButton("click to see your college results!");
		seeResults.addActionListener(this);
		
		
		
		
		p.setLayout(new BorderLayout(0, 0));
		
		
		
		p.add(seeResults , BorderLayout.NORTH);
		
		image = new JLabel(new ImageIcon(getClass().getResource("6ob.gif")));
		
		add(image , BorderLayout.CENTER);
		
		image.setLayout(new BorderLayout());
		
		setLayout(new GridBagLayout());
			label = new JLabel();
			String result = "You got into:";
		    boolean[] b = student.appResults();
		    for(int i = 0; i < b.length; i++){
		    	if(b[i]){
		    		result += " " + student.getAppliedSchools().get(i).getName();
		    		
		    	}
		    }
		    
			label.setFont(new Font("/fonts/NotoSans-Black.ttf", 2, 32));

		   
		   label.setText(result);
		   System.out.println(student.appResults().length);
		   
		   
		   
		   Student s1 = new Student(student.getName(), result.substring(14),student.getGPA(), student.getSAT(),  student.getEC(), student.getIQ(),student.getPersonality());
		   com.firebase.client.FirebaseClient d = new com.firebase.client.FirebaseClient();
		d.postStudentData(s1);
		List<Student> list = d.getStudentList();
		System.out.println(list.toString());
		    
		try {    
		    image.setVerticalTextPosition(JLabel.CENTER);
		    image.setHorizontalTextPosition(JLabel.CENTER);
		    
		    image.setText(result);
		 
			MaterialUIMovement.add(seeResults, MaterialColors.BLUE_200);
		}
		
		catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * Calls the super paint component
	 * 
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	  }
	    
	@Override
	/**
	 * Creates a new panel when the player clicks the get result button
	 */
	public void actionPerformed(ActionEvent arg0) {
		JFrame panel = new JFrame();
        panel.setSize(new Dimension(1000, 800));
     
	   /* System.out.println("ok");
		
	    String result = "You got into:";
	    boolean[] b = student.appResults();
	    for(int i = 0; i < b.length; i++){
	    	if(b[i]){
	    		JOptionPane.showMessageDialog(this, "you got into: " +  student.getAppliedSchools().get(i).getName());
	    		
	    	}
	    }*/
	   
	}
}
