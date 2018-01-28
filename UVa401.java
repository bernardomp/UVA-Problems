
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	

	public static boolean isPalindrome(String c) {
		
		int length = c.length();

		int j = length - 1;
		for (int i = 0; i < length && j > -1; i++) {

			if (c.charAt(i) != c.charAt(j))
				return false;

			j--;
		}
		return true;

	}
	
	public static boolean isMirror(String c, HashMap<Character,Character> table) {
		
		StringBuilder f = new StringBuilder(c);
		
		for(int i = 0; i<c.length(); i++) {
			
			if(table.containsKey(c.charAt(i))) {
				f.setCharAt(i, table.get(c.charAt(i)));
			}
			
			else return false;
			
		}
		String mirror = f.reverse().toString();
		
		return mirror.equals(c);
	}
	
	
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		HashMap<Character,Character> tab = new HashMap<>();
		
		tab.put('A', 'A');
		tab.put('E', '3');
		tab.put('H', 'H');
		tab.put('I', 'I');
		tab.put('J', 'L');
		tab.put('L', 'J');
		
		tab.put('M', 'M');
		tab.put('O', 'O');
		tab.put('S', '2');
		tab.put('T', 'T');
		tab.put('U', 'U');
		tab.put('V', 'V');
		tab.put('W', 'W');
		tab.put('X', 'X');
		
		tab.put('Y', 'Y');
		tab.put('Z', '5');
		tab.put('1', '1');
		tab.put('2', 'S');
		tab.put('3', 'E');
		tab.put('5', 'Z');
		tab.put('8', '8');
		
		String val;
		
		
		while(scan.hasNextLine()) {
			
			val = scan.nextLine();
			
			if(!isPalindrome(val) && !isMirror(val,tab)) System.out.println(val+ " -- is not a palindrome.");
			else if (isPalindrome(val) && !isMirror(val,tab)) System.out.println(val+ " -- is a regular palindrome.");
			else if (!isPalindrome(val) && isMirror(val,tab))  System.out.println(val+ " -- is a mirrored string.");
			else System.out.println(val + " -- is a mirrored palindrome."); 
			
			System.out.println();
		}
		scan.close();
	}

}
