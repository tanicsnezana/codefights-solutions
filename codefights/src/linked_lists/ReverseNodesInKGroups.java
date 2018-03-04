package linked_lists;

public class ReverseNodesInKGroups {
	
	private LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev, next, curr;
		prev = null; next = null; curr = head;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	private int countSize(LinkedListNode<Integer> head) {
		int size = 0;
		
		while(head != null) {
			size++;
			head = head.next;
		}
		
		return size;
	}
	
	private LinkedListNode<Integer> makeNewList(LinkedListNode<Integer> l, int k) {
		LinkedListNode<Integer> head = null, prev = null, tmp;
		
		while(l != null && k > 0) {
			tmp = new LinkedListNode<>();
			tmp.value = l.value; tmp.next = null;
			
			if(head == null) {
				head = tmp;
			}
			else {
				prev.next = tmp;
			}
			
			prev = tmp; 
			l = l.next;
			k--;
		}
		
		return head;
	}
	
	public LinkedListNode<Integer> reverseNodesInKGroups(LinkedListNode<Integer> l, int k) {
		if(l == null || k < 0) return null;
		
		if(k == 0 || k == 1) return l;
		
		LinkedListNode<Integer> head, prev, tmp;
		
		head = null; prev = null;
		int counter = 0;
		
		while(l != null) {
			tmp = makeNewList(l, k);
			int size = countSize(tmp);
			
			if(size == k) {
				tmp = reverse(tmp);
			}
			
			if(head == null) {
				head = tmp;
			}
			else {
				prev.next = tmp;
			}
			
			while(prev != null && prev.next != null) {
				prev = prev.next;
			}
			
			counter = k;
	        while(counter > 0 && l != null) {
	            counter--;
	            l = l.next;
	        }
		}
		
		return head;
	}
}
