package com.cognizant.Assessment;

// import java scanner class
import java.util.Scanner;

public class Q2{

	public static void main(String[] args) {
		// Initiate scanner class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :");
		int num = sc.nextInt();
		sc.close();
		// method invocation
		Q2 df = new Q2();
		df.Display(num);

	}
	
	// Display function initialization 
	public void Display(int num)
	{
		int temp, sum=0,digit;
		digit = num % 10;
			while(num>0)
			{
				temp = num % 10;
		        sum  = temp-sum;
		        num /= 10;
			}
			 		// Condition check
		
					if(sum<0)
					{
						System.out.println(-sum +""+ digit);
					}
					else
					{
						System.out.println(sum +""+ digit);
					}	
	}

}
