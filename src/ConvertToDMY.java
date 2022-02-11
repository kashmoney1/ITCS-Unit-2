//Akash Patel		ITCS

import java.util.Scanner;

public class ConvertToDMY {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number of days:");
		int days = scan.nextInt();
		int y = days/365;
		int m = (days % 365)/30;
		int l = (days % 365) % 30;
		System.out.println(days + " days is " + y + " years, " + m + " months, " + l + " days");
		

	}

}
