package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class AVLtest {
	
	private AVL<Integer> avl;

	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		avl = new AVL<>(c);
	}
	
	@Test
	public void addTest1() {
		setupStage1();
		
		Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		AVL<Integer> a = new AVL<>(c);
		
		assertNull(a.root);
	}
	
	@Test
	public void addTest2() {
		setupStage2();
		
		avl.add(10);
		
		assertEquals(avl.root.getValue().get(0), (Integer) 10);
	}
	
	@Test
	public void addTest3() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		
		assertEquals(avl.root.getValue().get(0), (Integer) 10);		
		assertEquals(avl.root.getLeft().getValue().get(0),(Integer) 8);
		assertEquals(avl.root.getRight().getValue().get(0),(Integer) 12);
	}
	
	@Test
	public void rebalance1() {
		
		
		
	}
	
	@Test
	public void rebalance2() {
		
	}
	
	@Test
	public void rebalance3() {
		
	}
	
	
	
}
