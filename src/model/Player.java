package model;

import java.util.Comparator;

public class Player implements Comparator<Object>{

	String name;
	
	int age;
	
	String team;
	
	double pointsPerGame;
	
	double bouncesPerGame;
	
	double assistencesPerGame;
	
	double stealsPerGame;
	
	double blocksPerGame;
	
	public Player(String name, int age, String team, double pointsPerGame, double bouncesPerGame, double assistencesPerGame, double stealsPerGame, double blocksPerGame) {
		
		this.name = name;
		this.age = age;
		this.team = team;
		this.pointsPerGame = pointsPerGame;
		this.bouncesPerGame = bouncesPerGame;
		this.assistencesPerGame = assistencesPerGame;
		this.stealsPerGame = stealsPerGame;
		this.blocksPerGame = blocksPerGame;
		
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	}
