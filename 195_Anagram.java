import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static Comparator<String> cmp = new Comparator<String>() {

		
		char[] index = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};

		@Override
		public int compare(String o1, String o2) {
			char a,b;
			boolean n = false,m = false;
			int v = 0,w = 0;
			
			for(int i = 0; i<o1.length(); i++) {
				
				a = o1.charAt(i);
				b = o2.charAt(i);
				
				for(int j = 0; j<52; j++) {
					if(m==true && n == true ) break;
					if(index[j] == a) {
						v = j;
						n = true;
					}
					if(index[j] == b) {
						w = j;
						m = true;
					}
				}
				n = false;
				m = false;
				
				if(v<w) {
					return -1;
				}
				else if(v>w) {
					return 1;
				}

				
			}
			return 0;
		}

		
	};

	
	public static String next_permutation(String val) {
		
		char c[] = val.toCharArray();
		
		int p1 = -1;
		char v1 = 0;
		
		int p2 = -1;
		char v2 = 0;
		
		for(int i = c.length-2; i>= 0; i--) {
			
			if(c[i]<c[i+1]) {
				
				p1=i;
				v1=c[i];
				break;
			}
		}
		
		if(p1 == -1) return val;
		
		for(int i = c.length-1; i>p1; i--) {
			
			if(c[i]>v1) {
				p2=i;
				v2 = c[i];
				break;
			}
		}
		
		if(p2 == -1) return val;
		
		c[p1] = v2;
		c[p2] = v1;
		
		char aux;
		
		int j = c.length-1;
		for(int i = p1+1; i<j; i++,j--) {
			aux = c[i];
			c[i] = c[j];
			c[j] = aux;
			
		}
		
		return new String(c);
		
	}
	
	

	public static void main(String args[]) {

		

		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> t = new ArrayList<>();
		
		int cases = 0;
		String c,diff;
		char tot[];
		
		cases = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i<cases; i++) {
			
			c = scan.nextLine();
			tot = c.toCharArray();
			
			Arrays.sort(tot);
			c = String.valueOf(tot);
			
			t.add(c);
			
			diff = next_permutation(c);
			
			while(!diff.equals(c)) {
				t.add(diff);
				
				c = diff;
				
				diff = next_permutation(c);
			}
			
			
			Collections.sort(t,cmp);
			for(String v : t ) {
				System.out.println(v);
			}
			
			t.clear();
			
		}
		
			 
			
		scan.close();
	}

}
