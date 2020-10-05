package com.training.tictactoe;

import java.util.*;

public class TicTacToeGame {
	char[] board;
	char playerLetter;
	char computerLetter;
	boolean[] isFree;

	// constructor
	public TicTacToeGame() {
		board = new char[10];
		isFree=new boolean[10];
	}

	// fill the board with empty space
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		for (int i = 0; i < isFree.length; i++) {
			isFree[i] = true;
		}
	}

	// player choice input
	private void allowPlayer(Scanner sc) {
		System.out.println("Input Your Choice X or O");
		char c = sc.next().toUpperCase().charAt(0);
		if(c!='O'&& c!='X')
			allowPlayer(sc);
		playerLetter = c;
		computerLetter = playerLetter == 'X' ? 'O' : 'X';
	}

	// Print Board
	private void printBoard() {
		for (int i = 1; i < board.length; i++) {
			if (i % 3 == 1 || i % 3 == 2)
				System.out.print(board[i] + "  | ");
			if (i % 3 == 0) {
				System.out.println(board[i]);
				if (i != board.length - 1)
					System.out.println("-------------");
			}
		}
	}
	// Overload printBoard
	private void printBoard(char[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (i % 3 == 1 || i % 3 == 2)
				System.out.print(arr[i] + "  | ");
			if (i % 3 == 0) {
				System.out.println(arr[i]);
				if (i != arr.length - 1)
					System.out.println("-------------");
			}
		}
	}
	//print free space
	private void printSpace(boolean[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (i % 3 == 1 || i % 3 == 2)
				System.out.print(arr[i] + "  | ");
			if (i % 3 == 0) {
				System.out.println(arr[i]);
				if (i != arr.length - 1)
					System.out.println("---------------------");
			}
		}
	}
	
	//playerMove
	private void makePlayerMove(Scanner sc) {
		System.out.println("Enter a Position player want to move(1 to 9) : ");
		int position =sc.nextInt();
		if(position<0||position>9)
		{
			System.out.println("Enter a valid position :");
			makePlayerMove(sc);
		}
		else if(isFree[position]) {
			System.out.println("The position is free to move :");
			board[position]=playerLetter;
			isFree[position]=false;
			printBoard(board);
			printSpace(isFree);
		}
		else {
			System.out.println("The position is occupied :");
			makePlayerMove(sc);
		}
		
	}

	// main
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		Scanner sc = new Scanner(System.in);
		TicTacToeGame TTTG = new TicTacToeGame();
		TTTG.fillBoard();
		TTTG.allowPlayer(sc);
		TTTG.printBoard();
		TTTG.makePlayerMove(sc);
		sc.close();
	}
}
