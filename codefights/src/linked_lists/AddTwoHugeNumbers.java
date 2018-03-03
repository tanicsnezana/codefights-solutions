package linked_lists;

public class AddTwoHugeNumbers {

	private LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev, curr, next;
		curr = head;
		prev = null; next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public LinkedListNode<Integer> addHugeNumbers(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
		
		if(a == null && b == null) return null;
		
		if(a == null) return b;
		
		if(b == null) return a;
		
		a = reverse(a);
		b = reverse(b);
		
		LinkedListNode<Integer> res = null, prev = null, tmp;
		int carry = 0, sum;
		
		while(a != null || b != null) {
			sum = carry + (a != null ? a.value : 0) + (b != null ? b.value : 0);
			carry = (sum > 9999) ? 1 : 0;
			
			if(sum > 9999) {
				if(sum - 9999 > 1) {
					while(sum - 9999 > 0)
						sum -= 10000;
				}
				else {
					sum = 0;
				}
			}
			
			tmp = new LinkedListNode<>();
			tmp.value = sum; tmp.next = null;
			
			if(res == null) {
				res = tmp;
			}
			else {
				prev.next = tmp;
			}
			
			prev = tmp;
			
			if(a != null) a = a.next;
			if(b != null) b = b.next;
		}
		
		if(carry > 0) {
			tmp = new LinkedListNode<>();
			tmp.value = carry;
			
			if(res == null) {
				res = tmp;
			}
			else {
				prev.next = tmp;
			}
		}
		
		res = reverse(res);
		
		return res;
	}
}
