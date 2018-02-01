import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static boolean isLeapYear(BigInteger year) {

        return (year.mod(new BigInteger("4")).equals(new BigInteger("0")) && !year.mod(new BigInteger("100")).equals(new BigInteger("0"))) || year.mod(new BigInteger("400")).equals(new BigInteger("0"));
    }

    public static boolean isHuluculu(BigInteger year) {
        return year.mod(new BigInteger("15")).equals(new BigInteger("0"));
    }

    public static boolean isBulukulu(BigInteger year) {
        return isLeapYear(year) && year.mod(new BigInteger("55")).equals(new BigInteger("0"));
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int count = 0;
        BigInteger year;
        String aux = scan.nextLine();

        year = new BigInteger(aux);

        if (isLeapYear(year)) {
            System.out.println("This is leap year.");
            count++;
        }
        if (isHuluculu(year)) {
            System.out.println("This is huluculu festival year.");
            count++;
        }
        if (isBulukulu(year)) {
            System.out.println("This is bulukulu festival year.");
            count++;
        }
        if (count == 0) {
            System.out.println("This is an ordinary year.");
        }

        while (scan.hasNextLine()) {
            count = 0;
            System.out.println();

            aux = scan.nextLine();
            try {
                year = new BigInteger(aux);
            } catch (Exception e) {
                break;
            }

            if (isLeapYear(year)) {
                System.out.println("This is leap year.");
                count++;
            }
            if (isHuluculu(year)) {
                System.out.println("This is huluculu festival year.");
                count++;
            }
            if (isBulukulu(year)) {
                System.out.println("This is bulukulu festival year.");
                count++;
            }
            if (count == 0) {
                System.out.println("This is an ordinary year.");
            }

        }

        scan.close();
    }

}
