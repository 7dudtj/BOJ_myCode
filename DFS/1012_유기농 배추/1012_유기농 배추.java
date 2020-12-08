import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int T, N, M, K, i, j, X, Y, pos, loc;
		String s;
		int[] map;
		
		// get T
		s = read.nextLine();
		T = Integer.parseInt(s);
		
		// do process for T times
		for (i = 0; i < T; i++) {
			// get M, N, and K
			s = read.nextLine();
			pos = s.indexOf(" ");
			M = Integer.parseInt(s.substring(0, pos));
			s = s.substring(pos + 1);
			pos = s.indexOf(" ");
			N = Integer.parseInt(s.substring(0, pos));
			K = Integer.parseInt(s.substring(pos + 1));
			
			// make map
			map = new int[N*M];
			for (j = 0; j < N*M; j++) {
				map[j] = 0;
			}
			
			// set grass
			for (j = 0; j < K; j++) {
				s = read.nextLine();
				pos = s.indexOf(" ");
				X = Integer.parseInt(s.substring(0, pos));
				Y = Integer.parseInt(s.substring(pos + 1));
				loc = M*Y + X;
				map[loc] = 1;
			}
			
			// call DFS
			dfs mydfs = new dfs (M, N, map);
			mydfs.DFS();
			System.out.println(mydfs.total);

		}// end of the main for loop
		read.close();
		return;
	}

}

class dfs {
	int m; // length of map
	int n; // height of map
	int[] map;
	int total = 0; // number of Áö··ÀÌ
	boolean[] visited;
	int i;
	Node[] fList;
	
	// dfs constructor
	public dfs(int M, int N, int[] MAP) {
		m = M;
		n = N;
		map = new int[m*n];
		map = MAP;
		visited = new boolean[m*n];
		for (i = 0; i < m*n; i++) visited[i] = false;
		fList = new Node[m*n];
		for (i = 0; i < m*n; i++) fList[i] = new Node();
		setNodes();
	}
	
	// setNodes function
	public void setNodes() {
		for (i = 0; i < m*n; i++) {
			fList[i].nodeNumber = i;
			if (i == 0 || i == m-1 || i == m*(n-1) || i == m*n-1) {
				fList[i].fNum = 2;
				fList[i].friend = new int[fList[i].fNum];
				if (i == 0) {
					fList[i].addFriend(1);
					fList[i].addFriend(m);
				}else if (i == m-1) {
					fList[i].addFriend(m-2);
					fList[i].addFriend(2*m-1);
				}else if (i == m*(n-1)) {
					fList[i].addFriend(m*(n-2));
					fList[i].addFriend(m*(n-1)+1);
				}else {
					fList[i].addFriend(m*n-2);
					fList[i].addFriend(m*n-m-1);
				}
			}else if (1 <= i && i <= m-2) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i-1);
				fList[i].addFriend(i+1);
				fList[i].addFriend(i+m);
			}else if (m*(n-1)+1 <= i && i <= m*n-2) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i-1);
				fList[i].addFriend(i+1);
				fList[i].addFriend(i-m);
			}else if (i % m == 0 && i != 0 && i != m*(n-1)) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i-m);
				fList[i].addFriend(i+m);
				fList[i].addFriend(i+1);
			}else if (i % m == m-1 && i != m-1 && i != m*n-1) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i-m);
				fList[i].addFriend(i+m);
				fList[i].addFriend(i-1);
			}else {
				fList[i].fNum = 4;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i-1);
				fList[i].addFriend(i+1);
				fList[i].addFriend(i-m);
				fList[i].addFriend(i+m);
			}
		}
	}
	
	// DFS function
	public void DFS() {
		for (i = 0; i < m*n; i++) {
			if (!visited[i] && map[i] == 1) {
				doDFS(i);
				total++;
			}
		}
	}
	
	// doDFS function
	public void doDFS(int i) { // 'i' is starting point
		visit(i);
		for (int j = 0; j < fList[i].fNum; j++) {
			if (map[fList[i].friend[j]] == 1 &&
					visited[fList[i].friend[j]] == false) {
				doDFS(fList[i].friend[j]);
			}
		}
	}
	
	// visit function
	public void visit(int i) {
		visited[i] = true;
	}
}

class Node {
	int[] friend;
	int fNum;
	int nodeNumber;
	int count = 0;
	
	// add friend function
	public void addFriend(int i) {
		friend[count] = i;
		count++;
	}
	
	// show friends
	public void showFriend() {
		for (int i = 0; i < fNum; i++) {
			System.out.print(friend[i] + " ");
		}
	}
}
