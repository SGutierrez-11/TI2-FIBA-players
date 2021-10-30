package collections;

import java.util.Comparator;

public class AVL<T> extends BST<T> {
	public AVL(Comparator<T> c) {
		super(c);
	}
	@Override
	public Node<T> add(T item) {
		Node<T> added = super.add(item);
		if (added != null && added.getParent()!=null)
			rebalance(added);
		return added;
	}
	/*@Override
	public boolean delete(T item) {
		boolean value = super.delete(item);
		return value;
	}*/
	private void rebalance(Node<T> current) {
		boolean balanced = false;
		while(!current.equals(root) && !balanced){
			current = current.getParent();
			int bf = balanceFactor(current);
			if (bf == 2) {
				if (balanceFactor(current.getRight()) == -1)
					rightRotate(current.getRight());
				leftRotate(current);
				balanced = true;
			}else if (bf < -1) {
				if (balanceFactor(current.getLeft()) == 1)
					leftRotate(current.getLeft());
				rightRotate(current);
				balanced = true;
			}
		}
	}
	private void leftRotate(Node<T> p) {
		Node<T> q = p.getRight();
		q.setParent(p.getParent());
		p.setRight(q.getLeft());
		p.setParent(q);
		q.setLeft(p);
	}
	private void rightRotate(Node<T> p) {
		Node<T> q = p.getLeft();
		q.setParent(p.getParent());
		p.setLeft(q.getRight());
		p.setParent(q);
		q.setRight(p);
	}
	private int balanceFactor(Node<T> current){
		return getHeight(current.getRight())-getHeight(current.getLeft());
	}
	

	
	
	
}