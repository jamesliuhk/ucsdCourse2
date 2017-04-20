/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		try
		{
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			shortList.remove(5);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		assertEquals("AddEnd: check add is corrent","C",shortList.get(2));
		assertEquals("AddEnd: check prev is corrent","B",shortList.get(1));
		assertEquals("AddEnd: check size is correct ", 3, shortList.size());
		
		
		try
		{
			shortList.add(null);
			fail("Check illegal aguement");
		}
		catch(IllegalArgumentException e)
		{
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		
		assertEquals("Size: check size is corrent",2,shortList.size());
		shortList.add("X");
		assertEquals("Size: check size is corrent",3,shortList.size());
		shortList.remove(1);
		assertEquals("Size: check size is corrent",2,shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		try
		{
			shortList.add(-1,"out");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			shortList.add(5,"out");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			shortList.add(1,null);
			fail("Check illegal aguement");
		}
		catch(IllegalArgumentException e)
		{
			
		}
		
		shortList.add(1,"test");
		assertEquals("AddAtIndex: check add is corrent","test",shortList.get(1));
		assertEquals("AddAtIndex: check prev is corrent","A",shortList.get(0));
		assertEquals("AddAtIndex: check next is corrent","B",shortList.get(2));
		assertEquals("AddAtIndex: check size is correct ", 3, shortList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		String a = shortList.set(1,"X");
		assertEquals("Set: check a is correct ", "X", a);
		assertEquals("Set: check set is correct ", "X", shortList.get(1));
		assertEquals("Set: check size is correct ", 2, shortList.size());
		
		
		try
		{
			shortList.set(-1,"out");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			shortList.set(5,"out");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			shortList.set(1,null);
			fail("Check out of bounds");
		}
		catch(IllegalArgumentException e)
		{
			
		}
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
