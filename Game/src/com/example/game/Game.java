package com.example.game;

public class Game {
	
	public static int p1w = 0;
	public static int p2w = 0;
	public static int p3w = 0;
	public static int draws = 0;
	public static int noOfGames;
	public static int gameMode;
	
	String[] p1;
	String[] p2;
	String[] p3;
	String[] p1P;
	String[] p2P;
	String[] p3P;
	
	public static final int ROCKLIST = 1;
	public static final int PAPERLIST = 2;
	public static final int SCISSORSLIST = 3;
	public static final int LIZARDLIST = 4;
	public static final int SPOCKLIST = 5;
	public static final int SPIDERMANLIST = 6;
	public static final int BATMANLIST = 7;
	public static final int WIZARDLIST = 8;
	public static final int GLOCKLIST = 9;
	
	public Game(int player1, int player2, int incGameMode){
		if (player1 == ROCKLIST){
			p1 = rockList;
			p1P = rockPhrase;}
		else if (player1 == PAPERLIST){
			p1 = paperList;
			p1P = paperPhrase;}
		else if (player1 == SCISSORSLIST){
			p1 = scissorsList;
			p1P = scissorsPhrase;}
		else if (player1 == LIZARDLIST){
			p1 = lizardList;
			p1P = lizardPhrase;}
		else if (player1 == SPOCKLIST){
			p1 = spockList;
			p1P = spockPhrase;}
		else if (player1 == SPIDERMANLIST){
			p1 = spidermanList;
			p1P = spidermanPhrase;}
		else if (player1 == BATMANLIST){
			p1 = batmanList;
			p1P = batmanPhrase;}
		else if (player1 == WIZARDLIST){
			p1 = wizardList;
			p1P = wizardPhrase;}
		else if (player1 == GLOCKLIST){
			p1 = glockList;
			p1P = glockPhrase;}
		if (player2 == ROCKLIST){
			p2 = rockList;
			p2P = rockPhrase;}
		else if (player2 == PAPERLIST){
			p2 = paperList;
			p2P = paperPhrase;}
		else if (player2 == SCISSORSLIST){
			p2 = scissorsList;
			p2P = scissorsPhrase;}
		else if (player2 == LIZARDLIST){
			p2 = lizardList;
			p2P = lizardPhrase;}
		else if (player2 == SPOCKLIST){
			p2 = spockList;
			p2P = spockPhrase;}
		else if (player2 == SPIDERMANLIST){
			p2 = spidermanList;
			p2P = spidermanPhrase;}
		else if (player2 == BATMANLIST){
			p2 = batmanList;
			p2P = batmanPhrase;}
		else if (player2 == WIZARDLIST){
			p2 = wizardList;
			p2P = wizardPhrase;}
		else if (player2 == GLOCKLIST){
			p2 = glockList;
			p2P = glockPhrase;}
		gameMode = incGameMode;
		noOfGames++;
	}
	public Game(int player1, int player2, int player3, int incGameMode){
		if (player1 == ROCKLIST){
			p1 = rockList;
			p1P = rockPhrase;}
		else if (player1 == PAPERLIST){
			p1 = paperList;
			p1P = paperPhrase;}
		else if (player1 == SCISSORSLIST){
			p1 = scissorsList;
			p1P = scissorsPhrase;}
		else if (player1 == LIZARDLIST){
			p1 = lizardList;
			p1P = lizardPhrase;}
		else if (player1 == SPOCKLIST){
			p1 = spockList;
			p1P = spockPhrase;}
		else if (player1 == SPIDERMANLIST){
			p1 = spidermanList;
			p1P = spidermanPhrase;}
		else if (player1 == BATMANLIST){
			p1 = batmanList;
			p1P = batmanPhrase;}
		else if (player1 == WIZARDLIST){
			p1 = wizardList;
			p1P = wizardPhrase;}
		else if (player1 == GLOCKLIST){
			p1 = glockList;
			p1P = glockPhrase;}
		if (player2 == ROCKLIST){
			p2 = rockList;
			p2P = rockPhrase;}
		else if (player2 == PAPERLIST){
			p2 = paperList;
			p2P = paperPhrase;}
		else if (player2 == SCISSORSLIST){
			p2 = scissorsList;
			p2P = scissorsPhrase;}
		else if (player2 == LIZARDLIST){
			p2 = lizardList;
			p2P = lizardPhrase;}
		else if (player2 == SPOCKLIST){
			p2 = spockList;
			p2P = spockPhrase;}
		else if (player2 == SPIDERMANLIST){
			p2 = spidermanList;
			p2P = spidermanPhrase;}
		else if (player2 == BATMANLIST){
			p2 = batmanList;
			p2P = batmanPhrase;}
		else if (player2 == WIZARDLIST){
			p2 = wizardList;
			p2P = wizardPhrase;}
		else if (player2 == GLOCKLIST){
			p2 = glockList;
			p2P = glockPhrase;}
		if (player3 == ROCKLIST){
			p3 = rockList;
			p3P = rockPhrase;}
		else if (player3 == PAPERLIST){
			p3 = paperList;
			p3P = paperPhrase;}
		else if (player3 == SCISSORSLIST){
			p3 = scissorsList;
			p3P = scissorsPhrase;}
		else if (player3 == LIZARDLIST){
			p3 = lizardList;
			p3P = lizardPhrase;}
		else if (player3 == SPOCKLIST){
			p3 = spockList;
			p3P = spockPhrase;}
		else if (player3 == SPIDERMANLIST){
			p3 = spidermanList;
			p3P = spidermanPhrase;}
		else if (player3 == BATMANLIST){
			p3 = batmanList;
			p3P = batmanPhrase;}
		else if (player3 == WIZARDLIST){
			p3 = wizardList;
			p3P = wizardPhrase;}
		else if (player3 == GLOCKLIST){
			p3 = glockList;
			p3P = glockPhrase;}
		gameMode = incGameMode;
		noOfGames++;
	}
	public static void resetAll(){
		p1w = 0;
		p2w = 0;
		draws = 0;
		p3w = 0;
		noOfGames = 0;
	}
	public int getP1W(){
		return p1w;
	}
	public int getP2W(){
		return p2w;
	}
	public int getDraws(){
		return draws;
	}
	public int getP3W(){
		return p3w;
	}
	public int getNoOfGames(){
		return noOfGames;
	}
	public int getGameMode(){
		return gameMode;
	}
	public String play(){
		int result = 0;
		String phrase = "";
		if (!p1[0].equals(p2[0])) {
			for (int i = 1; i < p1.length; i++) {
				if (p1[i].equals(p2[0])) {
					result = 2;
					phrase = p1P[i];
					p1w++;
					break;
				}
				else {
						result = 1;
				}
			}
		}
		if(result == 1) {
			for (int j = 1; j < p2.length; j++) {
				if (p2[j].equals(p1[0])) {
					result = 2;
					phrase = p2P[j];
					p2w++;
					break;
				}
			}
		}
		if (result == 0) {
			phrase = "It's a draw since both chose " + p1[0].toString();
			draws++;
		}
		return phrase;
	}
	public String playThree(){
		String winner12 = "";
		String winner13 = "";
		String winner23 = "";
		String phrase12 = "";
		String phrase13 = "";
		String phrase23 = "";
		if (!p1[0].equals(p2[0])) {
			for (int i = 1; i < p1.length; i++) {
				if (p1[i].equals(p2[0])) {
					winner12 = "Player 1 beats Player 2: ";
					phrase12 = p1P[i];
					p1w++;
					break;
				}
				if (p2[i].equals(p1[0])) {
					winner12 = "Player 2 beats Player 1: ";
					phrase12 = p2P[i];
					p2w++;
					break;
				}
			}
		}
		else {
			phrase12 = "It's a draw betwheen Player 1 and Player 2 as both chose " + p1[0].toString();
			draws++;
		}
		if (!p1[0].equals(p3[0])) {
			for (int i = 1; i < p1.length; i++) {
				if (p1[i].equals(p3[0])) {
					winner13 = "Player 1 beats Player 3: ";
					phrase13 = p1P[i];
					p1w++;
					break;
				}
				if (p3[i].equals(p1[0])) {
					winner13 = "Player 3 beats player 1: ";
					phrase13 = p3P[i];
					p3w++;
					break;
				}
			}
		}
		else {
			phrase13 = "It's a draw betwheen Player 1 and Player 3 as both chose " + p1[0].toString();
			draws++;
		}
		if (!p2[0].equals(p3[0])) {
			for (int i = 1; i < p1.length; i++) {
				if (p2[i].equals(p3[0])) {
					winner23 = "Player 2 beats player 3: ";
					phrase23 = p2P[i];
					p2w++;
				}
				if (p3[i].equals(p2[0])) {
					winner23 = "Player 3 beats player 2: ";
					phrase23 = p3P[i];
					p3w++;
				}
			}
		}
		else {
			phrase23 = "It's a draw betwheen Player 2 and Player 3 as both chose " + p2[0].toString();
			draws++;
		}
		return winner12 + phrase12 + "\n" + winner13 + phrase13 + "\n" + winner23 + phrase23;
	}


