package collections;
import java.util.ArrayList;
public class Node<T>{
	private ArrayList<T> nodes;
	private Node<T> left; 
	private Node<T> right;
	private Node<T> parent;
	public Node(T x) {
		nodes = new ArrayList<>();
		nodes.add(x);
	}
	public T getValue() {
		if (nodes.size() == 1)
			return nodes.get(0);
		else
			return null;
	}
	public void setValue(T v) {
		if (nodes.size() == 1)
			nodes.set(0, v);
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