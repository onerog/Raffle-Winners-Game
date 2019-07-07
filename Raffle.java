import java.util.*;
public class Raffle {
	
	private static String nameOfRaffle;
	private static int smallestTicketNumber;
	private static int largestTicketNumber;
	private static int winningNumber1;
	private static int winningNumber2;
	private static int winningNumber3;
	
	public static String getNameOfRaffle() {
		
		return nameOfRaffle;
	}
	
	public static void getWinningNumbers() {
		
		System.out.println("Winning numbers are: " + winningNumber1 + ", "  + winningNumber2 + ", " + winningNumber3);
	}
	
	
	public static void setNameOfRaffle(String name) {
		
		char underscore = '_';
		char space = ' ';
		
		name = name.replace(space, underscore);
		name = name.toUpperCase();
		
		nameOfRaffle = name;
	}
	
	
	public static void setWinningNumbers() {
		Random generator = new Random();
		int theWinningNumber1 = generator.nextInt(largestTicketNumber - smallestTicketNumber + 1) + smallestTicketNumber;
		
		int theWinningNumber2 = generator.nextInt(largestTicketNumber - smallestTicketNumber + 1) + smallestTicketNumber;
		
		while (theWinningNumber2 == theWinningNumber1) {
			 theWinningNumber2 = generator.nextInt(largestTicketNumber - smallestTicketNumber + 1) + smallestTicketNumber;
		}
		
		int theWinningNumber3 = generator.nextInt(largestTicketNumber - smallestTicketNumber + 1) + smallestTicketNumber;
		
		while (theWinningNumber3 == theWinningNumber2 || theWinningNumber3 == theWinningNumber1 ) {
			
			theWinningNumber3 = generator.nextInt(largestTicketNumber - smallestTicketNumber + 1) + smallestTicketNumber;
		}
		
		winningNumber1 = theWinningNumber1;
		winningNumber2 = theWinningNumber2;
		winningNumber3 = theWinningNumber3;
	}
	
	
	final static int LEAST_NUMBER_OF_TICKETS_SOLD = 2;
	
	
	public static void setTicketNumbers(int smallNum, int largeNum) {
		
		Scanner scan = new Scanner(System.in);
		
		while (smallNum <= 0 ) {
			System.out.println("Please enter the smallest ticket number again and it must be greater than 0");
			smallNum = Integer.parseInt(scan.nextLine());
			
		}
		
		
		
		while (largeNum <= 0 || ((largeNum - smallNum) < LEAST_NUMBER_OF_TICKETS_SOLD)  ) {
			while (largeNum <= 0) {
				System.out.println("Largest ticket number must be greater than 0, please enter it again");
				largeNum = Integer.parseInt(scan.nextLine());
				
				
			}
			
			while( (largeNum - smallNum) < LEAST_NUMBER_OF_TICKETS_SOLD ) {
				System.out.println("There must be at least three tickets sold, please enter more than or equal to:" + (smallNum + LEAST_NUMBER_OF_TICKETS_SOLD) + " for the largets ticket number. " );
				largeNum = Integer.parseInt(scan.nextLine());
			}
		}
		
		smallestTicketNumber = smallNum;
		largestTicketNumber = largeNum;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			
		
		Scanner scan = new Scanner(System.in);
		
		boolean again = true;
		
		do {
		
		System.out.println("Please enter the name of the raffle");
		String nameOfTheRaffle = scan.nextLine();
		
		setNameOfRaffle(nameOfTheRaffle);
		
		System.out.println("Please enter the smallest ticket number sold.");
		int smallNumber = Integer.parseInt(scan.nextLine());
		
		System.out.println("Please enter the largest ticket number sold.");
		int largeNumber = Integer.parseInt(scan.nextLine());
		
		setTicketNumbers( smallNumber, largeNumber);
			
		setWinningNumbers();
		
		System.out.println("The name of the Raffle is: " + getNameOfRaffle());
		
		getWinningNumbers();
		
		System.out.println("Do you want to repeat and enter information for another (new) raffle? Enter \"y\" or \"n\"");
		
		String userChoice = scan.nextLine();
		
		if(!userChoice.equalsIgnoreCase("y")) {
			again = false;
		}
		
	} while(again);
	
		System.out.println("Goodbye");
  }

}
