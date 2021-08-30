package com.tictactoe;

import java.util.*;

public class TictactoeGame {

	//Initialising the board
	static char[] board = new char[10];

	//@param for letter choice by user and computer
	public static char letter_choice_player,letter_choice_computer;

	public static Random rand=new Random();

	public static String turn;

	public static int location;

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
		System.out.println("Please enter the index value (position) you want to play");
		int location = sc.nextInt();
		if(location < 1 || location > 9)	//check if index is between 1 and 9
		{
			System.out.println("Please enter the location value between 1 and 9!!");
			selectLocation();
		}	
	}

	/*@method moves to desired location
	 * if the space is free
	 */
	public static void desiredMove() {
		if(board[location] == ' ') { 			//check if index is free
			System.out.println("Empty");
			board[location] = letter_choice_player;
		}
		else
		{
			System.out.println("Please enter different index, current one is already filled");
			selectLocation();					//@call select location method
			desiredMove();
		}
		dispBoard();
	}

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
			turn="player";	
		}
		else
		{
			System.out.println("Its computer's turn!!!");
			turn="computer";
		}

	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		createBoard();
		letterChoice();
		toss();
		dispBoard();
		selectLocation();
		desiredMove();

	}

}
