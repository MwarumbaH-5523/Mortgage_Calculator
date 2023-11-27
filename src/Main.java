import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ",1000,1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ",1,30);
        byte years = (byte) readNumber("Period(Years): ",1,30);

        double Mortgage = calculateMortgage(principal,annualInterest,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments : "+ mortgageFormatted);

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }

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

            short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

            double Mortgage = principal *
                    (monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                    /(Math.pow(1+monthlyInterest,numberOfPayments)-1);
            return Mortgage;
        }

        public static double calculateBalance(
                int principal,
                float annualInterest,
                byte years,
                short numberOfPaymentsMade){
        // B =L[(1+c)^n - (1+c)^p] / [(1+c)^n-1]

            short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

            double balance = principal
                    * (Math.pow(1 + monthlyInterest,numberOfPayments)
                    - Math.pow(1 + monthlyInterest,numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1);

            return balance;
        }

    }
