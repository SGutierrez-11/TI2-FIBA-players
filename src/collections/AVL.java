package collections;
public class AVL<T extends Comparable<T>> extends BST<T> {
	@Override
	public boolean add(T item) {
		boolean value = super.add(item);
		if (value)
			rebalance(item, root);
		return value;
	}
	@Override
	public boolean delete(T item) {
		boolean value = super.delete(item);
		return value;
	}
	private void rebalance(T item, Node<T> current) {
		// TODO Auto-generated method stub
		
	}
	private int balanceFactor(Node<T> current) {
		return getHeight(current.getRight())-getHeight(current.getLeft());
	}
}