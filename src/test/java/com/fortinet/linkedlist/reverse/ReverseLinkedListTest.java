package com.fortinet.linkedlist.reverse;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ReverseLinkedList.
 */
public class ReverseLinkedListTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseLinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReverseLinkedListTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	// 1.  Null case
    public void testApp1()
    {
    	System.out.println("-------Case 1-------");
    	System.out.println("Null test case");
    	System.out.println("Input : null");
    	System.out.println("Expected Output : null");
    	ReverseLinkedList list = new ReverseLinkedList();
    	String s = list.reverse(list.head);
        assertEquals("null", s);
    }
    
    // 2. 1->null
    public void testApp2() {
    	
    	System.out.println("-------Case 2-------");
    	System.out.println("Single Entry case");
    	System.out.println("Input : 1->null");
    	System.out.println("Expected Output : 1->null");
    	ReverseLinkedList list = new ReverseLinkedList();
        list.add(1);
        String s = list.reverse(list.head);
        assertEquals("1->null", s);
    }
    
    // 3. List with a cycle
    public void testApp3() {
    	
    	System.out.println("-------Case 3-------");
    	System.out.println("Loop case");
    	System.out.println("Input : 1->2->3->4->2");
    	System.out.println("Expected Output : Can't reverse because of loop");
    	ReverseLinkedList list = new ReverseLinkedList();
    	list.add(1);
    	Node n = new Node(2);
    	list.head.next = n;
    	list.head.next.next = new Node(3);
    	list.head.next.next.next = new Node(4);
    	list.head.next.next.next.next = n;
    	
    	String s = list.reverse(list.head);
    	assertEquals("Can't reverse because of loop", s);
    }
    
    // 4. 1->2->3->4->5->null
    public void testApp4() {
    	
    	System.out.println("-------Case 4-------");
    	System.out.println("Normal test case");
    	System.out.println("Input : 1->2->3->4->5->null");
    	System.out.println("Expected Output : 5->4->3->2->1->null");
    	ReverseLinkedList list = new ReverseLinkedList();
    	list.add(1);
    	list.head.next = new Node(2);
    	list.head.next.next = new Node(3);
    	list.head.next.next.next = new Node(4);
    	list.head.next.next.next.next = new Node(5);
    	
    	String s = list.reverse(list.head);
    	assertEquals("5->4->3->2->1->null", s);
    }
}
