import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main{

	// set static variables
	static int[][][] map;
	static int K, W, H;
	static boolean[][][] visited;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {-1, 0, 1, 0};
	static int[] hi = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hj = {-1, -2, -2, -1, 1, 2, 2, 1};

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		String[] wh = br.readLine().split(" ");
		W = Integer.parseInt(wh[0]);
		H = Integer.parseInt(wh[1]);

		// make map
		map = new int[H][W][K+1];
		String[] tmpLine = null;
		int tmp = 0;
		for (int i = 0; i < H; i++){
			tmpLine = br.readLine().split(" ");
			for (int j = 0; j < W; j++){
				tmp = Integer.parseInt(tmpLine[j]);
				for (int k = 0; k < K+1; k++){
					map[i][j][k] = tmp;
				}
			}
		}

		// do bfs
		Queue<Node> q = new LinkedList<>();
		visited = new boolean[H][W][K+1];
		q.add(new Node(0, 0, K, 0));
		Node cur = null;
		int ni = -1;
		int nj = -1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while (!q.isEmpty()){

			cur = q.poll();

			// reach destination
			if (cur.i == H-1 && cur.j == W-1){
				pq.add(cur.d);
				continue;
			}

			// nearby jump
			for (int i = 0; i < 4; i++){
				ni = cur.i + di[i];
				nj = cur.j + dj[i];
				if (inRange(ni, nj) && !visited[ni][nj][cur.k] && map[ni][nj][cur.k] == 0){
					visited[ni][nj][cur.k] = true;
					q.add(new Node(ni, nj, cur.k, cur.d + 1));
				}
			}

			// horse jump
			if (cur.k > 0){
				for (int i = 0; i < 8; i++){

					ni = cur.i + hi[i];
					nj = cur.j + hj[i];
					if (inRange(ni, nj) && !visited[ni][nj][cur.k - 1] && map[ni][nj][cur.k - 1] == 0){
						visited[ni][nj][cur.k - 1] = true;
						q.add(new Node(ni, nj, cur.k - 1, cur.d + 1));
					}
				}
			}
		}

		// find answer and end program
		System.out.print(pq.isEmpty() ? -1 : pq.poll());
		br.close();
		return;
	}

	// check (i, j) is in map
	private static boolean inRange(int i, int j){
		return (0 <= i && i < H && 0 <= j && j < W);
	}

	// test function: checking map
	private static void checkMap(){
		for (int k = 0; k < K+1; k++){
			System.out.printf("Floor %d---------------\n", k);
			for (int i = 0; i < H; i++){
				for (int j = 0; j < W; j++){
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			} 
		}
	}
}

// node class
class Node{
	int i;
	int j;
	int k;
	int d;
	public Node(int i, int j, int k, int d){
		this.i = i;
		this.j = j;
		this.k = k;
		this.d = d;
	}
}