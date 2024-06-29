package task1;
import java.util.*;
import java.lang.*;


public class Number_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //scanner class
		Scanner input = new Scanner(System.in);
		
		int number = 1 + (int)(100*Math.random());
		
		System.out.println("Enter a number");
		
		int guess;
		int i=0;
		
		while(i<3) {
			guess=input.nextInt();
			if(number==guess) {
				System.out.println("Your guess is correct number is "+number);
				break;
			}
			else {
				if(guess>number) {
					System.out.println("Your guess greater than number ");
				}
				else {
					System.out.println("Your guess lesser than number ");
				}
			}
			i++;

		}
		if(i==3) {
			System.out.println("your all attempts are done");
			System.out.println("the Number is "+number);
		}
	}

}
