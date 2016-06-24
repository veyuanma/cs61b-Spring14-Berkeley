package list;

public class LockDListNode extends DListNode {
	
	protected boolean locked;
	
	LockDListNode(Object item, DListNode p, DListNode n){
		super(item,p,n);
		locked=false;
	}
	

}

