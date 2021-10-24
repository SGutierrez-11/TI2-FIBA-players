package collections;
public class Node<T extends Comparable<T>> {
	
	private T value;
	private Node<T> left; 
	private Node<T> rigth;
	private Node<T> parent;
	
	
	public Node(T x) {
		value = x;
		this.left = null;
		this.rigth= null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRigth() {
		return rigth;
	}

	public void setRigth(Node<T> rigth) {
		this.rigth = rigth;
	}
	
	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public int compareTo(T newValue) {
		return value.compareTo(newValue); 	
    }

	
	
}
