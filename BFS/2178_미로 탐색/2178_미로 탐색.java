import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, M, pos, i, j;
		String s;
		int[] map;
		
		// get N and M
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		M = Integer.parseInt(s.substring(pos + 1));
		
		// set default map
		map = new int[N*M];
		
		// make map
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			for (j = 0; j < M; j++) {
				if (s.substring(j,j+1).equals("1")) map[i*M+j] = 1;
				else map[i*M+j] = 0;
			}
		}
		read.close();
		
		// call BFS
		bfs mybfs = new bfs(N, M, map);
		mybfs.BFS(0);	
		System.out.println(mybfs.len[N*M-1]);
	}

}

class bfs {
	int n; // n is height
	int m; // m is length
	int distance = 0; // distance from (0, 0) to (n-1, m-1)
	int[] len; // distance from 0 to point
	int[] map;
	int i;
	int minLen = 0;
	int[][] fList;
	
	// bfs constructor
	public bfs(int N, int M, int[] MAP) {
		n = N;
		m = M;
		map = new int[n*m];
		map = MAP;
		len = new int[n*m];
		for (i = 0; i < n*m; i++) len[i] = 0;
		fList = new int[n*m][];
		setfList();
	}
	
	// set fList
	public void setfList() {
		for (i = 0; i < n*m; i++) {
			if (i == 0) {
				fList[i] = new int[2];
				fList[i][0] = 1; fList[i][1] = m;
			}else if (i == m-1) {
				fList[i] = new int[2];
				fList[i][0] = m-2; fList[i][1] = 2*m-1;
			}else if (i == m*(n-1)) {
				fList[i] = new int[2];
				fList[i][0] = m*(n-2); fList[i][1] = m*(n-1)+1;
			}else if (i == n*m-1) {
				fList[i] = new int[2];
				fList[i][0] = n*m-2; fList[i][1] = n*m-m-1;
			}else if (1 <= i && i <= m-2) {
				fList[i] = new int[3];
				fList[i][0] = i-1; fList[i][1] = i+1; fList[i][2] = i+m;
			}else if (m*(n-1)+1 <= i && i <= n*m-2) {
				fList[i] = new int[3];
				fList[i][0] = i-1; fList[i][1] = i+1; fList[i][2] = i-m;
			}else if (i % m == 0 && i != 0 && i != m*(n-1)) {
				fList[i] = new int[3];
				fList[i][0] = i-m; fList[i][1] = i+m; fList[i][2] = i+1;
			}else if (i % m == m-1 && i != m-1 && i != n*m-1) {
				fList[i] = new int[3];
				fList[i][0] = i-m; fList[i][1] = i+m; fList[i][2] = i-1;
			}else {
				fList[i] = new int[4];
				fList[i][0] = i-1; fList[i][1] = i+1; 
				fList[i][2] = i-m; fList[i][3] = i+m;
			}
		}
	}
	
	// BFS function
	public void BFS(int v) {
		boolean[] visited = new boolean[n*m];
		//Queue q = new Queue();
		Queue<Integer> q = new LinkedList<Integer>();
		for (i = 0; i < n*m; i++) visited[i] = false;
		visited[v] = true;
		q.offer(v);

		while (!q.isEmpty()) {
			int u = q.poll();
			for (i = 0; i < fList[u].length; i++) {
				if ((!visited[fList[u][i]]) && (map[fList[u][i]]) == 1) {
					q.offer(fList[u][i]);
					visited[fList[u][i]] = true;
				}else if ((visited[fList[u][i]]) && (map[fList[u][i]]) == 1 &&
						len[fList[u][i]] != 0) {
					if (minLen > len[fList[u][i]]) minLen = len[fList[u][i]];
				}
			}
			len[u] = minLen + 1;
			minLen++;
		}
	}
}
