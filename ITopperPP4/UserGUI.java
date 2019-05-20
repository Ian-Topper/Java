package PP4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class UserGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnScrape;
	private JButton btnClose;
	private Scraper scraper;
	private JLabel lblOutput;
	private static JTextArea txtAreaStats;
	private JScrollPane scrlPane;
	private String url;
	  
	public UserGUI() {
		  
		
		url = ("http://www.nfl.com/players/search?category=position&filter=defensiveback&conferenceAbbr=null&playerType=current&conference=ALL");
		  // uses the url provided in the document
   	    scraper = new Scraper(url);
	    
   	    initGUI();
	    doTheLayout();
	  
	    btnScrape.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e){

	        		scrape();	            
	        }
	        });
	
	    btnClose.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            close();
	            }
	    });	   
	  } // end of constructor

	  // Creates and initialize the GUI objects
	  private void initGUI(){
		  setTxtAreaStats(new JTextArea());
	      getTxtAreaStats().setEditable(false);
	      getTxtAreaStats().setFont(new Font("Monospaced",Font.PLAIN,15));
	      DefaultCaret caret = (DefaultCaret) getTxtAreaStats().getCaret();
	      caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);	            
	      btnClose = new JButton("Exit");
	      btnScrape= new JButton("Scrape NFL Page");
	      lblOutput = new JLabel("Output:          Pos             Num                       Player Name"
	      		+ "                                                                                            Status"
	      		+ "            TCKL                 SCK                INT               Team      "
	      		+ "                                                               ");
	      lblOutput.setForeground(Color.blue.darker());
	      btnClose.setMnemonic(KeyEvent.VK_X);
	      btnScrape.setMnemonic(KeyEvent.VK_S);
	      btnScrape.setForeground(Color.green.darker().darker().darker());
	      btnClose.setForeground(Color.RED.darker().darker());
	      scrlPane = new JScrollPane(getTxtAreaStats());
	      scrlPane.setPreferredSize(new Dimension(1100, 350));
	      txtAreaStats.setLineWrap(true);
	  }// end of creating objects method
	
	  // Layouts the UI components as shown in the project document
	  private void doTheLayout(){
		  JPanel jpnlHeader = new JPanel();
		  jpnlHeader.setPreferredSize(new Dimension(1400, 40));   // To show full button
		  jpnlHeader.add(btnScrape);
		  jpnlHeader.setBackground(Color.CYAN.darker().darker());
		  add(jpnlHeader);
		  
		  JPanel jpnlLbl  = new JPanel();
		  jpnlLbl.setPreferredSize(new Dimension(1400, 30));   // To show full button
		  jpnlLbl.add(lblOutput);
		 
		  jpnlLbl.setBackground(Color.CYAN.darker());
		  add(jpnlLbl);
		  
		  JPanel jpnltxtArea  = new JPanel();
		  jpnltxtArea.setPreferredSize(new Dimension(1400, 360));   // To show full button
		  jpnltxtArea.add(scrlPane);
		  jpnltxtArea.setBackground(Color.CYAN.darker());
		  add(jpnltxtArea);
		  
		  JPanel jpnlBtnClose  = new JPanel();
		  jpnlBtnClose.setPreferredSize(new Dimension(1400, 50));   // To show full button
		  jpnlBtnClose.add(btnClose);
		  jpnlBtnClose.setBackground(Color.CYAN.darker().darker());
		  add(jpnlBtnClose);
		  
	  }// end of Layout method
	 
	// Uses the Scraper object reference to return and display the data as shown in the project document 
	 void scrape(){
		 try {
				scraper.parseData();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
	  }// end of scrape action event method
	   
	  void close(){
	      System.exit(0);
	  }// end of close action event method

	public static void main(String[] args) {
	   JFrame f = new JFrame("NFL Stats");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();       
        contentPane.add( new UserGUI());
        f.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        f.pack();
        f.setSize(1300, 525);
        f.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (f.getWidth() / 2), 
                                      middle.y - (f.getHeight() / 2));
        f.setLocation(newLocation);
	}// end of main method

	public static JTextArea getTxtAreaStats() {
		return txtAreaStats;
	}

	private static void setTxtAreaStats(JTextArea txtAreaStats) {
		UserGUI.txtAreaStats = txtAreaStats;
	}



}// end of class
