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
		char c = sc.next().charAt(0);
		playerLetter = c;
		computerLetter = playerLetter == 'X' ? 'O' : 'X';
	}

	// main
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		Scanner sc = new Scanner(System.in);
		TicTacToeGame tttg = new TicTacToeGame();
		tttg.fillBoard();
		tttg.allowPlayer(sc);
		sc.close();
	}
}
