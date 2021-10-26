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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getPointsPerGame() {
		return pointsPerGame;
	}

	public void setPointsPerGame(double pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}

	public double getBouncesPerGame() {
		return bouncesPerGame;
	}

	public void setBouncesPerGame(double bouncesPerGame) {
		this.bouncesPerGame = bouncesPerGame;
	}

	public double getAssistencesPerGame() {
		return assistencesPerGame;
	}

	public void setAssistencesPerGame(double assistencesPerGame) {
		this.assistencesPerGame = assistencesPerGame;
	}

	public double getStealsPerGame() {
		return stealsPerGame;
	}

	public void setStealsPerGame(double stealsPerGame) {
		this.stealsPerGame = stealsPerGame;
	}

	public double getBlocksPerGame() {
		return blocksPerGame;
	}

	public void setBlocksPerGame(double blocksPerGame) {
		this.blocksPerGame = blocksPerGame;
	}
	
	
	
	}
