import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.security.auth.callback.TextOutputCallback;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import top.gigabox.supportcomponent.toast.MaterialTost;
import mdlaf.utils.*;


/**
 * @author sidharth
 *
 *
 */
public class MenuPanel extends GamePanel implements ActionListener{
	
	private TabSwitcher ts;
	private ImageIcon loadingImage;
	private MaterialFonts fonts;
	private ImageIcon load;
	private JButton button;
	
	private WholeUI u;
	
	private Character stu;
	/**
	 * Creates a window welcoming the user along with a button to start the game
	 * @param ts the tabswitcher for the panel
	 * @param u the entire user interface
	 */
	public MenuPanel(TabSwitcher ts, WholeUI u , Character stu) {
		this.stu = stu;
		this.u = u;
		this.ts = ts;
		fonts = new MaterialFonts();
		JPanel p = new JPanel();
		loadingImage = new ImageIcon("loading.gif");
		
		 button = new JButton("Play the Game!");
		button.addActionListener(this);
		p.setLayout(new BorderLayout(0, 0));
		p.add(button);
		add(p, BorderLayout.NORTH);
		MaterialUIMovement.add(button, MaterialColors.BLUE_200);
		
		
	
	/*	JButton button2 = new JButton("Play the Game!");
		button2.addActionListener(this);
		
		p.add(button2);
	
		
		add(p , BorderLayout.NORTH);
		MaterialUIMovement.add(button, MaterialColors.BLUE_200);*/
		JLabel title = new JLabel("COLLEGE APPLICATION SIM 2019");
		
		title.setFont(new Font("/fonts/NotoSans-Black.ttf", 2, 52));
				
			//	new Font
			//	fonts.MEDIUM , 22);
		
		
		add (title, BorderLayout.CENTER);
		
	}
	
	
	/*public void draw(PApplet p) {
		
		p.textAlign(p.width / 2);
		
		f = p.createFont("Times New Roman", 20);
		p.textFont(f);
		p.fill(000000);
		p.text("College Applications Sim 2019", p.width / 2 - p.textWidth("College Applications Sim 2019") /2, p.height / 3);
		

	}*/
	@Override
	/**
	 * Paints the background and sets up the graphics of the window
	 */
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);	
	}

	@Override
	/**
	 * Checks to see if the player has pressed "play the game"
	 * button and sends the player to a message then to a new tab
	 * to start the game
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		button.removeActionListener(this);
	
		JFrame panel = new JFrame();
        panel.setSize(new Dimension(1000, 800));
        add(new JLabel(new ImageIcon(getClass().getResource("loading.gif"))), BorderLayout.CENTER);
		
		
		
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		Runnable task =new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				String name;
				try {
				 name= JOptionPane.showInputDialog(new JPanel(), "Enter your name, student");
				}catch (NullPointerException r) {
					name = "noname";
				}
				
				stu.setName(name);
				
				JOptionPane.showMessageDialog(new JPanel(), "Welcome, " + name + ". You are a student in High School, \nand college apps are just around the corner!\nYou still have some work to do before you get there. \nMake smart decisions in school. \nBe careful: every decision takes time. \nIf you are looking for a boost, check out \nthe store. Good luck!");
				u.addHS();
				u.addStore();

				ts.switchToTab(2);
			}
		};	
		
		
		executor.schedule(task, 2, TimeUnit.SECONDS);

		
		/*u.addHS();
		u.addStore();
		
		String name;
		try {
		 name= JOptionPane.showInputDialog(this, "Enter your name, student");
		}catch (NullPointerException r) {
			name = "noname";
		}
		
		stu.setName(name);
		
		JOptionPane.showMessageDialog(this, "Welcome, " + name + ". You are a student in High School, \nand college apps are just around the corner!\nYou still have some work to do before you get there. \nMake smart decisions in school. \nBe careful: every decision takes time. \nIf you are looking for a boost, check out \nthe store. Good luck!");
		
		ts.switchToTab(2);*/
	}
}
