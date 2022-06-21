import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int[] x, y;
		int N, M, V, pos, i;
		String s;
		
		// get N, M, and V
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		s = s.substring(pos + 1);
		pos = s.indexOf(" ");
		M = Integer.parseInt(s.substring(0, pos));
		V = Integer.parseInt(s.substring(pos + 1));
		
		// set x and y
		x = new int[M];
		y = new int[M];
		for (i = 0; i < M; i++) {
			s = read.nextLine();
			pos = s.indexOf(" ");
			x[i] = Integer.parseInt(s.substring(0, pos));
			y[i] = Integer.parseInt(s.substring(pos + 1));
		}
		read.close();
		
		// call DFS
		dfs mydfs = new dfs(N, M, x, y);
		mydfs.DFS(V - 1);
		mydfs.showAnswer();
		
		// call BFS
		bfs mybfs = new bfs(N, M, x, y);
		mybfs.BFS(V - 1);
		mybfs.showAnswer();
		
		// end program
		return;		
	}

}

class dfs {
	int n; // n is number of vertices
	int m; // m is number of edges
	int numofNodes = 0;
	int[] dfsList;
	int[] x;
	int[] y;
	int i;
	Node[] gNode;
	
	// dfs constructor
	public dfs(int N, int M, int[] xc, int[] yc) {
		n = N;
		m = M;
		x = new int[M];
		x = xc;
		y = new int[M];
		y = yc;
		dfsList = new int[N];
		setNodes();
		sortFriend();
	}
	
	// set Nodes
	public void setNodes() {
		gNode = new Node[n];
		
		// set default Nodes
		for (i = 0; i < n; i++) {
			gNode[i] = new Node(m);
		}
		
		// fill in Nodes
		for (i = 0; i < m; i++) {
			gNode[x[i] - 1].addFriend(y[i] - 1);
			gNode[y[i] - 1].addFriend(x[i] - 1);
		}
	}
	
	// sort friends
	public void sortFriend() {
		for (i = 0; i < n; i++) {
			quickSort(gNode[i].friend, 0, 2 * m - 1);
		}
	}
	
	// DFS function
	public void DFS(int v) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) visited[i] = false;
		doDFS(v, visited);
	}
	
	// doDFS function
	public void doDFS(int v, boolean[] visited) {
		visit(v, visited);
		for (int j = 0; j < 2 * m; j++) {
			if ((gNode[v].friend[j] != Integer.MAX_VALUE) && 
					(visited[gNode[v].friend[j]] == false)) {
				doDFS(gNode[v].friend[j], visited);
			}
		}
	}
	
	// visit function
	public void visit(int v, boolean[] visited) {
		visited[v] = true;
		dfsList[numofNodes] = v + 1;
		numofNodes++;
	}
	
	// quick sort
	public void quickSort(int[] data, int l, int r) {
		int left = l, right = r, pivot = data[(l + r) / 2];
		
		do {
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			if(left <= right) {
				int tmp = data[left];
				data[left] = data[right];
				data[right] = tmp;
				left++;
				right--;
			}
		}while (left <= right);
		
		if(l < right) quickSort(data, l, right);
		if(r > left) quickSort(data, left, r);
	}
	
	// show answer
	public void showAnswer() {
		for (i = 0; i < numofNodes - 1; i++) {
			System.out.print(dfsList[i] + " ");
		}
		System.out.println(dfsList[numofNodes - 1]);
	}
}

class Node {
	// components
	int nodeNumber;
	int[] friend;
	int fNum = 0;
	
	// constructor
	public Node(int M) {
		friend = new int[2*M];
		for (int i = 0; i < 2*M; i++) friend[i] = Integer.MAX_VALUE;
	}
	
	// add friend function
	public void addFriend(int i) {
		friend[fNum] = i;
		fNum++;
	}
}

class bfs {
	int n; // n is number of vertices
	int m; // m is number of edges
	int numofNodes = 0;
	int[] bfsList;
	int[] x;
	int[] y;
	int i;
	Node[] gNode;
	
	// bfs constructor
	public bfs(int N, int M, int[] xc, int[] yc) {
		n = N;
		m = M;
		x = new int[M];
		x = xc;
		y = new int[M];
		y = yc;
		bfsList = new int[N];
		setNodes();
		sortFriend();
	}
	
	// set Nodes
	public void setNodes() {
		gNode = new Node[n];
		
		// set default Nodes
		for (i = 0; i < n; i++) {
			gNode[i] = new Node(m);
		}
		
		// fill in Nodes
		for (i = 0; i < m; i++) {
			gNode[x[i] - 1].addFriend(y[i] - 1);
			gNode[y[i] - 1].addFriend(x[i] - 1);
		}
	}
	
	// sort friends
	public void sortFriend() {
		for (i = 0; i < n; i++) {
			quickSort(gNode[i].friend, 0, 2 * m - 1);
		}
	}
	
	// BFS function
	public void BFS(int v) {
		boolean[] visited = new boolean[n];
		Queue q = new Queue();
		for (int i = 0; i < n; i++) visited[i] = false;
		visit(v, visited);
		q.enqueue(v);
		while (!q.isEmpty()) {
			int u = q.dequeue();
			for (i = 0; i < 2*m; i++) {
				if (gNode[u].friend[i] != Integer.MAX_VALUE && 
						visited[gNode[u].friend[i]] == false) {
					visit(gNode[u].friend[i], visited);
					q.enqueue(gNode[u].friend[i]);
				}
			}
		}
	}
	
	// visit function
	public void visit(int v, boolean[] visited) {
		visited[v] = true;
		bfsList[numofNodes] = v + 1;
		numofNodes++;
	}
	
	// quick sort
	public void quickSort(int[] data, int l, int r) {
		int left = l, right = r, pivot = data[(l + r) / 2];
		
		do {
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			if(left <= right) {
				int tmp = data[left];
				data[left] = data[right];
				data[right] = tmp;
				left++;
				right--;
			}
		}while (left <= right);
		
		if(l < right) quickSort(data, l, right);
		if(r > left) quickSort(data, left, r);
	}
	
	// show answer
	public void showAnswer() {
		for (i = 0; i < numofNodes - 1; i++) {
			System.out.print(bfsList[i] + " ");
		}
		System.out.println(bfsList[numofNodes - 1]);
	}
}

class NodeQ {
	public int data;
	public NodeQ next;
}

class LinkedList {
	public NodeQ first, last;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public int deleteFirst() {
		int ret;
		
		if (first == null) return -1;
		ret = first.data;
		first = first.next;
		if (first == null) last = null;
		return ret;
	}
	
	public void insertAtEnd(int x) {
		NodeQ newnode;
		
		newnode = new NodeQ();
		newnode.data = x;
		newnode.next = null;
		if (last == null) first = last = newnode;
		else {
			last.next = newnode;
			last = newnode;
		}
	}
}

class Queue {
	private final LinkedList llist;
	
	public Queue() {
		llist = new LinkedList();
	}
	
	public void enqueue(int x) {
		llist.insertAtEnd(x);
	}
	
	public int dequeue() {
		return llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
}
