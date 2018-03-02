package linked_lists;

public class RemoveKFromList {
	
	public LinkedListNode<Integer> removeKFromList(LinkedListNode<Integer> head, int k) {
		if(head == null) return null;
		
		LinkedListNode<Integer> current, previous;
		current = head;
		previous = null;
		
		while(current != null) {
			
			if(current.value == k) {
				if(previous == null) {
					current = current.next;
					head = current;
				}
				else {
					previous.next = current.next;
					current = current.next;
				}
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		
		return head;
	}
}
