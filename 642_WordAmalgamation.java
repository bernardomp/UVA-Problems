
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> dicc = new ArrayList<>();

		String v = "";
		
		v = scan.nextLine();
		
		while(!v.equals("XXXXXX")) {
			dicc.add(v);
			
			v = scan.nextLine();
		}

		Collections.sort(dicc);
		
		
		v = scan.nextLine();
		
		int times  = 0;
		
		while(!v.equals("XXXXXX")) {

			char h[] = v.toCharArray();
			Arrays.sort(h);
			v = new String(h);
			
			for(String c : dicc) {
				
				char g[] = c.toCharArray();
				Arrays.sort(g);
				String x = new String(g);
				
				if(v.equals(x)) {
					System.out.println(c);
					times++;
				}
			}
			
			if(times == 0) {
				System.out.println("NOT A VALID WORD");
			}
			
			times = 0;
			System.out.println("******");
			v = scan.nextLine();
			
		}
			
		scan.close();
	}

}
