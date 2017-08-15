package com.fortinet.linkedlist.reverse;
import java.util.Scanner;

public class ReverseLinkedList {

	public static Node head;
	
	// Constructor for the class
	public ReverseLinkedList() {
		head = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating the object of the class
		ReverseLinkedList list = new ReverseLinkedList(); 
		
		System.out.println("Enter the integers to be added separated with spaces and 'exit' to end giving values");
		
		//Scanner to read the user input values
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String s = sc.next();
			// Exit condition once adding to list is completed
			if(s.equals("exit")) {
				break;
			}
			else {
				// Calling the method to add nodes to the Linked List at the end
				list.add(Integer.parseInt(s));
			}
		}
		
		// Printing the nodes before reversing the linked list
		System.out.println("Linked List before reversing");
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.value + "->");
			curr = curr.next;
		}
		System.out.println("null");
		
		// Calling the method to reverse the linked list
		list.reverse(head);

		// Printing the nodes after reversing the linked list
		System.out.println("Linked List after reversing");
		curr = head;
		while(curr != null) {
			System.out.print(curr.value + "->");
			curr = curr.next;
		}
		System.out.println("null");
		
	}
	
	//Method to add nodes to the linked list at the end
	public void add(int x) {
		Node n = new Node(x);
		if(head == null) {
			head = n;
		}
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = n;
		}
	}
	
	// Method to reverse the Linked List
	public String reverse(Node node) {
		
		String result = "";
		Node slow = node;
		Node fast = node;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				result = "Can't reverse because of loop";
				return result;
			}
		}
		Node curr = node;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
		curr = head;
		while(curr != null) {
			result = result + curr.value + "->";
			curr = curr.next;
		}
		result = result + null;
		
		return result;
	}

}
