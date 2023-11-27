import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Principal amount");
        System.out.print("Principal($1K-1M) : ");
        int principal = scanner.nextInt();

        System.out.println("Enter Annual Interest Rate");
        System.out.print("Annual Interest Rate : ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Enter Period for the Mortgage");
        System.out.print("Period (Years) : ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double Mortgage = principal *
                (monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage : "+ mortgageFormatted);

        }
    }
