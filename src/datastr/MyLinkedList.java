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
	
	public void removeLast() {
		last.getPrevious().setNext(null);
		elementCount--;
	}
	
	public void removeFirst() {
		first.getNext().setPrevious(null);
		elementCount--;	
	}
	
	public void add(T newElement, int position) throws Exception{
		
		if (position < 0 || position > elementCount) {
			throw (new Exception ("Wrong position"));
		}
		else {
			if (position == 0) {
				MyNode<T> newNode = new MyNode<T>(newElement);
				first.setPrevious(newNode);
				newNode.setNext(first);
				first = newNode;
				elementCount++;
			}
			else if (position == elementCount) {
				add(newElement);
			}
			else {
				MyNode tempNode = first;
				for(int i = 0; i < position-1; i++) {
					tempNode = tempNode.getNext();
				}
				
				MyNode tempNode2 = tempNode.getNext();
				MyNode<T> newNode = new MyNode<T>(newElement);
				
				tempNode.setNext(newNode);
				newNode.setPrevious(tempNode);
				
				tempNode2.setPrevious(newNode);
				newNode.setNext(tempNode2);
				
				/*MyNode<T> newNode = new MyNode<T>(newElement);
				newNode.setNext(tempNode.getNext());
				newNode.setPrevious(tempNode);
				tempNode.setNext(newNode);
				elementCount++;*/
			}
		}
	}
	
}
