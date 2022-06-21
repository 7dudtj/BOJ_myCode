import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Queue myQ = new Queue();
		Scanner read = new Scanner(System.in);
		int N, K, pos, i;
		int[] list;
		String s;
		
		// get N and K
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		K = Integer.parseInt(s.substring(pos + 1));
		read.close();
		
		// make list
		list = new int[N];
		
		// make queue
		for (i = 1; i <= N; i++) {
			myQ.enqueue(i);
		}
		
		// do process
		if (K == 1) {
			for (i = 0; i < N; i++) list[i] = i + 1;
		}else {
			for (i = 0; i < N - 1; i++) {
				myQ.moveCur(K);
				int ans = myQ.getCurData();
				myQ.deleteCur();
				list[i] = ans;
			}
			list[N - 1] = myQ.firstData();
		}
		
		// display answer
		System.out.print("<");
		if (N == 1) System.out.print(list[0]);
		else {
			for (i = 0; i < N - 1; i++) {
				System.out.print(list[i] + ", ");
			}
			System.out.print(list[N - 1]);
		}
		System.out.print(">");
	}

}

class Node {
	public int data;
	public Node prev, next;
}

class LinkedList {
	public Node first, last, cur;
	
	public LinkedList() {
		first = null;
		last = null;
		cur = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public int deleteFirst() {
		int ret;
		
		if (first == null) return -1;
		ret = first.data;
		if (first == last) first = last = cur = null;
		else {
			first.next.prev = last;
			first = first.next;
			last.next = first;
		}
		
		return ret;
	}
	
	public void insertAtEnd(int x) {
		Node newnode;
		
		newnode = new Node();
		newnode.data = x;
		newnode.next = null;
		if (last == null) {
			first = last = newnode;
			first.next = last;
			first.prev = last;
			last.next = first;
			last.prev = first;
			cur = first;
		}
		else {
			last.next = newnode;
			newnode.prev = last;
			last = newnode;
			last.next = first;
			first.prev = last;
		}
	}
}

class Queue {
	private final LinkedList llist;
	int len = 0;
	
	public Queue() {
		llist = new LinkedList();
	}
	
	public void enqueue(int x) {
		llist.insertAtEnd(x);
		len++;
	}
	
	public int dequeue() {
		len--;
		return llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	public void moveCur(int K) {
		for (int i = 0; i < K - 1; i++) {
			llist.cur = llist.cur.next;
		}
	}
	
	public int firstData() {
		return llist.cur.data;
	}
	
	public int getCurData() {
		return llist.cur.data;
	}
	
	public void deleteCur() {
		llist.cur.prev.next = llist.cur.next;
		llist.cur.next.prev = llist.cur.prev;
		llist.cur = llist.cur.next;
	}
}
