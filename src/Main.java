import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        float monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Principal amount");
            System.out.print("Principal($1K-1M) : ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.println("Enter Annual Interest Rate");
            System.out.print("Annual Interest Rate : ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 &&  annualInterest <=30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater that 0 and less than or equal to 30.");
        }


        while (true) {
            System.out.println("Enter Period for the Mortgage");
            System.out.print("Period (Years) : ");
            byte years = scanner.nextByte();
            if (years >=1 && years <=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }


        double Mortgage = principal *
                (monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage : "+ mortgageFormatted);

        }
    }
