package PP4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;




public class Scraper {
	
	private Matcher matcher;
	private Regex regex;
	private String url;
	private int pageNum=0;

	public Scraper (String url) {		
		this.url=url;		
	} //end constructor
	
	// reads the data from a web page and searches for the string matches
	public void parseData() throws IOException {
		
		HttpURLConnection connected = null;
		BufferedReader in = null;
		StringBuilder page = null;
		String inputLine = null;
		Pattern masterKey = null;
		Pattern position = Pattern.compile("CB(?=</td>)|SAF(?=</td>)|DB(?=</td>)");
		Pattern status = Pattern.compile("ACT(?=</td>)|UFA(?=</td>)|UDF(?=</td>)|NON(?=</td>)|SUS(?=</td>)|PUP(?=</td>)|UDF(?=</td>)|EXE(?=</td>)");
		Pattern name = Pattern.compile("profile\\W\\W.*");
		Pattern num = Pattern.compile("<td\\s+class\\=\"tbdy\"></td>|<td\\s+class\\=\"tbdy\">\\d</td>|<td\\s+class\\=\"tbdy\">\\-\\-</td>|<td\\s+class\\=\"tbdy\">\\d\\.\\d</td>|<td\\s+class\\=\"tbdy\">[0-9][0-9]</td>");
		Pattern tackle = Pattern.compile("<td\\s+class\\=\"tbdy\">\\d..</td>|<td\\\\s+class\\\\=\\\"tbdy\\\">116</td>|<td\\s+class\\=\"tbdy\"></td>|<td\\s+class\\=\"tbdy\">\\d</td>|<td\\s+class\\=\"tbdy\">\\-\\-</td>|<td\\s+class\\=\"tbdy\">\\d\\.\\d</td>|<td\\s+class\\=\"tbdy\">[0-9][0-9]</td>");
		Pattern sck = Pattern.compile("<td\\s+class\\=\"tbdy\"></td>|<td\\s+class\\=\"tbdy\">\\d</td>|<td\\s+class\\=\"tbdy\">\\-\\-</td>|<td\\s+class\\=\"tbdy\">\\d\\.\\d</td>|<td\\s+class\\=\"tbdy\">[0-9][0-9]</td>");
		Pattern intt = Pattern.compile("<td\\s+class\\=\"tbdy\"></td>|<td\\s+class\\=\"tbdy\">\\d</td>|<td\\s+class\\=\"tbdy\">\\-\\-</td>|<td\\s+class\\=\"tbdy\">\\d\\.\\d</td>|<td\\s+class\\=\"tbdy\">[0-9][0-9]</td>");
		Pattern team = Pattern.compile("team=.*(?=</a></td></tr>)");
		Pattern pages = Pattern.compile("\\d</a> <a href=");
		String [] records;
		int j = 0;
		int q = 0; 
		URL urly = null;
		Scanner inputty = null;
		
		//////create regex
		regex = new Regex (position, num, name, status, tackle, sck, intt, team);
		/////Get the html
		try {
		       urly = new URL(url);
		
		       inputty = new Scanner(urly.openStream());}
		catch(Exception al) {
			JOptionPane.showMessageDialog(null, "Webite address is not entered in the system properly"+"\n"+"or the webiste is currently unavailable"+"\n" + "click ok to exit the program", "Invalid Website URL",0 );
			System.exit(0);
		}
		      while (inputty.hasNext()) {
		        String liner = inputty.nextLine();
		     //////////find max pages
       try {
			 matcher = pages.matcher(liner);  
				if (matcher.find()) {						
					String findTarg = liner;		
					String ne  = findTarg.substring(matcher.start(), matcher.end())+"\n";												 
					String nuu = ne.replaceAll("</a> <a href=","");
					try {
						nuu = nuu.trim();
						pageNum = Integer.parseInt(nuu);
					}
					catch(Exception al) {	
					}
				}
       		}
     catch (Exception lo) {
    	 JOptionPane.showMessageDialog(null, "Webite address is not entered in the system properly"+"\n"+"or the webiste is currently unavailable"+"\n" + "click ok to exit the program", "Invalid Website URL",0 );
			System.exit(0);	
     }
		      }///end while
		      int noOfMatch = 0;
		      inputty.close();
/////////////////////Figures out the size for the array///////////////////////////////////////////////////
	for(int i = 1; i<pageNum+1; i++) {
			url = "http://www.nfl.com/players/search?category=position&playerType=current&conference=ALL&d-447263-p="+i+"&filter=defensiveback&conferenceAbbr=null";
	   	    URL url1 = new URL(url);
	        connected = (HttpURLConnection) url1.openConnection();
   	        in = new BufferedReader(new InputStreamReader(connected.getInputStream()));
			if (i==1) {
			   page = new StringBuilder();
	        }
		///////find a match
			while ((inputLine = in.readLine()) != null) {         
			 	 try {
				 matcher = regex.getTeam().matcher(inputLine);
					if (matcher.find()) {
						++q;
					}
				 matcher = regex.getStatus().matcher(inputLine);
				  
					//System.out.println(line);
					if (matcher.find()) {	
						++q;
						
					}	
				matcher = regex.getPos().matcher(inputLine);
					if (matcher.find()) {
						++q;
					}
				matcher = regex.getLlayerName().matcher(inputLine);
					if (matcher.find()) {						
						++q;
					}
	//////////sequence of stats with similar structure, patterns shuffle(masterKey) and discards stat noOfMatch == 3 not needed.
					if (noOfMatch==0) {
							masterKey = regex.getNum();
					}
					else if (noOfMatch==1) {
						 	masterKey = regex.getTckl();
					}
					else if (noOfMatch==2) {
					 	masterKey = regex.getSck();
					}
					else if (noOfMatch==3) {
					 	masterKey = regex.getTckl();
					}
					else if (noOfMatch==4) {
					 	masterKey = regex.getIntt();
					}
				matcher = masterKey.matcher(inputLine);
					if (matcher.find()) {	
						++q;
						++noOfMatch;
					if (noOfMatch==5) {
						noOfMatch = 0;
					}
					}
			 }// end try 
			 catch (Exception e) {
					}//end catch
			 }///end while						
				}////end for
	try {
						in.close();            
						connected.disconnect();  
		}
    catch (Exception lo) {
   	 JOptionPane.showMessageDialog(null, "Webite address is not entered in the system properly"+"\n"+"or the webiste is currently unavailable"+"\n" + "click ok to exit the program", "Invalid Website URL",0 );
			System.exit(0);	
    }
				///Array size found could have estimate based on page size to increase efficiency/speed
		      records = new String [q];
		      noOfMatch=0;
////////////////Collects the data and prepares for its displaying
		     for(int i = 1; i<pageNum+1; i++) {
			 	url = "http://www.nfl.com/players/search?category=position&playerType=current&conference=ALL&d-447263-p="+i+"&filter=defensiveback&conferenceAbbr=null";
			 	URL url1 = new URL(url);
			 	connected = (HttpURLConnection) url1.openConnection();
			 	in = new BufferedReader(new InputStreamReader(connected.getInputStream()));
			 	if (i==1) {
			 		page = new StringBuilder();
		     }
		     while ((inputLine = in.readLine()) != null) {
		                 page.append(inputLine+"\n");
		        try {
//////////////find a match and validate format
			 	matcher = regex.getTeam().matcher(inputLine);
				if (matcher.find()) {						
					String findTarget = inputLine;		
					String newL  = findTarget.substring(matcher.start()+5, matcher.end())+"|";												 
					String newLi = newL.replaceAll(".*>","");
					records[j]=newLi;
					j++;
				}
				matcher = regex.getStatus().matcher(inputLine);
				if (matcher.find()) {						
					String findTarget = inputLine;		
					String newL  = findTarget.substring(matcher.start(), matcher.end());
					records[j]=newL;
					j++;
				}	
				matcher = regex.getPos().matcher(inputLine);
				if (matcher.find()) {						
					String findTarget = inputLine;		
					String newL  = findTarget.substring(matcher.start(), matcher.end());												 
					records[j]=newL;
					j++;
				}
				matcher = regex.getLlayerName().matcher(inputLine);
				if (matcher.find()) {						
					String findTarget = inputLine.replaceAll("</a></td>", "                                      ");
					findTarget.trim();
					String newL  = findTarget.substring(matcher.start()+9, matcher.end());												 
					newL = newL.replaceAll("\\s","");
				 if (newL.length()<=15)
						newL = newL + "\t"+"\t"+"\t";
						else if (newL.length()>=24) {
						newL =newL+"\t";
					}
				 else if (newL.length()>15&& newL.length()<24){	
						newL = newL + "\t"+"\t";
					}
					records[j]=newL;
					j++;
				}
				if (noOfMatch==0) {
						masterKey = regex.getNum();
				}
				else if (noOfMatch==1) {
					 	masterKey = regex.getTckl();
				}
				else if (noOfMatch==2) {
				 	masterKey = regex.getSck();
				}
				else if (noOfMatch==3) {
				 	masterKey = regex.getTckl();
				}
				else if (noOfMatch==4) {
				 	masterKey = regex.getIntt();
				}
				
				matcher = masterKey.matcher(inputLine);
				if (matcher.find()) {
					++noOfMatch;
					if (noOfMatch==5) {
					 	noOfMatch = 0;	
					}
					String findTarget = inputLine;
					//findTarget.trim();
					String newL  = findTarget.substring(matcher.start(), matcher.end());												 
					String newLi = newL.replace("</td>","");
					String newLin = newLi.replace("<td class=\"tbdy\">","");
					if (newLin.equals("")) {
						newLin = "--";
					}
				
					if (noOfMatch!=4)
						records[j]=newLin;
					j++;
				}
		 }///end try
		 catch (Exception e) {
				}//end catch
		 }///end while						
			}///end for 
					in.close();
					connected.disconnect();
/////////////////////////makes display string(findings) and calls to be displayed					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String findings =("Output: Pos    Num      Player Name                            Status  TCKL     SCK     INT    Team  "+dtf.format(now)+"                                          |"+"\t");	      
					
					for (int i = 0; i < q; i++) {
						if (records[i] != null) {
							findings = findings + records[i]+"\t";
						}
							}
					display(findings);				
	}/////end method
	
	public String getUrl() {
		return url;
	}

	// shows the output (scraped data) in a text-area 
	public String display(String display) throws IOException{
/////////////////breaks the string into tokens and appends to txtAreaStats and writes to file

		StringTokenizer tempTokenizer = new StringTokenizer(display,"|");
		while (tempTokenizer.hasMoreElements()) {
			FileWriter fw = new FileWriter("NFLStat.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
            String write = tempTokenizer.nextToken();
            UserGUI.getTxtAreaStats().append(write + "\n");
            bw.write(write);
            bw.newLine();
  		   	bw.flush();
  		   	bw.close();
	}
		return null;
	}
} //end class
	



	
	

