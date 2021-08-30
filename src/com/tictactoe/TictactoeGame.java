package com.tictactoe;

import java.util.*;

public class TictactoeGame {

	//Initialising the board
	static char[] board = new char[10];

	//@param for letter choice by user and computer
	public static char letter_choice_player,letter_choice_computer;

	//@param To get random values 
	public static Random rand=new Random();

	//@param to check whose turn to play,turn can be of player or computer
	public static String turn;

	//@Param to store index 
	public static int location;

	//@string to keep track of winning
	public static String winner ="no";

	//Initialising scanner
	static Scanner sc = new Scanner(System.in);

	/**
	 * @method to create board with empty space
	 */
	public static void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	/**
	 * @method To user to select X or O
	 * If user selects 'X' then computer takes 'O'
	 * else user takes 'O'
	 */
	public static void letterChoice() {
		System.out.println("Please enter your choice\n X or O ");
		letter_choice_player = sc.next().charAt(0);
		if(letter_choice_player == 'X') { 
			letter_choice_computer = 'O';
		}
		else {
			letter_choice_computer = 'X';
		}
		System.out.println("Your choice is "+letter_choice_player);
		System.out.println("Computer choice is "+letter_choice_computer);
	}

	/**
	 * @method to display board
	 */
	public static void dispBoard() {
		System.out.println(" "+board[1] + " | "+ board[2] + " | " + board[3]);	//display first row
		System.out.println("---+---+---");
		System.out.println(" "+board[4] + " | "+ board[5] + " | " + board[6]);	//display second row
		System.out.println("---+---+---");
		System.out.println(" "+board[7] + " | "+ board[8] + " | " + board[9]);	//display third row
	}

	/**
	 * @method To allow user to select location value in box to play
	 * Location value between 1 to 9
	 */
	public static void selectLocation() {
		turn = "player";
		System.out.println("Please enter the index value (position) you want to play");
		location = sc.nextInt();
		if(location < 1 || location > 9)	//check if index is between 1 and 9
		{
			System.out.println("Please enter the location value between 1 and 9!!");
			selectLocation();
		}
		desiredMove();
	}

	/*@method moves to desired location
	 * if the space is free
	 */
	public static void desiredMove() {
		if(board[location] == ' ') { 			//check if index is free
			board[location] = letter_choice_player;
		}
		else
		{
			System.out.println("Please enter different index, current one is already filled");
			selectLocation();					//@call select location method
			desiredMove();
		}
		dispBoard();
		checkWinner();
		displayWinner();
	}

	/**
	 * @method To check who plays first
	 */
	public static void toss()
	{
		System.out.println("Enter your choice for turn\n 0.Head\n 1.Tail");
		int choice=sc.nextInt();	

		/* a random number is chosen between 1 or 0
		 * if its 0 then head or if it is 1 its tail
		 */
		int toss_choice=rand.nextInt(2);						
		if(choice==toss_choice)
		{
			System.out.println("Its player's turn!!!");
			selectLocation();	
		}
		else
		{
			System.out.println("Its computer's turn!!!");
			computerGame();
		}

	}

	/**
	 * @method to check if there is a winner after every move,
	 *  later its iterated through board to check if all values are filled if yes then draw
	 * or else next person plays
	 * @returns char to check and display
	 */
	public static char checkWinner() {
		String line = null;

		//to check if there is an winning situation
		for (int s = 1; s < 9; s++) 
		{

			switch (s) {
			case 1:
				line = ""+board[1] + board[2] + board[3];
				break;
			case 2:
				line = ""+board[4] + board[5] + board[6];
				break;
			case 3:
				line = ""+board[7] + board[8] + board[9];
				break;
			case 4:
				line = ""+board[1] + board[4] + board[7];
				break;
			case 5:
				line = ""+board[2] + board[5] + board[8];
				break;
			case 6:
				line = ""+board[3] + board[5] + board[9];
				break;
			case 7:
				line = ""+board[1] + board[5] + board[9];
				break;
			case 8:
				line = ""+board[3] + board[5] + board[7];
				break;
			}
			//winner is X
			if (line.equals("XXX")) {
				return 'X';
			} 
			// winner is O
			else if (line.equals("OOO")) {
				return 'O';
			}
		}
		int i;
		for(i = 1;i <= 9;i++) {
			if (board[i]==' ') 
			{
				break;
			}
		}
		if(i == 9)
			return 'd';
		else
			return 'n';

	}

	/**
	 * @method to display the winning player or indicate a tie
	 */
	public static void displayWinner() {
		char winner = checkWinner();
		if (winner == letter_choice_player) {
			System.out.println("Congrats!You are the winner!");
			System.exit(0);
		}
		else if(winner == letter_choice_computer) {
			System.out.println("You lost! Computer is the winner!");
			System.exit(0);
		}
		else if(winner == 'd') {
			System.out.println("Game is tied");
			System.exit(0);
		}
		else {
			if(turn == "player") {
				System.out.println("Computer's turn to play!");
				computerGame();

			}
			else {
				selectLocation();
			}
		}
	}

	/**
	 * @method to check the computer game
	 */
	public static void computerGame() {
		turn = "computer";
		System.out.println("Computer is playing!!!");	
		if((board[1]==' ')&&(board[2]==board[3]&&board[2]==letter_choice_computer)||(board[4]==board[7]&&board[4]==letter_choice_computer)||(board[5]==board[9]&&board[5]==letter_choice_computer))
		{
			board[1]=letter_choice_computer;			
		}
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==letter_choice_computer)||(board[5]==board[8]&&board[8]==letter_choice_computer))
		{
			board[2]=letter_choice_computer;
		}
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==letter_choice_computer)||(board[6]==board[9]&&board[9]==letter_choice_computer)||(board[5]==board[7]&&board[7]==letter_choice_computer))
		{
			board[3]=letter_choice_computer;
		}
		else if((board[4]==' ')&&(board[1]==board[7]&&board[1]==letter_choice_computer)||(board[5]==board[6]&&board[6]==letter_choice_computer))
		{
			board[4]=letter_choice_computer;
		}
		else if((board[5]==' ')&&(board[1]==board[9]&&board[2]==letter_choice_computer)||(board[7]==board[3]&&board[7]==letter_choice_computer)||(board[2]==board[8]&&board[8]==letter_choice_computer)||(board[4]==board[6]&&board[6]==letter_choice_computer))
		{
			board[5]=letter_choice_computer;
		}
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==letter_choice_computer)||(board[5]==board[4]&&board[4]==letter_choice_computer))
		{
			board[6]=letter_choice_computer;
		}
		else if((board[7]==' ')&&(board[1]==board[4]&&board[4]==letter_choice_computer)||(board[3]==board[5]&&board[3]==letter_choice_computer)||(board[8]==board[9]&&board[8]==letter_choice_computer))
		{
			board[3]=letter_choice_computer;
		}
		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==letter_choice_computer)||(board[2]==board[5]&&board[2]==letter_choice_computer))
		{
			board[8]=letter_choice_computer;
		}
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==letter_choice_computer)||(board[6]==board[3]&&board[3]==letter_choice_computer)||(board[8]==board[7]&&board[7]==letter_choice_computer))
		{
			board[9]=letter_choice_computer;
		}
		else {
			computerPlay();			
		}
		dispBoard();
		selectLocation();
	}
	public static void computerPlay()
	{
		int computer_index=rand.nextInt(9)+1;
		if(board[computer_index]==' ')
			board[computer_index]=letter_choice_computer;
		else
			computerPlay();
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		createBoard();
		letterChoice();
		toss();


	}

}
