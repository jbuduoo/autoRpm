package jb.com;

public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode one=new ListNode(3);
		ListNode two=new ListNode(2);
		ListNode three=new ListNode(0);
		ListNode four=new ListNode(-4);
		one.next=two;
		two.next=three;
		three.next=four;
		four.next=two;
		
		boolean isTrue=hasCycle(one);
	}

    public static boolean hasCycle(ListNode head) {
    	ListNode fast=head;
    	ListNode slow=head;
    	
		while(head !=null && head.next !=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast == slow){
				System.out.println("true");
				return true;
			}

		}
    	return false;
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
       next = null;
    }
}
