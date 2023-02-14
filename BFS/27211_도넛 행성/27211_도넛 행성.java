import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

	// set static variables
	static boolean[][] visited;
	static int answer = 0;
	static int N, M;
	static int[][] map;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get map
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// do bfs
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				bfs(i, j);
			}
		}

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}

	// bfs function
	private static void bfs(int i, int j){

		if (visited[i][j] || map[i][j] == 1) return;

		// set needed variables
		Queue<Loc> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new Loc(i, j));

		// do bfs
		while (!q.isEmpty()){

			Loc tmp = q.poll();
			
			for (int k = 0; k < 4; k++){

				int ni = iCheck(tmp.i + di[k]);
				int nj = jCheck(tmp.j + dj[k]);

				if (map[ni][nj] == 0 && !visited[ni][nj]){
					visited[ni][nj] = true;
					q.add(new Loc(ni, nj));
				}
			}
		}

		answer++;
		return;
	}

	// check i location function
	private static int iCheck(int i){
		if (i == -1) return N-1;
		else if (i == N) return 0;
		else return i;
	}

	// check j location function
	private static int jCheck(int j){
		if (j == -1) return M-1;
		else if (j == M) return 0;
		else return j;
	}
}

// Location class
class Loc{
	int i;
	int j;
	public Loc(int i, int j){
		this.i = i;
		this.j = j;
	}
}