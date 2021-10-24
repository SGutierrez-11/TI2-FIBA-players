package model;


public class BST<T extends Comparable<T>> {
	
	Node<T> root;
	
	String toPrint;
	

	public BST() {
		
		toPrint = "";
	}
	
	
	public void insert(T value) {
		
		if(root==null) {
			root = new Node<>(value);
		}else {
			insert(root, value);
		}	
	}
	
	
	private void insert(Node<T> temp, T value) {
			
		Node<T> n= new Node<>(value);
			
		if(n.getValue().compareTo(temp.getValue())>0) {
			if(temp.getRigth()==null) {
					temp.setRigth(n);
				} else {
					insert(temp.getRigth(), value);
				}
		}else {
			if(temp.getLeft()==null) {
					temp.setLeft(n);
			}else {
				insert(temp.getLeft(), value);
			}
		}	
	}
	
	public Node<T>search(T x) {
		
		if(root==null) {
			return null;
		}else if(x.compareTo(root.getValue())==0) {
			
		return root;
		}else {
			if(x.compareTo(root.getValue())>0) {
				return search(x,root.getRigth());
				
			}else {
				return search(x, root.getLeft());
			}
		}
		
		
	}
	private Node<T> search(T x, Node<T> toSearch){
		
		if(toSearch==null) {
			return null;
		}else {
			
			if(x.compareTo(toSearch.getValue())==0) {
				
				return toSearch;
				}else {
					if(x.compareTo(toSearch.getValue())>0) {
						return search(x,toSearch.getRigth());
						
					}else {
						return search(x, toSearch.getLeft());
					}
				}
		}
		
	}
	public void inOrder() {
		
		toPrint = "";
		inOrder(root);
		
	}
	private void inOrder(Node<T> node) {
		
		if(node == null) {
			return;
		}else {
			
			inOrder(node.getLeft());
			toPrint+= "" +node.getValue()+", ";
			inOrder(node.getRigth());
		}
		
	}
	public void preOrder() {
		
		toPrint = "";
		preOrder(root);
		
	}
	private void preOrder(Node<T> node) {
		
		if(node==null) {
			return;
		}else {
			toPrint+= "" + node.getValue()+", ";
			preOrder(node.getLeft());
			preOrder(node.getRigth());
		}
		
	}
	public void postOrder() {
		
		toPrint = "";
		postOrder(root);	
	}
	private void postOrder(Node<T> node) {
		
		if(node==null) {
			return;
		}else {
			
			postOrder(node.getLeft());
			
			postOrder(node.getRigth());
			
			toPrint+= "" + node.getValue()+", ";
		}
		
	}
	public Node<T> toDelete(T value, Node<T> node){
		
		if(node == null) {
			return null;
		}
		if((value.compareTo(node.getValue())>0)){ 
            node.setRigth(toDelete(value, node.getRigth()));
        }else if((value.compareTo(node.getValue())<0)){
            node.setLeft(toDelete(value, node.getLeft()));
        }else{
            if(node.getLeft() == null && node.getRigth() == null){
                node = null;
            }else if(node.getRigth() != null){
                node.setValue(successor(node));
                node.setRigth(toDelete(node.getValue(), node.getRigth()));
            }else{
                root.setValue(predecessor(root));
                root.setLeft(toDelete(node.getValue(), node.getLeft()));
            }
        }
        return root;
		
	}
	public Node<T> delete(Node<T> node){
		
		Node<T> y;
		Node<T> x;
		
		if(node.getLeft()==null || node.getRigth()==null) {
			
			y = node;
			
		}else {
			
			y = search(successor(node));
			
		}
		if(y.getLeft()!=null) {
			x = y.getLeft();
		}else {
			x = y.getRigth();
		}
		if(x!=null) {
			
			x.setParent(y.getParent());
		}
		if(y.getParent()==null) {
			root = x;
		}else if(y==y.getParent().getLeft()){
			y.getParent().setLeft(x); ;
		}else {
			y.getParent().setRigth(x);
		}
		if(y!=node) {
			node.setValue(y.getValue());
		}
		return y;
	}
	private T successor(Node<T> node){
        node = node.getRigth();
        while(node.getLeft() != null){
            node = root.getLeft();
        }
        return root.getValue();
    }
	private T predecessor(Node<T> node){
        node = root.getLeft();
        while(node.getRigth() != null){
            node = root.getRigth();
        }
        return root.getValue();
    }
	
	public String getToPrint() {
		return toPrint;
	}
	public Node<T> getRoot() {
		return root;
	}
	
}