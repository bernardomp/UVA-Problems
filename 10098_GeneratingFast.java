
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static String next_permutation(String cad) {
		
		int p1 = -1;
		char v1 = 0;
		
		int p2 = -1;
		char v2 = 0;
		
		for(int i = cad.length()-2; i>=0; i--) {
			
			if(cad.charAt(i)<cad.charAt(i+1)) {
				p1 = i;
				v1 = cad.charAt(i);
				break;
			}
		}
		
		if(p1==-1) return cad;
		
		
		for(int i = cad.length()-1; i>=0; i--) {
			
			if(cad.charAt(i)>v1) {
				p2 = i;
				v2 = cad.charAt(i);
				break;
			}
		}
		
		char w[] = cad.toCharArray();
		
		w[p1] = v2;
		w[p2] = v1;
		
		int j = p1+1;
		for(int i = cad.length()-1; j<i; i--) {
			
			char aux = w[i];
			w[i] = w[j];
			w[j] = aux;
			
			j++;
			
		}
		
		return new String(w);
		
	}
	
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		
		int cases;
		
		cases = scan.nextInt();
		scan.nextLine();
		
		
		for(int i = 0; i<cases; i++) {
			
			char x[] = scan.nextLine().toCharArray();
			Arrays.sort(x);
			
			String real = new String(x);
			String diff = next_permutation(real);
			
			System.out.println(real);
			
			while(!real.equals(diff)) {
				System.out.println(diff);
				real = diff;
				diff = next_permutation(real);
				
			}
			
			System.out.println();
			
		}
			
		scan.close();
	}

}
