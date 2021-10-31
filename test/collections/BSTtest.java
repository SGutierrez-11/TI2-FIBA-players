package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class BSTtest<T> {
	 private Node<Integer> node;
	 private BST<Integer> tree;
	 private Comparator<Integer> c;

	 public void setupStage1() { 
	 }
	 
	 public void setupStage2() {
		 tree = new BST<>(c);
	 }
	 
	 @Test
	 public void insertTest1() {
		 setupStage1();
		 
		 BST<Integer> bst = new BST<Integer>(c);

		 assertNull(bst.root);
	 }
	 
	 @Test
	 public void insertTest2() {
		 setupStage2();
		 
		 tree.add(3);
		 
		 assertEquals(tree.root.getValue(), (Integer) 3);
	 }
	 
	 @Test
	 public void insertTest3() {
		 setupStage2();
		 
		 tree.add(5);
		 tree.add(3);
		 
		 assertEquals(tree.root.getValue(), (Integer) 5);
		 assertEquals(tree.root.getLeft().getValue(), (Integer) 3);
	 }
	 
	 @Test
	 public void insertTest4() {
		 setupStage2();
		 
		 tree.add(10);
		 tree.add(9);
		 tree.add(14);
		 
		 assertEquals(tree.root.getValue(), (Integer) 10);
		 assertEquals(tree.root.getLeft().getValue(), (Integer) 9);
		 assertEquals(tree.root.getRight().getValue(), (Integer) 14);
	 }
	 
	 @Test
	 public void searchTest1() {
		 setupStage1();
		 
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
	 
	 
}
