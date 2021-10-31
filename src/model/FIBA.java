package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import collections.AVL;

public class FIBA<T> {

	ArrayList<Player> allPlayers;
	
	private AVL<Player> pointsTree;
	
	private Comparator<Player> c;
	
	
	public FIBA() {
		
		allPlayers = new ArrayList<Player>();
		pointsTree = new AVL<>(c);
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
			}
			line = br.readLine();
			
		}
		br.close();
		
	}
	public void addPlayerToMainTree() {
		
	}


	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}


	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
	
	
}
