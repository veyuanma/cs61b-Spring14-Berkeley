package project1;

public class List {
	ListNode head;
	ListNode tail;
	long size;
	public List(){
		head=null;
		tail=null;
		
		size=0;
	}
	
	public void insertHead(int r, int g, int b, int num){
		if(size==0){
			head=new ListNode(r,g,b,num);
			tail=head;
		}
		else{
			ListNode node=new ListNode(r,g,b,num);
			node.next=head;
			head.prev=node;
			head=node;
		}
		size++;
	}
	
	public void insertTail(int r,int g, int b, int num){
		if(size==0){
			head=new ListNode(r,g,b,num);
			tail=head;
		}
		else{
			ListNode node=new ListNode(r,g,b,num);
			tail.next=node;
			node.prev=tail;
			tail=node;
		}
		size++;
	}
	
	public void insertBetween(int r,int g,int b,int num,ListNode pre){
		if(size==0){
			head=new ListNode(r,g,b,num);
			tail=head;
		}
		else{
			ListNode next=pre.next;
			ListNode node=new ListNode(r,g,b,num);
			pre.next=node;
			node.prev=pre;
			node.next=next;
			next.prev=node;
		}
		size++;
	}
	
	public void deleteHead(){
		if(size==0) return;
		else if(size==1){
			head=null;
			tail=null;
			size--;
		}
		else if(size>1){
			head=head.next;
			size--;
		}
	}
	
	public void deleteTail(){
		if(size==0) return;
		else if(size==1){
			head=null;
			tail=null;
		}
		else if(size>1){
			tail=tail.prev;
			tail.next=null;
		}
		size--;
	}
	
	public void deleteBetween(ListNode pre){
		if(size==0) return;
		else if(size==1){
			head=null;
			tail=null;
		}
		else{
			pre.next=pre.next.next;
			pre.next.prev=pre;
		}
		size--;
	}
	
}
