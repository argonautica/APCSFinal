import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import com.firebase.client.FirebaseClient;
import com.firebase.client.FirebaseClient.Student;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import java.awt.GridLayout;

/**
 * @author sid
 *
 */
public class Leaderboard extends GamePanel implements ActionListener {

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private List<Student> studentList = new ArrayList<>();
	private final FirebaseClient client;

	private TabSwitcher ts;

	private JTextField txtClassLeaderboards;

	private WholeUI u;

	/**
	 * 
	 * class used to display the leaderboard containing all the stats of users who play the game 
	 * creates panel with title, refresh button and the table that contains the stats of other students
	 * @param t tabswitcher to switch between tabs
	 * @param u whole ui manager used to manage panels and tabs
	 */
	public Leaderboard(TabSwitcher t, WholeUI u) {
		client = new com.firebase.client.FirebaseClient();

		ts = t;
		u = u;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		txtClassLeaderboards = new JTextField();
		txtClassLeaderboards.setText("Class Leaderboards");
		panel.add(txtClassLeaderboards, BorderLayout.WEST);
		txtClassLeaderboards.setColumns(10);

		JButton btnRefreshLeaderboards = new JButton("Refresh Leaderboards");
		panel.add(btnRefreshLeaderboards, BorderLayout.EAST);

		MaterialUIMovement.add(btnRefreshLeaderboards, MaterialColors.BLUE_200);

		btnRefreshLeaderboards.addActionListener(this);
		/*
		 * JPanel panel_1 = new JPanel(); add(panel_1, BorderLayout.SOUTH);
		 * panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		 */

		studentList = client.getStudentList();

		String[] colHeadings = { "Name", "Schools", "GPA", "SAT", "ECS", "IQ", " Happiness" };
		int numRows = studentList.size();

		model = new DefaultTableModel(numRows, colHeadings.length);
		model.setColumnIdentifiers(colHeadings);

		// System.out.println(list.get(0).getName());
		// table = new JTable(model);

		// new Jta

		table = new JTable(numRows + 35, colHeadings.length);
		
		/*

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.getColumnModel().getColumn(5).setMaxWidth(55);
		table.getColumnModel().getColumn(6).setMaxWidth(55);
		table.getColumnModel().getColumn(4).setMaxWidth(55);
		table.getColumnModel().getColumn(3).setMaxWidth(75);
		table.getColumnModel().getColumn(2).setMaxWidth(55);

		int i = 0;
		for (Student st : list) {

			table.setValueAt(st.getName(), i, 0);

			table.setValueAt(st.getSchool(), i, 1);
			table.setValueAt(((int) (st.getGpa() * 1000)) / 1000.0, i, 2);
			table.setValueAt(st.getSat(), i, 3);
			table.setValueAt(st.getEcs(), i, 4);
			table.setValueAt(st.getIq(), i, 5);
			table.setValueAt(st.getHappiness(), i, 6);

			i++;

		}
		*/

		/*
		 * grid.add(new JScrollPane(table)); add(new JScrollPane(grid),
		 * BorderLayout.SOUTH);
		 */

		scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		updateTable();
		repaint();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * updates the table by getting the new list of students from the database and adding their stats to the table 
	 */
	public void updateTable() {
		

		String[] colHeadings = { "Name", "Schools", "GPA", "SAT", "ECS", "IQ", " Happiness" };
		int numRows = studentList.size();

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(colHeadings);


		table.getColumnModel().getColumn(5).setMaxWidth(55);
		table.getColumnModel().getColumn(6).setMaxWidth(55);
		table.getColumnModel().getColumn(4).setMaxWidth(55);
		table.getColumnModel().getColumn(3).setMaxWidth(75);
		table.getColumnModel().getColumn(2).setMaxWidth(55);

		int i = 0;
		for (Student st : studentList) {

			table.setValueAt(st.getName(), i, 0);

			table.setValueAt(st.getSchool(), i, 1);
			table.setValueAt(((int) (st.getGpa() * 1000)) / 1000.0, i, 2);
			table.setValueAt(st.getSat(), i, 3);
			table.setValueAt(st.getEcs(), i, 4);
			table.setValueAt(st.getIq(), i, 5);
			table.setValueAt(st.getHappiness(), i, 6);

			i++;

		}

		System.out.println(studentList.get(0).getName());
		((DefaultTableModel) table.getModel()).fireTableDataChanged();

	}

	/** (non-Javadoc)
	 * used to call the update table which will set the table values to the most recent info from database
	 * also repaints the panel so that the panel contains an updated version of the table
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		studentList = client.getStudentList();
		updateTable();
		repaint();
	}

	/** (non-Javadoc)
	 * updates the table using updatetable method
	 * @see GamePanel#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		updateTable();
		// add(new JScrollPane(table));

	}

}
