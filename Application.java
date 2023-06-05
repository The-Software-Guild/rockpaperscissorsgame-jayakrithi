package RockPaperScissors;

import java.util.Scanner;

public class Application {
	public static int ROCK = 1;
	public static int PAPER = 2;
	public static int SCISSORS = 3;
	
	public static int computerWins =0;
	public static int userWins =0;
	public static int ties =0;
	
	public static int whoWins(int me, int computer) {
		// computer wins = -1
		// user wins = 1
		// ties = 0
		
		int winner = 0; 
		if(me==1) {
			if(computer==1) {
				ties=ties+1;
				return winner =0;
			}
			else if(computer==2) {
				computerWins = computerWins+1;
				return winner =-1;
			}
			else if(computer==3) {
				userWins = userWins+1;
				return winner = 1;
			}
		}
		else if(me==2) {
			if(computer==1) {
				userWins = userWins+1;
				return winner =1;
			}
			else if(computer==2) {
				ties=ties+1;
				return winner =0;
			}
			else if(computer==3) {
				computerWins = computerWins+1;
				return winner =-1;
			}
		}
		else if(me==3) {
			if(computer==1) {
				computerWins = computerWins+1;
				return winner =-1;
			}
			else if(computer==2) {
				userWins = userWins+1;
				return winner =1;
			}
			else if(computer==3) {
				ties=ties+1;
				return winner =0;
			}
		}
		return 0;
	}
	
	public static String choice(int i) {
		switch(i){
		case (1): return "Rock";
		case (2): return "Paper";
		case (3): return "Scissors";
		}
		return ""; //default
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi There!, Welcome to Rock Paper Scissors");
		System.out.println("How many rounds would you like to play???");
		int rounds = sc.nextInt();
		int continueGame = 1;
		
		while(continueGame == 1){
			while(rounds < 1 || rounds > 10) {
				System.out.println("Please enter number of rounds within the range 1 to 10");
				rounds = sc.nextInt();
				
				if(rounds>1 && rounds <10) {break;}
			}
			System.out.println("Game begins! Good luck!");
			
			while(rounds >0) {
				System.out.println("Please enter your choice \n"
						+ "For Rock = 1 \n"
						+ "For Paper = 2 \n"
						+ "For Scissors = 3 \n");
				
				int usersChoice = sc.nextInt();
				System.out.println("You have entered "+choice(usersChoice));
				
				int computersChoice = (int) ((Math.random() * (3 - 1)) + 1);
				
				System.out.println("Computer has entered "+choice(computersChoice));
				int n = whoWins(usersChoice, computersChoice);
				
				if(n == 0) {
					System.out.println("Its a TIE!! ");
				}
				else if(n==1) {
					System.out.println("You WIN!! ");
					
				}else if(n==-1) {
					System.out.println("You Lost this round :( ");
					
				}
				rounds--;
			}
			
			if(ties > computerWins && ties > userWins) {
				System.out.println("Its a Draw!! :o");
			}
			else if(computerWins > userWins) {
				System.out.println("You Lose :(");
			}
			else if(userWins > computerWins) {
				System.out.println("Hurray!! You Win");
			}
			System.out.println("Scores");
			System.out.println("Your score is "+ userWins);
			System.out.println("The computer's score is "+ computerWins);
			System.out.println("Number of Ties "+ ties);
			
			System.out.println("Do you want to play again? Please enter 'y' if yes and 'n' for no");
			String quit = sc.next();
			if(quit.equals("y") ||quit.equals("Y")) {
				continueGame = 1;
			}else 
				{
				System.out.println("Thank you for playing! ");
				continueGame =0;
				break;
				}
		}
		

	}

}
