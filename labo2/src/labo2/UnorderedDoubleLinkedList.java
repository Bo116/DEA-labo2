package labo2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	@Override
	public void addToFront(T elem) {
	    Node<T> nodoBerria = new Node<T>(elem);

	    if (isEmpty()) {
	        last = nodoBerria;
	    } else {
	        Node<T> current = last;
	        while (current.prev != null)
	            current = current.prev;
	        nodoBerria.next = current;
	        current.prev = nodoBerria;
	    }
	    count++;
	}


	@Override
	public void addToRear(T elem) {
	    super.addToRear(elem);
	}

	
	@Override
	public void addAfter(T elem, T target) {
	    if (isEmpty()) return;

	    Node<T> current = last;
	    while (current.prev != null)
	        current = current.prev;
	    while (current != null && !current.data.equals(target)) {
	        current = current.next;
	    }

	    if (current == null) {
	        return;
	    }

	    Node<T> nodoBerria = new Node<T>(elem);

	    nodoBerria.prev = current;
	    nodoBerria.next = current.next;
	    if (current.next != null)
	        current.next.prev = nodoBerria;
	    current.next = nodoBerria;

	    if (current == last)
	        last = nodoBerria;

	    count++;
	}


}
