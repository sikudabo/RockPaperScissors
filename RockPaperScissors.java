package com.java.practice.SimiPracticeJava;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.Collator;

/**
 *  @author Simeon Ikudabo
 *  This is a simple game of Rocker, Paper Scissors that I created in Java 10. There can be 1 user who will play against the 
 *  computer. The game is run in a "do-while" loop, and in gaming we call this the "main game loop. This is where the main 
 *  functionality of the game will take place. I created a Scanner object named "scan" to store user input. Each time the user
 *  can guess R (for rock), P (for paper) or S (for scissors). A user may accidentally enter a lowercase, so I tell the program
 *  to ignore the case that the user enters. Outside of the main game loop I also create the variables computerWins, userWins, 
 *  game, and keepPlaying. computerWins and userWins will store the number of times either the computer wins or the user wins. 
 *  The boolean variable "game" is a flag (similar to what we use in while-loops in Python) that will determine if the game is 
 *  still active or not. When either the user or computer has 2 wins, the variable game will have a value of false. If the user 
 *  wants to play again, the value will then go back to true. The String keepPlaying will store whether or not the user wants to 
 *  continue to play the game. If the user and computer draw, neither will be given an additional point. If the user wins, the user
 *  will get one point. If the computer wins, the computer gets 1 point. The first one to two points wins the game. 
 */

public class App 
{
    public static void main( String[] args )throws IOException{
    	System.out.println("Welcome to Java Rock, Paper Scissors by Simeon Ikudabo");
    	System.out.println("Enter R for Rock, Enter P for paper and enter S for scissors!");
    	System.out.println("You must beat the computer 2 out of 3 times to win the game");
    	Scanner scan = new Scanner(System.in);
    	int computerWins = 0;
    	int userWins = 0;
    	boolean game = true;
    	String keepPlaying = "";
    	
    	do {
    		int generatedNumber = (int)(Math.random() * 3 + 1);
    		String rps;
    		if(generatedNumber == 1) {
    			rps = "s";
    		}
    		else if(generatedNumber == 2) {
    			rps = "p";
    		}
    		else {
    			rps = "r";
    		}
    		
    		System.out.println("Enter your guess: ");
    		String userPlay = scan.next();
    		if((userPlay.equalsIgnoreCase("s") && rps.equals("s")) || (userPlay.equalsIgnoreCase("p") && rps.equals("p")) 
    				|| (userPlay.equalsIgnoreCase("r") && rps.equals("r"))) {
    					System.out.println("The compter guessed: " + rps);
    					System.out.println("DRAW!");
    					System.out.println("The score is Computer: " + computerWins + " User: " + userWins);
    		}
    		else if((userPlay.equalsIgnoreCase("s") && rps.equals("p")) || (userPlay.equalsIgnoreCase("p") && rps.equals("r"))
    				||(userPlay.equalsIgnoreCase("r") && rps.equals("s"))){
    					userWins += 1;
    					System.out.println("The computer guessed: " + rps);
    					System.out.println("You win that round!");
    					System.out.println("The score is Computer: " + computerWins + " User: " + userWins);
    		}
    		else {
    			computerWins += 1;
    			System.out.println("The computer guessed: " + rps);
    			System.out.println("You lost that round!");
    			System.out.println("The score is Computer: " + computerWins + " User: " + userWins);
    			
    			
    		}
    		
    		if(computerWins >= 2) {
    			System.out.println("The computer wins!");
    			game = false;
    		}
    		else if(userWins >= 2) {
    			System.out.println("You win!");
    			game = false;
    		}
    		if(!game) {
    			System.out.println("Do you want to play again?(yes/no)");
    			keepPlaying = scan.next();
    		}
    		if(keepPlaying.equalsIgnoreCase("yes")) {
    			userWins = 0;
    			computerWins = 0;
    			game = true;
    		}
    		
    		
    		
    			
    	
    	}while(!(keepPlaying.equalsIgnoreCase("no")));
    	
    	
    }
    
    
    
}