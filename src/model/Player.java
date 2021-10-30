package model;

public class Player{

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

	class ComparePlayer{
		
		//Identificar guide:
		//1 = points per game
		//2 = bounces per game
		//3 = assistences per game
		//4 = steals per game
		//5 = blocks per game
		
		
		public static int compare(Player o1, Player o2, int identificator) {
		
			int toReturn = 0;
			
			switch(identificator) {
			
			case 1: 
				toReturn = Double.compare(o1.getPointsPerGame(), o2.getPointsPerGame());
				break;
			case 2:
				toReturn = Double.compare(o1.getBouncesPerGame(), o2.getBouncesPerGame());
				break;
			case 3:
				toReturn = Double.compare(o1.getAssistencesPerGame(), o2.getAssistencesPerGame());
				break;
			case 4:
				toReturn = Double.compare(o1.getStealsPerGame(), o2.getStealsPerGame());
				break;
			case 5:
				toReturn = Double.compare(o1.getBlocksPerGame(), o2.getBlocksPerGame());
			}
			
			return toReturn;
		}
		/*
		public int compare(Player o1, Player o2, int identificator, int identificator2) {
			
			int toReturn = 0;
			
			switch(identificator) {
			
			case 1: 
				toReturn = Double.compare(o1.getPointsPerGame(), o2.getPointsPerGame());
				switch(identificator2) {
					
					
					
					
				}
				break;
			case 2:
				toReturn = Double.compare(o1.getBouncesPerGame(), o2.getBouncesPerGame());
				break;
			case 3:
				toReturn = Double.compare(o1.getAssistencesPerGame(), o2.getAssistencesPerGame());
				break;
			case 4:
				toReturn = Double.compare(o1.getStealsPerGame(), o2.getStealsPerGame());
				break;
			case 5:
				toReturn = Double.compare(o1.getBlocksPerGame(), o2.getBlocksPerGame());
			}
			
			return toReturn;
		}
		*/
	}
	
