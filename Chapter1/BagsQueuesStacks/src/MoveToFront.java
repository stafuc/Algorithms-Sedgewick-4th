
public class MoveToFront {
	
	private static class Node {
		char c;
		Node next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = StdIn.readString();
		Node head = null;
		for (int i = 0; i < s.length(); i++) {
			Node n = new Node();
			n.c = s.charAt(i);
			if(head == null)	head = n;
			else{
				Node cur = head, pre = null;
				while(cur != null && cur.c != s.charAt(i)){
					pre = cur;
					cur = cur.next;
				}
				if(cur == null){
					n.next = head;
					head = n;
				}else{
					if(pre == null){
						head = head.next;
					}else{
						pre.next = cur.next;
					}
					n.next = head;
					head = n;
				}
			}
		}
		
		Node cur = head;
		while(cur != null){
			StdOut.print(cur.c + " ");
			cur = cur.next;
		}
	}

}
