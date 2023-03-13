package service;

import datastr.MyLinkedList;

public class mainService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		MyLinkedList<String> stringList = new MyLinkedList<>();
		
		stringList.add("Karina");
		stringList.add("Jānis");
		stringList.print();
		stringList.add("Jana", 0);
		stringList.print();
		stringList.add("Līga", 2);
		stringList.print();
		stringList.remove(0);
		stringList.print();
		stringList.remove(1);
		stringList.print();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
