package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class FIBAtest {
	
	private FIBA<Integer> fiba;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		fiba = new FIBA<>();
	}
	
	@Test
	public void addTest1() {
		setupStage1();
		FIBA<Integer> f = new FIBA<>();
		
		assertNotNull(f.allPlayers);
	}
	
	@Test
	public void addTest2() {
		setupStage2();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Player p = new Player("Sam", 20, "USS",1,2,3,4,5);
		player.add(p);
		fiba.addPlayerToAllTrees(p);
		
		assertNotNull(fiba.allPlayers);
		
	}
	
	@Test
	public void searchLessTest1() {
		setupStage1();
		
		FIBA<Integer> f = new FIBA<>();
		
		assertNull(f.searchLess(0, 0));
	}
	
	@Test
	public void searchLessTest2() {
		setupStage2();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Player p = new Player("Sam", 20, "USS",1,2,3,4,5);
		player.add(p);
		fiba.addPlayerToAllTrees(p);
		assertEquals(fiba.searchLess(1, 2), fiba.changeTree);
	}
	
	@Test
	public void searchMoreTest1() {
		setupStage1();
		
		FIBA<Integer> f = new FIBA<>();
		
		assertNull(f.searchMore(0, 0));
	}
	
	@Test
	public void searchMoreTest2() {
		setupStage2();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Player p = new Player("Sam", 20, "USS",1,2,3,4,5);
		player.add(p);
		fiba.addPlayerToAllTrees(p);
		assertEquals(fiba.searchMore(1, 2), fiba.changeTree);
	}
	
	@Test
	public void searchEqualsTest1() {
		setupStage1();
		
		FIBA<Integer> f = new FIBA<>();
		
		assertNull(f.searchEquals(0, 0));
	}
	
	@Test
	public void searchEqualsTest2() {
		setupStage2();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Player p = new Player("Sam", 20, "USS",1,2,3,4,5);
		player.add(p);
		fiba.addPlayerToAllTrees(p);
		assertEquals(fiba.searchEquals(1, 1), fiba.changeTree);
	}
}
