package collections;

import java.util.List;

public interface BSTInterface<T> {
	
	
	
	Node<T> add(T item);
	
	Node<T> add(T item, Node<T> current, Node<T> parent);
	
	Node<T> search(T item);
	
	Node<T> search(T item, Node<T> parent);
	
	List<T> getGreaterThan(Node<T> node);
	
	List<T> getGreaterThan(Node<T> node, List<T> list);
	
	List<T> getLessThan(Node<T> node);
	
	List<T> inOrderRight(Node<T> node);
	
	List<T> inOrderRight(Node<T> node, List<T> list);
	
	List<T> inOrderLeft(Node<T> node);
	
	List<T> inOrderLeft(Node<T> node, List<T> list);
	
	int getHeight();
	int getHeight(Node<T> current);
}
