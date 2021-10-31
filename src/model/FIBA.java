package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import collections.AVL;

public class FIBA<T> {

	ArrayList<Player> allPlayers;
	
	ArrayList<Player> changeTree;
	
	private AVL<Player> pointsTree;
	

	private Comparator<Player> c;
	

	private AVL<Player> bouncesTree;
	
	private AVL<Player> assistencesTree;
	
	private AVL<Player> blocksTree;
	
	private AVL<Player> stealsTree;
	
	private Comparator<Player> comparePoints;
	
	private Comparator<Player> compareBounces;
	
	private Comparator<Player> compareSteals;
	
	private Comparator<Player> compareBlocks;
	
	private Comparator<Player> compareAssistences;
	
	public FIBA() {
		
		//Player tmp = new Player("name",00,"Team",00,00,00,00,00);
		comparePoints = Comparator.comparing((Player player)->player.getPointsPerGame());
		if(comparePoints==null) {
			System.out.println("Esto da nulo");
		}
		
		compareBounces = Comparator.comparing((Player player)->player.getBouncesPerGame());
		compareSteals = Comparator.comparing((Player player)->player.getStealsPerGame());
		compareBlocks = Comparator.comparing((Player player)->player.getBlocksPerGame());
		compareAssistences = Comparator.comparing((Player player)-> player.getAssistencesPerGame());
		
		allPlayers = new ArrayList<Player>();

		pointsTree = new AVL<>(c);

		changeTree = new ArrayList<Player>();
		pointsTree = new AVL<Player>(comparePoints);
		bouncesTree = new AVL<Player>(compareBounces);
		blocksTree = new AVL<Player>(compareBlocks);
		stealsTree = new AVL<Player>(compareSteals);
		assistencesTree = new AVL<Player>(compareAssistences);

	}
	
	
	public void importData(String localPath)throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(localPath));
		
		String line = br.readLine();
		
		line = br.readLine();
		
		while(line!=null) {
			
			String[]parts = line.split(";");
			Player tmp = new Player(parts[0],Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]), Double.parseDouble(parts[7]));
			if(parts[0].equals("0")) {
				
			}else {
			allPlayers.add(tmp);
			addPlayerToAllTrees(tmp);
			}
			line = br.readLine();
			
		}
		br.close();
		
	}
	public ArrayList<Player> searchLess(int tree, double condition){
		
		Player tmp;
		
		switch(tree) {
		
		case 1: 
		tmp = new Player("W",00,"Z", condition,0,0,0,0);
		changeTree = (ArrayList<Player>) pointsTree.getLessThan(pointsTree.search(tmp));
			
		break;
		case 2:
		tmp = new Player("W",00,"Z",0,condition,0,0,0);
		changeTree = (ArrayList<Player>) bouncesTree.getLessThan(pointsTree.search(tmp));
		
		break;
		case 3:
		tmp = new Player("W",00,"Z", 0,0,condition,0,0);	
		changeTree = (ArrayList<Player>) assistencesTree.getLessThan(pointsTree.search(tmp));
		
		break;
		case 4:
		tmp = new Player("W",00,"Z", 0,0,0,condition,0);
		changeTree = (ArrayList<Player>) blocksTree.getLessThan(blocksTree.search(tmp));
		
		break;
		case 5:
		tmp = new Player("W",00,"Z",0,0,0,0,condition);
		changeTree = (ArrayList<Player>) stealsTree.getLessThan(stealsTree.search(tmp));
		
		break;
		
		
		}
		
		
		
		return changeTree;
	}
	public ArrayList<Player> searchMore(int tree, double condition){
		
		//Player tmp;
		
		switch(tree) {
		
		case 1: 
		//tmp = new Player("W",00,"Z", condition,0,0,0,0);
		changeTree = (ArrayList<Player>) pointsTree.getGreaterThan(pointsTree.search(condition));
			
		break;
		case 2:
		//tmp = new Player("W",00,"Z",0,condition,0,0,0);
		changeTree = (ArrayList<Player>) bouncesTree.getGreaterThan(pointsTree.search(condition));
		
		break;
		case 3:
		//tmp = new Player("W",00,"Z", 0,0,condition,0,0);	
		changeTree = (ArrayList<Player>) assistencesTree.getGreaterThan(pointsTree.search(condition));
		
		break;
		case 4:
		//tmp = new Player("W",00,"Z", 0,0,0,condition,0);
		changeTree = (ArrayList<Player>) blocksTree.getGreaterThan(blocksTree.search(condition));
		
		break;
		case 5:
		//tmp = new Player("W",00,"Z",0,0,0,0,condition);
		changeTree = (ArrayList<Player>) stealsTree.getGreaterThan(stealsTree.search(condition));
		
		break;
		
		
		}
		
		
		
		return changeTree;
	}
	
	/*
	public void addPlayerToMainTree() {
		
	}
	 */
	public void addPlayerToAllTrees(Player player) {
		
		pointsTree.add(player);
		bouncesTree.add(player);
		assistencesTree.add(player);
		blocksTree.add(player);
		stealsTree.add(player);
		
	}
	
	
	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}


	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
	
	
}
