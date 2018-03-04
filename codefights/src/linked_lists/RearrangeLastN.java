package linked_lists;

public class RearrangeLastN {

	public LinkedListNode<Integer> rearrangeLastN(LinkedListNode<Integer> head, int n) {
		
		LinkedListNode<Integer> tmp = head, res;
		int cnt = n;
		
		while(tmp != null && cnt > 0) {
			tmp = tmp.next;
			cnt--;
		}
		
		if(tmp == null) return head;
		
		LinkedListNode<Integer> tmp1 = head, prev = null;
		
		while(tmp != null) {
			tmp = tmp.next;
			tmp1 = tmp1.next;
			prev = tmp1;
		}
		
		res = tmp1;
		prev.next = null;

		while(tmp1 != null && tmp1.next != null) {
			tmp = tmp.next;
		}
		
		tmp1.next = head;
		
		
		return res;
	}
}