	static String[] rockList = {"rock", "lizard", "wizard", "spider-man", "scissors"};
	static String[] paperList = {"paper", "rock", "spock", "batman", "glock"};
	static String[] scissorsList = {"scissors", "paper", "lizard", "wizard", "spider-man"};
	static String[] lizardList = {"lizard", "spock", "batman", "glock", "paper"};
	static String[] spockList = {"spock", "wizard", "spider-man", "scissors", "rock"};
	static String[] spidermanList = {"spider-man", "glock", "paper", "lizard", "wizard"};
	static String[] batmanList = {"batman", "spider-man", "scissors", "rock", "spock"};
	static String[] wizardList = {"wizard", "batman", "glock", "paper", "lizard"};
	static String[] glockList = {"glock", "scissors", "rock", "spock", "batman"};
		
	static String[] rockPhrase = {" ", "Rock crushes Lizard", "Rock interupts Wizard", "Rock knockes out Spider-Man", "Rock crushes Scissors"};
	static String[] paperPhrase = {" ", "Paper covers Rock", "Paper disproves Spock", "Paper delays Batman", "Paper jams Glock"};
	static String[] scissorsPhrase = {" ", "Scissors cut Paper", "Scissors decapitates Lizard", "Scissors cut Wizard", "Scissors cut Spider-Man"};
	static String[] lizardPhrase = {" ", "Lizard poisons Spock", "Lizard confuses Batman (because he looks like Killer Croc)", "Lizard is too small for Glock", "Lizard eats Paper"};
	static String[] spockPhrase = {" ", "Spock zaps Wizard", "Spock befuddles Spider-Man", "Spock smashes Scissors", "Spock vaporize Rock"};
	static String[] spidermanPhrase = {" ", "Spider-Man disarms Glock", "Spider-Man rips Paper", "Spider-Man defeats Lizard", "Spider-Man annoys Wizard"};
	static String[] batmanPhrase = {" ", "Batman scares Spider-Man", "Batman dismantles scissors", "Batman explodes rock", "Batman hangs Spock"};
	static String[] wizardPhrase = {" ", "Wizard stuns Batman", "Wizard melts Glock", "Wizard burns Paper", "Wizard transform Lizard"};
	static String[] glockPhrase = {" ", "Glock dents Scissors", "Glock breaks Rock", "Glock shoots Spock", "Glock kills Batman's mom"};
}