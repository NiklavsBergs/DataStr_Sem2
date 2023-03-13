package datastr;

public class MyLinkedList<T> {
	private MyNode first = null;
	private MyNode last = null;
	private int elementCount = 0;
	
	public void add (T newElement) {
		
		//is empty
		if(elementCount == 0) {
			MyNode<T> newNode = new MyNode<T>(newElement);
			first = newNode;
			last = newNode;
			elementCount++;
		}
		else {
			MyNode<T> newNode = new MyNode<T>(newElement);
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;
			elementCount++;
		}
	}
	
	public void deleteLast() {
		last.getPrevious().setNext(null);
		elementCount--;
	}
	
	public void deleteFirst() {
		first.getNext().setPrevious(null);
		elementCount--;	
	}
	
}
