package com.tictactoe;

import java.util.Scanner;

public class TictactoeGame {

	char[] board = new char[10];
	public static char letter_choice_player,letter_choice_computer;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		TictactoeGame tictactoe = new TictactoeGame();
		tictactoe.createBoard();
		letterChoice();

	}

	public void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	public static void letterChoice() {
		System.out.println("Please enter your choice\n X or O ");
		Scanner sc = new Scanner(System.in);
		letter_choice_player = sc.next().charAt(0);
		if(letter_choice_player == 'X') {
			letter_choice_computer = 'O';
		}
		else {
			letter_choice_computer = 'X';
		}
		System.out.println("Your choice is "+letter_choice_player);
	}

}
