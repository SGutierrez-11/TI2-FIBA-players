package collections;

import java.util.ArrayList;

public interface NodeInterface<T> {

	ArrayList<T> getValue();
	
	void add(T t);
	
	void setValue(T v);
	
	Node<T> getLeft();
	
	void setLeft(Node<T> l);
	
	Node<T> getRight();
	
	void setRight(Node<T> r);
	
	Node<T> getParent();
	
	void setParent(Node<T> p);
}
