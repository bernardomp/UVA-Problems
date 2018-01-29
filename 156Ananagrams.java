
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static String convert(String v) {
		
		char c[] = v.toLowerCase().toCharArray();
		
		Arrays.sort(c);
		
		return new String(c);
	}

	public static void main(String args[]) {


		Scanner scan = new Scanner(System.in);
		
		TreeMap<String,Integer> count = new TreeMap<>();
		TreeMap<String,String> dicc = new TreeMap<>();
		String val;

		val = scan.next();
		
		while(!val.equals("#")) {
			
			String aux = convert(val);
			
			dicc.put(val, aux);

			
			if(!count.containsKey(aux)) {
				count.put(aux, 0);
			}
			
			count.put(aux, count.get(aux)+1);
			
			val = scan.next();
		}
		
		for(String c : dicc.keySet()) {
			
			if(count.get(dicc.get(c)) == 1) System.out.println(c);
			
		}
		 
			
		scan.close();
	}

}
