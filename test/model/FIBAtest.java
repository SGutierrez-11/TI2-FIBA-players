package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FIBAtest {
	
	private FIBA<Integer> fiba;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		fiba = new FIBA<>();
	}
	
	@Test
	public void searchLessTest1() {
		setupStage1();
		
		FIBA<Integer> f = new FIBA<>();
		
		assertNotNull(f);
	}
	
	@Test
	public void searchLessTest2() {
		setupStage2();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Player p = new Player("Sam", 20, "USS",1,2,3,4,5);
		player.add(p);
		fiba.addPlayerToAllTrees(p);
		
		
		
	}
}
