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
		last = last.getPrevious();
		last.setNext(null);
		elementCount--;
	}
	
	public void removeFirst() {
		first = first.getNext();
		first.setPrevious(null);
		elementCount--;	
	}
	
	public void remove(int position) {
		//check if not empty or bad position
		
		if (position == 0) {
			removeFirst();
		}
		else if (position == elementCount-1) {
			removeLast();
		}
		else {
			MyNode tempNode = first;
			for(int i = 0; i < position; i++) {
				tempNode = tempNode.getNext();
			}
			
			MyNode prevNode = tempNode.getPrevious();
			MyNode nextNode = tempNode.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrevious(prevNode);
			elementCount--;
			
		}
		
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
				
				elementCount++;
				
				/*MyNode<T> newNode = new MyNode<T>(newElement);
				newNode.setNext(tempNode.getNext());
				newNode.setPrevious(tempNode);
				tempNode.setNext(newNode);
				elementCount++;*/
			}
		}
	}
	
	public void print() {
		//chek if not empty first
		
		MyNode tempNode = first;
		while(tempNode != null) {
			System.out.print(tempNode + " ");
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}


	
}
