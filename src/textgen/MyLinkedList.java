package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if(element == null)
			throw new NullPointerException();
		
		if(tail.prev != null)
		{
			LLNode<E> newNode = new LLNode<E>(element,tail.prev,tail);
			tail.prev.next = newNode;
			tail.prev = newNode;
			size ++;
			return true;
		}
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = this.head;
		for(int i=0; i <= index; i++)
		{
			if(currentNode.next == this.tail)
				throw new IndexOutOfBoundsException();
			else
				currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		if(element == null)
			throw new NullPointerException();
		
		LLNode<E> currentNode = this.head;
		for(int i=0; i < index; i ++)
		{
			if(currentNode.next == tail)
				throw new IndexOutOfBoundsException();
			else
				currentNode = currentNode.next;
		}
		
		//currentNode == this.getNode(index -1)
		LLNode<E> newNode = new LLNode<E> (element,currentNode,currentNode.next);
		currentNode.next.prev = newNode;
		currentNode.next = newNode;
		size ++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = this.head;
		for(int i=0; i < index; i ++)
		{
			if(currentNode.next == tail)
				throw new IndexOutOfBoundsException();
			else
				currentNode = currentNode.next;
		}
		//currentNode == this.getNode(index -1)
		LLNode<E> deletedNode = currentNode.next;
		deletedNode.next.prev = currentNode;
		currentNode.next = deletedNode.next;
		
		size --;
		return deletedNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if(element == null)
			throw new NullPointerException();
		
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = this.head;
		for(int i=0; i <= index; i ++)
		{
			if(currentNode.next == tail)
				throw new IndexOutOfBoundsException();
			else
				currentNode = currentNode.next;
		}
		//currentNode == this.getNode(index)
		currentNode.data = element;
		
		return currentNode.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode)
	{
		this.data = e;
		this.prev = prevNode;
		this.next = nextNode;
	}

}
