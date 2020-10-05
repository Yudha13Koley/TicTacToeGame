package com.training.tictactoe;

import java.util.*;

public class TicTacToeGame {
	char[] board;
	char playerLetter;
	char computerLetter;

	// constructor
	public TicTacToeGame() {
		board = new char[10];
	}

	// fill the board with empty space
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
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

	// main
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		Scanner sc = new Scanner(System.in);
		TicTacToeGame TTTG = new TicTacToeGame();
		TTTG.fillBoard();
		TTTG.allowPlayer(sc);
		TTTG.printBoard();
		sc.close();

	}
}
