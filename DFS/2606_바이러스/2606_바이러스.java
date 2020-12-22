import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, M, i, pos;
		int[] x, y;
		String s;
		
		// get N and M
		s = read.nextLine();
		N = Integer.parseInt(s);
		s = read.nextLine();
		M = Integer.parseInt(s);
		
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
		mydfs.DFS(0);
		System.out.println(mydfs.numofNodes - 1);
		
		// end program
		return;
	}

}

class Node {
	// components
	int nodeNumber;
	int[] friend;
	int fNum = 0;
	
	// constructor
	public Node(int N) {
		friend = new int[N];
		for (int i = 0; i < N; i++) friend[i] = Integer.MAX_VALUE;
	}
	
	// add friend function
	public void addFriend(int i) {
		friend[fNum] = i;
		fNum++;
	}
}

class dfs {
	int n;
	int m;
	int numofNodes = 0;
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
		setNodes();
	}
	
	// set Nodes
	public void setNodes() {
		gNode = new Node[n];
		
		// set default Nodes
		for (i = 0; i < n; i++) gNode[i] = new Node(n);
		
		// fill in Nodes
		for (i = 0; i < m; i++) {
			gNode[x[i] - 1].addFriend(y[i] - 1);
			gNode[y[i] - 1].addFriend(x[i] - 1);
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
		for (int j = 0; j < n; j++) {
			if((gNode[v].friend[j] != Integer.MAX_VALUE) && 
					(visited[gNode[v].friend[j]] == false)) {
				doDFS(gNode[v].friend[j], visited);
			}
		}
	}
	
	// visit function
	public void visit(int v, boolean[] visited) {
		visited[v] = true;
		numofNodes++;
	}
}
