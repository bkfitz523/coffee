package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

 
/**
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
**/
 
public class PokedexCSVtoArrayList {
	public static void main(String[] args) {
		
		BufferedReader pokedexBuffer = null;
		//PrintWriter siteWriter = new PrintWriter("Site.html", "UTF-8");
		
		try {
			String pokedexLine;
			pokedexBuffer = new BufferedReader(new FileReader("/Users/bkfit/workspace/PokemonWriter/src/src/pokedex.csv"));
			//C:/Users/bkfit/workspace/PokemonWriter/src/src
			// How to read file in java line by line?
			while ((pokedexLine = pokedexBuffer.readLine()) != null) {

				ArrayList<String> pokedex = pokedexCSVtoArrayList(pokedexLine); //  new ArrayList<String>();
				
				//0=number, 1=name 2=image url 3=type1 4=type2
				if (Integer.parseInt(pokedex.get(0))<=151){
					if (pokedex.get(4).equals("null")){
						System.out.println(pokedex.get(0) + ": " + pokedex.get(1) + ", " + pokedex.get(3));
						System.out.println(pokedex.get(2)+"\n");//https://img.pokemondb.net/artwork/ivysaur.jpg
					}
					else{
						System.out.println(pokedex.get(0) + ": " + pokedex.get(1) + ", " + pokedex.get(3) + "/" + pokedex.get(4));
						System.out.println(pokedex.get(2)+"\n");//https://img.pokemondb.net/artwork/ivysaur.jpg
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pokedexBuffer != null) pokedexBuffer.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
	}//main
	
	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> pokedexCSVtoArrayList(String pokedexCSV) {
		ArrayList<String> pokedexResult = new ArrayList<String>();
		
		if (pokedexCSV != null) {
			String[] splitData = pokedexCSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					pokedexResult.add(splitData[i].trim());
				}
			}
		}
		
		return pokedexResult;
	}
}
