package linked_lists;

public class MergeTwoLinkedLists {

	public LinkedListNode<Integer> mergeTwoLinkedLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		
		if(l1 == null && l2 == null) return null;
		
		if(l1 == null) return l2;
		
		if(l2 == null) return l1;
		
		LinkedListNode<Integer> head, prev, tmp;
		head = null; prev = null;
		
		while(l1 != null || l2 != null) {
			if(l1 == null) {
				tmp = new LinkedListNode<>();
				tmp.value = l2.value;
				tmp.next = null;
				
				if(head == null) {
					head = tmp;
				}
				else {
					prev.next = tmp;
				}
				
				prev = tmp; l2 = l2.next;
			}
			else if(l2 == null) {
				tmp = new LinkedListNode<>();
				tmp.value = l1.value;
				tmp.next = null;
				
				if(head == null) {
					head = tmp;
				}
				else {
					prev.next = tmp;
				}
				
				prev = tmp; l1 = l1.next;
			}
			else if(l1.value < l2.value) {
				while(l1.value <= l2.value) {
					tmp = new LinkedListNode<>();
					tmp.value = l1.value;
					tmp.next = null;
					
					if(head == null) {
						head = tmp;
					}
					else {
						prev.next = tmp;
					}
					
					prev = tmp; l1 = l1.next;
				}
			}
			else {
				while(l2.value <= l1.value) {
					tmp = new LinkedListNode<>();
					tmp.value = l2.value;
					tmp.next = null;
					
					if(head == null) {
						head = tmp;
					}
					else {
						prev.next = tmp;
					}
					
					prev = tmp; l2 = l2.next;
				}
			}
		}
		
		
		return head;
	}
}
