import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ",1000,1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ",1,30);
        byte years = (byte) readNumber("Period(Years): ",1,30);

        double Mortgage = calculateMortgage(principal,annualInterest,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage : "+ mortgageFormatted);

        }

        public static double readNumber(String prompt,double min,double max){
            Scanner scanner = new Scanner(System.in);
            double value;
        while (true) {
                System.out.println("Enter Annual Interest Rate");
                System.out.print(prompt);
                value = scanner.nextFloat();
                if (value >= min &&  value <= max)
                    break;
                System.out.println("Enter a value greater that "   + min + " and less than or equal to " + max);
            }
        return value;
        }

        public static double calculateMortgage(
                int principal,
                float annualInterest,
                byte years){

            final byte MONTHS_IN_YEAR = 12;
            final byte PERCENT = 100;

            short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

            double Mortgage = principal *
                    (monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                    /(Math.pow(1+monthlyInterest,numberOfPayments)-1);
            return Mortgage;
        }
    }
