package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class BST<T> implements BSTInterface<T>{
	Node<T> root;
	private Comparator<T> comparator;
	public BST(Comparator<T> c) {
		comparator = c;
	}
	public Node<T> add(T item) {
		if (root == null) {
			root = new Node<T>(item);
			return root;
		}else {
			return add(item, root, null);
		}
	}
	private Node<T> add(T item, Node<T> current, Node<T> parent) {
		if (current == null) {
			current = new Node<T>(item);
			current.setParent(parent);
			if (comparator.compare(item, parent.getValue().get(0)) < 0)
				parent.setLeft(current);
			else
				parent.setRight(current);
			return current;
		}else if (comparator.compare(item, current.getValue().get(0)) < 0)
			return add(item, current.getLeft(), current);
		else if (comparator.compare(item, current.getValue().get(0)) > 0)
			return add(item, current.getRight(), current);
		else {
			current.add(item);
			return current;
		}
	}
	/*public boolean delete(T item) {
		if (root == null)
			return false;
		else
			return delete(item, root, null);
	}
	private boolean delete(T item, Node<T> current, Node<T> parent) {
		if (current == null)
			return false;
		else if (item.compareTo(current.getValue().get(0)) < 0)
			return delete(item, current.getRight(), current);
		else if (item.compareTo(current.getValue().get(0)) > 0)
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
	}*/
	public Node<T> search(T t) {
		if (root == null)
			return null;
		else
			return search(t, root);
	}
	private Node<T> search(T t, Node<T> parent) {
		if (parent == null)
			return null;
		else if (comparator.compare(t, parent.getValue().get(0)) == 0)
			return parent;
		else if (comparator.compare(t, parent.getValue().get(0)) < 0)
			return search(t, parent.getLeft());
		else
			return search(t, parent.getRight());
	}
	public List<T> getGreaterThan(T t){
		List<T> list = inOrderRight(root);
		int i = Collections.binarySearch(list, t, comparator);
		if (i >= 0)
			return list.subList(i, list.size());
		else {
			if (comparator.compare(t, list.get(list.size()-1)) > 0)
				return new ArrayList<>();
			else if (comparator.compare(t, list.get(0)) < 0)
				return list;
			else {
				return list.subList(~i, list.size());
			}
		}
	}
	public List<T> getLessThan(T t){
		List<T> list = inOrderRight(root);
		int i = Collections.binarySearch(list, t, comparator);
		if (i >= 0)
			return list.subList(0, i);
		else {
			if (comparator.compare(t, list.get(list.size()-1)) > 0)
				return list;
			else if (comparator.compare(t, list.get(0)) < 0)
				return new ArrayList<>();
			else {
				return list.subList(0, ~i);
			}
		}
	}
	public List<T> inOrderRight(Node<T> node){
		List<T> list = new ArrayList<>();
		return inOrderRight(node, list);
	}
	private List<T> inOrderRight(Node<T> node, List<T> list){
		if (node == null)
			return null;
		else {
			inOrderRight(node.getLeft(), list);
			list.addAll(node.getValue());
			inOrderRight(node.getRight(), list);
			return list;
		}
	}
	public List<T> inOrderLeft(Node<T> node){
		List<T> list = new ArrayList<>();
		return inOrderLeft(node, list);
	}
	private List<T> inOrderLeft(Node<T> node, List<T> list){
		if (node == null)
			return null;
		else {
			inOrderLeft(node.getRight(), list);
			list.addAll(node.getValue());
			inOrderLeft(node.getLeft(), list);
			return list;
		}
	}
	public int getHeight() {
		return getHeight(root);
	}
	
	protected int getHeight(Node<T> current) {
		if (current == null)
			return 0;
		else
			return Math.max(getHeight(current.getLeft()), getHeight(current.getRight()))+1;
	}
}