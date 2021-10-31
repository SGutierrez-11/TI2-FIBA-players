package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;

public class AVLtest {
	
	private AVL<Integer> avl;
	public Comparator<Integer> c;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		avl = new AVL<>(c);
	}
	
	public void addTest1() {
		setupStage1();
		
		AVL<Integer> a = new AVL<>(c);
		
		assertNull(a.root);
	}
	
	public void addTest2() {
		setupStage2();
		
		avl.add(10);
		
		assertEquals(avl.root,10);
	}
	
	public void addTest3() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		
		assertEquals(avl.root,10);
		assertEquals(avl.root.getLeft(),8);
		assertEquals(avl.root.getRight(), 12);
	}
	
	public void rebalance1() {
		
		
		
	}
	
	public void rebalance2() {
		
	}
	
	public void rebalance3() {
		
	}
	
	
	
}
