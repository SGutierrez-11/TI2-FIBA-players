package collections;
public class BST<T extends Comparable<T>> {
	Node<T> root;
	public boolean add(T item) {
		if (root == null) {
			root = new Node<T>(item);
			return true;
		}else {
			return add(item, root, null);
		}
	}
	private boolean add(T item, Node<T> current, Node<T> parent) {
		if (current == null) {
			current = new Node<T>(item);
			current.setParent(parent);
			if (item.compareTo(parent.getValue()) < 0)
				parent.setLeft(current);
			else
				parent.setRight(current);
			return true;
		}else if (item.compareTo(current.getValue()) < 0)
			return add(item, current.getLeft(), current);
		else
			return add(item, current.getRight(), current);
	}
	public boolean delete(T item) {
		if (root == null)
			return false;
		else
			return delete(item, root, null);
	}
	private boolean delete(T item, Node<T> current, Node<T> parent) {
		if (current == null)
			return false;
		else if (item.compareTo(current.getValue()) < 0)
			return delete(item, current.getRight(), current);
		else if (item.compareTo(current.getValue()) > 0)
			return delete(item, current.getLeft(), current);
		else {
			if (current.getLeft() == null && current.getRight() == null) {
				current = null;
				return true;
			}else if(current.getLeft() != null && current.getRight() != null) {
				Node<T> successor = current.getLeft();
				while (successor.getRight()!=null)
					successor = successor.getRight();
				successor.setRight(current.getRight());
				current = successor;
				successor.setParent(parent);
				return true;
			}else {
				if (current.getLeft() == null) {
					current = current.getRight();
					current.setParent(parent);
				}else {
					current = current.getLeft();
					current.setParent(parent);
				}
				return true;
			}
		}
	}
	public T search(T item) {
		if (root == null)
			return null;
		else
			return search(item, root);
	}
	private T search(T item, Node<T> parent) {
		if (parent == null)
			return null;
		else if (item.compareTo(parent.getValue())==0) {
			
		}else if (item.compareTo(parent.getValue()) < 0)
			return search(item, parent.getLeft());
		else
			return search(item, parent.getRight());
	}
	public int getHeight() {
		return getHeight(root);
	}
	protected int getHeight(Node<T> current) {
		if (current == null)
			return 0;
		else
			return Math.max(getHeight(current.getLeft()), getHeight(current.getRight()));
	}
}