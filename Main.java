
import java.util.Scanner;

public class Main {
	
	public static String getVerticalString(String c,int group) {
		
		String d = "";
		
		for(int j = 0; j<group; j++) {
			
			for(int i = j; i<group*group; i+=group) {
				
				d = d + c.charAt(i);
				
			}
		}
		
		
		return d;
	}
	
	public static String prepare(String c) {
		
		c = c.replace('.', (char) 32);
		c = c.replace(',', (char) 32);
		c = c.replace('!', (char) 32);
		c = c.replace('?', (char) 32);
		c = c.replace('(', (char)32);
		c = c.replace(')', (char)32);
		c = c.replace(" ", "");
		
		return c;
	}

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
	
	public static String[] nextTime(int hh,int mm) {
		String rtn[] = new String[2];
		String c = "";
		
		mm = mm+1;
		
		if(mm>59) {
			hh++;
			mm=0;
			
			if(hh>23) {
				hh=0;
			}
		}
		
		if(hh==0 && mm<10) {
			rtn[0] = ""+mm;
			rtn[1] = "00:0"+mm;
			return rtn;
		}
		
		else if (hh!=0 && mm<10) {
			
			rtn[0] = hh + ":0" + mm;
			
			if(hh<10) rtn[1] = "0"+hh+":0"+mm;
			else rtn[1] = hh+":0"+mm;
			
			return rtn;
		}
		
		else if(hh==0 && mm>9) {
			rtn[0] = ""+ mm;
			rtn[1] = "00:"+mm;
			return rtn;
		}
		
		rtn[0] = hh + ":" + mm;
		
		
		if (hh<10 && mm>9) {
			rtn[1] = "0"+hh+":"+mm;
		}
		
		else {
			rtn[1] = hh+":"+mm;
		}
		
		return rtn;
		
	}

	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
	
		String v = "";
		String res = "";
		String get[];
		
		int cases = scan.nextInt();
		
		scan.nextLine();
		
		for(int i  =0; i<cases; i++) {
			res = "";
			v = "";
			
			v = scan.nextLine();
			
			String diff[] = v.split(":");
			
			int  h = Integer.parseInt(diff[0]);
			int  m = Integer.parseInt(diff[1]);
			
			get = nextTime(h,m);
		
			
			while(!isPalindrome(get[0].replaceAll(":", ""))) {

				diff = get[1].split(":");
				
				h = Integer.parseInt(diff[0]);
				m = Integer.parseInt(diff[1]);

				get = nextTime(h,m);
					
			}
			
			System.out.println(get[1]);
				
		}
	
		scan.close();
	}

}
