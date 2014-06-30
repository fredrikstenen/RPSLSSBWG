package com.example.game;

public class Play {
	public static String chooseSign(int i, int j){
		if (i == 1){
			p1 = rockList;
			p1P = rockPhrase;}
		if (i == 2){
			p1 = paperList;
			p1P = paperPhrase;}
		if (i == 3){
			p1 = scissorsList;
			p1P = scissorsPhrase;}
		if (i == 4){
			p1 = lizardList;
			p1P = lizardPhrase;}
		if (i == 5){
			p1 = spockList;
			p1P = spockPhrase;}
		if (i == 6){
			p1 = spidermanList;
			p1P = spidermanPhrase;}
		if (i == 7){
			p1 = batmanList;
			p1P = batmanPhrase;}
		if (i == 8){
			p1 = wizardList;
			p1P = wizardPhrase;}
		if (i == 9){
			p1 = glockList;
			p1P = glockPhrase;}
		if (j == 1){
			p2 = rockList;
			p2P = rockPhrase;}
		if (j == 2){
			p2 = paperList;
			p2P = paperPhrase;}
		if (j == 3){
			p2 = scissorsList;
			p2P = scissorsPhrase;}
		if (j == 4){
			p2 = lizardList;
			p2P = lizardPhrase;}
		if (j == 5){
			p2 = spockList;
			p2P = spockPhrase;}
		if (j == 6){
			p2 = spidermanList;
			p2P = spidermanPhrase;}
		if (j == 7){
			p2 = batmanList;
			p2P = batmanPhrase;}
		if (j == 8){
			p2 = wizardList;
			p2P = wizardPhrase;}
		if (j == 9){
			p2 = glockList;
			p2P = glockPhrase;}
		return players();
	}
	public static String players(){
		int result = 0;
		String phrase = "";
		if (!p1[0].equals(p2[0])) {
			for (int i = 1; i < p1.length; i++) {
				if (p1[i].equals(p2[0])) {
					result = 2;
					phrase = p1P[i];
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
					break;
				}
			}
		}
		if (result == 0) {
			phrase = "It's a draw";
		}
		return phrase;
	}
		
	static String[] p1;
	static String[] p2;
	static String[] p1P;
	static String[] p2P;

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