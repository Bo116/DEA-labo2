package labo2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import labo2.Node;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> last;  // azkenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		last = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public void setLast(Node<T> elem) {
		this.last= elem;
	}
	public void addToRear(T elem) {
		Node<T> nodoBerria = new Node<T>(elem);
		
		if (isEmpty()) {
			last=nodoBerria;
		}
		else {
			last.next=nodoBerria;
			nodoBerria.prev=last;
			last=nodoBerria;
		}
		}
	
	public T removeFirst() {
		// listako lehen elementua kendu da
		// Aurrebaldintza: 
			// KODEA OSATU ETA KOSTUA KALKULATU
		if (isEmpty()) return null;
		Node<T> current = last;
		while (current.prev != null) {
			current = current.prev;
		}
		T kendutakoDatua = current.data;
		if(current.next !=null) {
			current.next.prev = null;
		} else {
			last = null;
		}
		if(current == last) {
			last = null;
		}
		count--;
		return kendutakoDatua;
	}

	public T removeLast() {
		// listako azken elementua kendu da
		// Aurrebaldintza: 
			// KODEA OSATU ETA KOSTUA KALKULATU
		if(isEmpty()) return null;
		Node<T> current = last;
		T kendutakoDatua = last.data;
		if(current.prev!=null) {
			current.prev.next =null;
			last=current.prev.next;
		}
		else {
			last=null;
		}
		count--;
		return kendutakoDatua;
		
		
	
    }


	public T remove(T elem) {
	// Aurrebaldintza: 
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		// KODEA OSATU ETA KOSTUA KALKULATU
		if(isEmpty()) return null;
		T kendutakoDatua = null;
		Node<T> current = last;
		while(current.prev != null) {
			current= current.prev;
		}
		while(current.next != null && kendutakoDatua==null) {
			if (current.data == elem) {
				kendutakoDatua= current.data;
				if(current.prev != null) {
					if(current.next != null) {
					current.next.prev=current.prev;
					current.prev.next=current.next;}
					else {
						current.prev.next=null;
					}
				
				}
				else {
					current.next.prev=null;
					
				}
			}
			current=current.next;
		}
		return kendutakoDatua;
        };
		
	public void removeAll(T elem) {
		
	// Aurrebaldintza: 
	// Balio zehatz baten agerpen guztiak ezabatzen ditu
	
		// KODEA OSATU ETA KOSTUA KALKULATU
		if(!isEmpty()) {
		Node<T> current = last;
		while(current.prev != null) {
			if (current.data == elem) {
				if(current.prev != null) {
					if(current.next != null) {
					current.next.prev=current.prev;
					current.prev.next=current.next;}
					else {
						current.prev.next=null;
					}
				}
				else {
					current.next.prev=null;
				}
			}
			current =current.prev;
		}
		}
		}
   

	public T first() {
		// listako lehen elementua ematen du
		   // KODEA OSATU ETA KOSTUA KALKULATU
		if (isEmpty()) return null;
		Node<T> oraingoa = last;
		while (oraingoa.prev != null) {
			oraingoa = oraingoa.prev;
		}
		return oraingoa.data;
	
	}

	public T last() {
		// listako azken elementua ematen du
		   // KODEA OSATU ETA KOSTUA KALKULATU
		return last.data;
		}

	public DoubleLinkedList<T> clone(){
		// Zerrendaren kopia bat itzultzen du (ez du punteroa bikoizten)
	   // KODEA OSATU ETA KOSTUA KALKULATU
		
		DoubleLinkedList<T> kopia = new DoubleLinkedList<T>();
		Node<T> current = last;
		while (current.prev != null) {
			kopia.setLast(current);
			current=current.prev;
		}
		return kopia;
	} 

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela

  		// KODEA OSATU ETA KOSTUA KALKULATU
		boolean aurkitua=false;
		      if (isEmpty())
		          return false;
		      Node<T> current= last;
		      while(current.prev!=null && !aurkitua) {
		    	  if (current.data == elem) {
		    		  aurkitua=true;
		    		  
		    	  }
		      }
		      return aurkitua;

		   }

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela

		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> oraingoa = last;
		T datua = null;
		while(oraingoa.prev!=null && datua==null) {
			if (oraingoa.data == elem) {
				datua=oraingoa.data;
			}
			
		}
		return datua;
	}

	public boolean isEmpty() { 
	// KODEA OSATU ETA KOSTUA KALKULATU
		boolean hutsik=false;
		if (last==null) {
			hutsik=true;
		}
		return hutsik;
	}
	
	public int size() { 
	// KODEA OSATU ETA KOSTUA KALKULATU
	return count;
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		   private Node<T> current = last; 

		   public boolean hasNext()  { 
			   return (current != null);                     
			   } 

		   

		   public T next() { 
			   if (!hasNext()) return null; 
			   T elem = current.data; 
			   current = current.prev; 
			   return elem; 
			   }

		// KODEA OSATU 
		   
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}
