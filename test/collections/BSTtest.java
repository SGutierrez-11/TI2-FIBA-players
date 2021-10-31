package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BSTtest<T> {
	 private Node<Integer> node;
	 private BST<Integer> tree;

	 public void setupStage1() { 
	 }
	 
	 public void setupStage2() {
		 
		 Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		 tree = new BST<>(c);
	 }
	 
	 @Test
	 public void insertTest1() {
		 setupStage1();
		 
		 Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		 BST<Integer> bst = new BST<Integer>(c);

		 assertNull(bst.root);
	 }
	 
	 @Test
	 public void insertTest2() {
		 setupStage2();
		 
		 tree.add(3);
		 
		 assertEquals(tree.root.getValue().get(0), (Integer) 3);
	 }
	 
	 @Test
	 public void insertTest3() {
		 setupStage2();
		 
		 tree.add(5);
		 tree.add(3);
		 
		 assertEquals(tree.root.getValue().get(0), (Integer) 5);
		 assertEquals(tree.root.getLeft().getValue().get(0), (Integer) 3);
	 }
	 
	 @Test
	 public void insertTest4() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 
		 assertEquals(tree.root.getValue().get(0), (Integer) 10);
		 assertEquals(tree.root.getLeft().getValue().get(0), (Integer) 9);
		 assertEquals(tree.root.getRight().getValue().get(0), (Integer) 14);
	 }
	 
	 @Test
	 public void searchTest1() {
		 setupStage1();
		 
		 Comparator<Integer> c = Comparator.comparing((Integer i) -> i);
		 BST<Integer> bst = new BST<>(c);
		 
		 assertNull(bst.search(3));
	 }
	 
	 @Test
	 public void searchTest2() {
		 setupStage2();
		 
		 tree.add(3);
		 
		 assertNotNull(tree.search(3));
	 }
	 
	 @Test
	 public void searchTest3() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 
		 assertNotNull(tree.search(10));
		 assertEquals(tree.search(9), tree.root.getLeft());
		 assertEquals(tree.search(14), tree.root.getRight());
	 }
	 
	 @Test
	 public void getGreaterThanTest1() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 tree.add(16);
		 tree.add(20);
		 tree.add(6);
		 
		 List<Integer> list = new ArrayList<>();
		 list.add(10);
		 list.add(14);
		 list.add(16);
		 list.add(20);
		 assertEquals(tree.getGreaterThan(10).get(0), list.get(0));
		 assertEquals(tree.getGreaterThan(10).get(1), list.get(1));
		 assertEquals(tree.getGreaterThan(10).get(2), list.get(2));
		 assertEquals(tree.getGreaterThan(10).get(3), list.get(3));
	 }
	 
	 @Test
	 public void getLessThanTest1() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 tree.add(16);
		 tree.add(2);
		 tree.add(6);
		 
		 List<Integer> list = new ArrayList<>();
		 list.add(10);
		 list.add(9);
		 list.add(2);
		 list.add(6);
		 
		 assertEquals(tree.getLessThan(10).get(0), list.get(2));
		 assertEquals(tree.getLessThan(10).get(1), list.get(3));
		 assertEquals(tree.getLessThan(10).get(2), list.get(1));
	 }
	 
	 
	 @Test
	 public void inOrderRightTest1() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 tree.add(16);
		 tree.add(2);
		 tree.add(6);
		 
		 List<Integer> list = new ArrayList<>();
		 list.add(10);
		 list.add(9);
		 list.add(2);
		 list.add(6);
		 
		 assertEquals(tree.inOrderRight(tree.root).get(0), list.get(2));
		 assertEquals(tree.inOrderRight(tree.root).get(1), list.get(3));
		 
	 }
	 
	 @Test
	 public void inOrderLeftTest1() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 tree.add(16);
		 tree.add(2);
		 tree.add(6);
		 
		 List<Integer> list = new ArrayList<>();
		 list.add(10);
		 list.add(14);
		 list.add(16);
		 list.add(6);
		 
		 assertEquals(tree.inOrderLeft(tree.root).get(0), list.get(2));
		 assertEquals(tree.inOrderLeft(tree.root).get(1), list.get(1));
	 }
	 
	 @Test
	 public void getHeightTest1() {
		 setupStage2();
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 tree.add(16);
		 tree.add(2);
		 tree.add(6);
		 
		 assertEquals(tree.getHeight(), 4);
		 
	 }
	 
}
