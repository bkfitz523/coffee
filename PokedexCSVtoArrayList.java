package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
 
/**

**/
 
public class PokedexCSVtoArrayList {
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		BufferedReader pokedexBuffer = null;
		
		PrintWriter siteWriter = new PrintWriter("/Users/bkfit/workspace/PokemonWriter/src/src/pokedex_urls.html", "UTF-8");
		
		//html tags
		String html_body_close = new String ("</body>\n</html>");
		
		//anchor and href tags		
		String html_href_open = new String ("<a href=\""); //<a href="
		String html_href_close = new String ("\">"); //">
		String html_anchor_close = new String ("</a><br>"); //close anchor tag and new line
		
		//image tages
		String html_img_open = new String ("<img src=\"");
		
		//td and tr tags
		String td_open = new String ("<td>");
		String td_close = new String ("</td>");
		String tr_open = new String ("<tr>");
		String tr_close = new String ("</tr>");	

		html_intialize(siteWriter);
		
		//open table
		siteWriter.println("<table>");
		
		//header row
		siteWriter.println("<tr><th>Number</th><th>Name</th><th>URL</th><th>Primary Type</th><th>Secondary Type</th></tr>");
		
		try {
			String pokedexLine;
			pokedexBuffer = new BufferedReader(new FileReader("/Users/bkfit/workspace/PokemonWriter/src/src/PokedexURLs.csv"));
			//C:/Users/bkfit/workspace/PokemonWriter/src/src
			// How to read file in java line by line?
			while ((pokedexLine = pokedexBuffer.readLine()) != null) {

				ArrayList<String> pokedex = pokedexCSVtoArrayList(pokedexLine); //  new ArrayList<String>();
				
				//0=number, 1=name 2=image url 3=type1 4=type2
				if (Integer.parseInt(pokedex.get(0))<=151){
					if (pokedex.get(4).equals("null")){
//						System.out.println(pokedex.get(0) + ": " + pokedex.get(1) + ", " + pokedex.get(3));
//						System.out.println(pokedex.get(2)+"\n");//https://img.pokemondb.net/artwork/ivysaur.jpg
						siteWriter.println(
								tr_open +
								td_open + pokedex.get(0) + td_close +
								td_open + pokedex.get(1) + td_close +
								td_open + html_img_open + pokedex.get(2) + "\"" + td_close +
								td_open + pokedex.get(3)+ td_close +
								td_open + td_close +
								tr_close);
		
					}  //end else
					else{
						siteWriter.println(
								tr_open +
								td_open + pokedex.get(0) + td_close +
								td_open + pokedex.get(1) + td_close +
								td_open + html_img_open + pokedex.get(2) + "\"" + td_close +
								td_open + pokedex.get(3)+ td_close +
								td_open + pokedex.get(4)+ td_close +
								tr_close);
					}  //else
				}  //if
			}  //while			
		}  //try 
		
		catch (IOException e) {
			e.printStackTrace();
		}  //catch
		
		finally {
			try {
				if (pokedexBuffer != null) pokedexBuffer.close();
			}  //end try
			catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}  //end catch
		}  //end finally
		
		siteWriter.println("</td>\n</table>\n" + html_body_close);		
		siteWriter.close(); //closes Writer
		
	}  //main
	
	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> pokedexCSVtoArrayList(String pokedexCSV) {
		ArrayList<String> pokedexResult = new ArrayList<String>();
		
		if (pokedexCSV != null) {
			String[] splitData = pokedexCSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					pokedexResult.add(splitData[i].trim());
				}  //if
			}  //for
		}  //if
		
		return pokedexResult;
	}  //end CSV to ArrayList
	
	public static void html_intialize(PrintWriter siteWriter){
		
		String html_doc_Type = new String ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		String html_head_xml = new String ("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		String html_html_tag = new String ("<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n<title>Pokedex Links</title>");

		String html_body_open = new String ("<body>\n<h1>Pokedex Links</h1>\n</br>");

		String html_css = new String ("<style type=\"text/css\">\n</style>\n<link href=\"table.css\" rel=\"stylesheet\" type=\"text/css\" />\n</head>");
		
		siteWriter.println(html_doc_Type + "\n" + html_head_xml + "\n" + html_html_tag + "\n" + html_css+ "\n" + html_body_open);
						
	}  //html_initialize
}  //class
