package src;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TypeFile {

public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("Pokemon Type Permutation02.txt", "UTF-8");
		
		String[] Type = {"Grass","Fighting","Water","Ice","Fairy","Flying","Ghost","Poison","Bug","Steel","Ground","Dragon"};

		for (int m=0; m<12; m++){ //type1 combination loop
			
			for (int j=m+1; j<12; j++){ //type2 loop
				
				if (Type[m]!=Type[j]){ //skips if type is duplicate
					
					writer.println(Type[m]+","+Type[j]);
					
				}//end if statement
				
			} //end perm loop within loop
			
		}//end type permutation loop
		
		writer.close(); //closes Writer
		
	} //end main
	
}
