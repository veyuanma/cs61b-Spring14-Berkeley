package list;

public class LockDList extends DList{
	
	  /**
	   * lock a given node
	   */
	  public void lockNode(DListNode node){
			LockDListNode tmp=(LockDListNode)node;
			tmp.locked=true;
		}

	  /**
	   *  newNode() calls the DListNode constructor.  Use this class to allocate
	   *  new DListNodes rather than calling the DListNode constructor directly.
	   *  That way, only this method needs to be overridden if a subclass of DList
	   *  wants to use a different kind of node.
	   *  @param item the item to store in the node.
	   *  @param prev the node previous to this node.
	   *  @param next the node following this node.
	   */
	  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new LockDListNode(item, prev, next);
	  }

	  /**
	   *  DList() constructor for an empty DList.
	   */
	  public LockDList() {
	    //  Your solution here.
		  super();
	  }

	  /**
	   *  isEmpty() returns true if this DList is empty, false otherwise.
	   *  @return true if this DList is empty, false otherwise. 
	   *  Performance:  runs in O(1) time.
	   */
	  public boolean isEmpty() {
	    return size == 0;
	  }

	  /** 
	   *  length() returns the length of this DList. 
	   *  @return the length of this DList.
	   *  Performance:  runs in O(1) time.
	   */
	  public int length() {
	    return size;
	  }

	  /**
	   *  insertFront() inserts an item at the front of this DList.
	   *  @param item is the item to be inserted.
	   *  Performance:  runs in O(1) time.
	   */
	  public void insertFront(Object item) {
	    // Your solution here.
		  super.insertFront(item);
		  
	  }

	  /**
	   *  insertBack() inserts an item at the back of this DList.
	   *  @param item is the item to be inserted.
	   *  Performance:  runs in O(1) time.
	   */
	  public void insertBack(Object item) {
	    // Your solution here.
		  super.insertBack(item);
		  
	  }

	  /**
	   *  front() returns the node at the front of this DList.  If the DList is
	   *  empty, return null.
	   *
	   *  Do NOT return the sentinel under any circumstances!
	   *
	   *  @return the node at the front of this DList.
	   *  Performance:  runs in O(1) time.
	   */
	  public LockDListNode front() {
	    // Your solution here.
		  return (LockDListNode)super.front();
	  }

	  /**
	   *  back() returns the node at the back of this DList.  If the DList is
	   *  empty, return null.
	   *
	   *  Do NOT return the sentinel under any circumstances!
	   *
	   *  @return the node at the back of this DList.
	   *  Performance:  runs in O(1) time.
	   */
	  public LockDListNode back() {
	    // Your solution here.
		  return (LockDListNode)super.back();
	  }

	  /**
	   *  next() returns the node following "node" in this DList.  If "node" is
	   *  null, or "node" is the last node in this DList, return null.
	   *
	   *  Do NOT return the sentinel under any circumstances!
	   *
	   *  @param node the node whose successor is sought.
	   *  @return the node following "node".
	   *  Performance:  runs in O(1) time.
	   */
	  public LockDListNode next(DListNode node) {
	    // Your solution here.
		  return (LockDListNode)super.next(node);
	  }

	  /**
	   *  prev() returns the node prior to "node" in this DList.  If "node" is
	   *  null, or "node" is the first node in this DList, return null.
	   *
	   *  Do NOT return the sentinel under any circumstances!
	   *
	   *  @param node the node whose predecessor is sought.
	   *  @return the node prior to "node".
	   *  Performance:  runs in O(1) time.
	   */
	  public LockDListNode prev(DListNode node) {
	    // Your solution here.
		  return (LockDListNode)super.prev(node);
	  }

	  /**
	   *  insertAfter() inserts an item in this DList immediately following "node".
	   *  If "node" is null, do nothing.
	   *  @param item the item to be inserted.
	   *  @param node the node to insert the item after.
	   *  Performance:  runs in O(1) time.
	   */
	  public void insertAfter(Object item, DListNode node) {
	    // Your solution here.
		  super.insertAfter(item, node);
	  }

	  /**
	   *  insertBefore() inserts an item in this DList immediately before "node".
	   *  If "node" is null, do nothing.
	   *  @param item the item to be inserted.
	   *  @param node the node to insert the item before.
	   *  Performance:  runs in O(1) time.
	   */
	  public void insertBefore(Object item, DListNode node) {
	    // Your solution here.
		  super.insertBefore(item, node);
	  }

	  /**
	   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
	   *  Performance:  runs in O(1) time.
	   */
	  public void remove(DListNode node) {
	    // Your solution here.
		  if(node!=null){
			  if(((LockDListNode)node).locked==false){
				  node.prev.next=node.next;
				  node.next.prev=node.prev;
				  node.prev=null;
				  node.next=null;
				  size--;
			  }
		  }
		  
	  }

	  
	  public String toString() {
	    String result = "[  ";
	    DListNode current = head.next;
	    while (current != head) {
	      result = result + current.item + "  ";
	      current = current.next;
	    }
	    return result + "]";
	  }
	
	
	
}
