package project1;

public class ListNode {
	int r;
	int g;
	int b;
	int len;
	ListNode prev;
	ListNode next;
	
	public ListNode(){
		r=0;
		g=0;
		b=0;
		len=0;
		prev=null;
		next=null;
	}
	
	public ListNode(int r,int g, int b,int len){
		this.r=r;
		this.g=g;
		this.b=b;
		this.len=len;
		prev=null;
		next=null;
	}
}
