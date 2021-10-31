package collections;
import java.util.ArrayList;
public class Node<T>{
	private ArrayList<T> values;
	private Node<T> left; 
	private Node<T> right;
	private Node<T> parent;
	public Node(T x) {
		this.left = null;
		this.right = null;
		values = new ArrayList<>();
		values.add(x);
	}
	public ArrayList<T> getValue() {
		return values;
	}
	public void add(T t) {
		values.add(t);
	}
	public void setValue(T v) {
		if (values.size() == 1)
			values.set(0, v);
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