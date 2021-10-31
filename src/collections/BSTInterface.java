package collections;

import java.util.List;

public interface BSTInterface<T> {
	
	
	
	Node<T> add(T item);
	
	//Node<T> add(T item, Node<T> current, Node<T> parent);
	
	Node<T> search(T item);
	
	//Node<T> search(T item, Node<T> parent);
	
	List<T> getGreaterThan(T item);
	
	//List<T> getGreaterThan(Node<T> node, List<T> list);
	
	List<T> getLessThan(T item);
	
	List<T> inOrderRight(Node<T> node);
	
	//List<T> inOrderRight(Node<T> node, List<T> list);
	
	List<T> inOrderLeft(Node<T> node);
	
	//List<T> inOrderLeft(Node<T> node, List<T> list);
	
	int getHeight();
	//int getHeight(Node<T> current);
}
