	
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;

import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * @author johnny
 *
 */
public class WholeUI extends JPanel implements TabSwitcher {

	private MenuPanel gamePane;
	private ApplicationPanel appPane;
	private HighSchoolPanel hsPane;
	private ResultPanel resultPane;
	private Store store;
	private Character c;
	private Transcript trPane;
    //private OptionPanel optionPane;
    
    private JTabbedPane tabbedPane;
    
    /**
     * Constructs a new WholeUI that is in charge of the entire game's user interface
     * @param s the character that the player is p;aying as
     */
	public WholeUI(Character s) {

       // optionPane = new OptionPanel(this);
		
	
		c = s;
        gamePane = new MenuPanel(this, this , s);
        appPane = new ApplicationPanel(this, c, this);
        store = new Store(this, c);
        hsPane = new HighSchoolPanel(this, c, this);
        
        trPane = new Transcript(c);
        
        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
       // tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=35 marginheight=5>Options</body></html>", optionPane);

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Intro</body></html>", gamePane);
       
        
        
        Leaderboard lbPane = new Leaderboard(this, this);
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Leaderboard</body></html>", lbPane);
        
        
       
        
		add(tabbedPane, BorderLayout.CENTER);

		setBounds(30,30,1100, 750);
	}
	
	/**
	 * Adds a tab for the store panel
	 */
	public void addStore(){
		tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Store</body></html>", store);
	}
	/**
	 * Adds a tab for the highschool panel
	 */
	public void addHS(){
		 tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Skewl</body></html>", hsPane);
		 hsPane.startTimer();
	}
	/**
	 * Adds a tab for the application panel
	 */
	public void addApp(){
		 tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Application</body></html>", appPane);
	}
	/**
	 * Adds a tab for the transcript  panel
	 */
	public void addTr(){
		 tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Transcript</body></html>", trPane);
	}
	
	
	/**
	 * Adds a tab for the Result panel
	 */
	public void addResult(){
		resultPane = new ResultPanel(c);
		tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Results</body></html>", resultPane);
	}

	
	
	
	
	/**
	 *
	 * @see TabSwitcher#switchToTab(int)
	 */
    public void switchToTab(int i) {
        tabbedPane.setSelectedIndex(i);
    }

}
