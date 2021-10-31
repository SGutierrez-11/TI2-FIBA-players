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
	public void rebalanceTest1() {
		
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		avl.add(4);
		avl.add(15);
		avl.add(6);
		
		avl.rebalance(avl.root);
		
		assertEquals(avl.balanceFactor(avl.root), 0);
		
	}
	
	@Test
	public void rebalanceTest2() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		avl.add(4);
		avl.add(15);
		avl.add(6);
		avl.add(11);
		avl.add(18);
		avl.add(20);
		avl.add(9);
		avl.add(7);
		avl.add(1);
		
		avl.rebalance(avl.root.getLeft());
		
		assertEquals(avl.balanceFactor(avl.root), 0);
		assertEquals(avl.root.getLeft().getRight().getValue().get(0),(Integer) 8);
	}
	
	@Test
	public void leftRotateTest1() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		avl.add(4);
		avl.add(15);
		avl.add(6);
		
		assertEquals(avl.root.getLeft().getLeft().getValue().get(0), (Integer) 4);
		
		avl.leftRotate(avl.root.getLeft());
		
		assertEquals(avl.root.getLeft().getLeft().getValue().get(0), (Integer) 6);
		
	
	}
	
	@Test
	public void RightRotateTest1() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		avl.add(4);
		avl.add(15);
		avl.add(6);
		
		assertEquals(avl.root.getLeft().getLeft().getValue().get(0), (Integer) 4);
		
		avl.rightRotate(avl.root.getLeft());
		
		assertEquals(avl.root.getLeft().getRight().getValue().get(0), (Integer) 6);
		
	
	}
	
	
	@Test
	public void balanceFactorTest() {
		setupStage2();
		
		avl.add(10);
		avl.add(8);
		avl.add(12);
		avl.add(4);
		avl.add(15);
		avl.add(6);
		avl.add(17);
		avl.add(1);
		avl.add(3);
		avl.add(14);
		avl.add(9);
		
		assertEquals(avl.balanceFactor(avl.root.getLeft().getLeft()), 0);
	}
	
}
