package collections;
public class Node<T>{
	private T value;
	private Node<T> left; 
	private Node<T> right;
	private Node<T> parent;
	public Node(T x) {
		value = x;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T v) {
		value = v;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> l) {
		left = l;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> r) {
		right = r;
	}
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> p) {
		parent = p;
	}
}