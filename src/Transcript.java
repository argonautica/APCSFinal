import java.awt.Component;
import java.awt.Graphics;

import javax.rmi.CORBA.StubDelegate;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * @author sidharth
 *
 */
public class Transcript extends GamePanel {

	JTable table;
	DefaultTableModel model;
	
	Character t;
	
	/**
	 * Constructs a new transcript object and displays the character's courses and his/hers grade in said courses
	 * @param s the character that the player is playing as
	 */
	public Transcript(Character s ) {
		
		
		String[] colHeadings = {"Class","Grade"};
		int numRows = s.returnAP().size() ;
		model = new DefaultTableModel(numRows, colHeadings.length) ;
		model.setColumnIdentifiers(colHeadings);
		
		t = s;
		
		table = new JTable(model);
		
		
	}
	
	
	/**
	 * Creates the table in which the courses and grades are shown
	 */
	public void TableSet() 
	
	{
		
		
		
		String[] colHeadings = {"Class","Grade"};
		int numRows = t.returnAP().size() ;
		 model = new DefaultTableModel(numRows, colHeadings.length) ;
		model.setColumnIdentifiers(colHeadings);
		
	
		
		
		
		
		 table = new JTable(model);

		
	/*	table.setValueAt("Class", 0, 0);
		table.setValueAt("Grade", 1, 0);*/
		
		int i = 0;
		for ( String s : t.returnAP()) {
			
			
			table.setValueAt(s, i, 0);
			
			
			table .setValueAt(t.getLetterGrade(), i, 1);
			
			
			i++;
			
			
			
		}
		
		
		
		
	}
	
	
	
	/**
	 * Creates a table
	 * @see GamePanel#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	  {
		//super.paintComponent(g);
		

		
		TableSet();
	//	remove(table);
		
	 add(new JScrollPane(table));	
	 
	 
	 
		
	  
	  }
	
	
}