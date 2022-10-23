import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

	// set static variables
	static int minValue = Integer.MAX_VALUE;
	static int maxValue = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int n;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st = null;

		// get map
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				minValue = Math.min(minValue, map[i][j]);
				maxValue = Math.max(maxValue, map[i][j]);
			}
		}

		// do binary search
		int left = 0, right = maxValue - minValue, mid = 0;

		while (left <= right){

			mid = (left + right) / 2;

			if (reachable(mid)){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}

		// print answer and end program
		System.out.print(left);
		br.close();
		return;
	}

	// check reachability
	private static boolean reachable(int diff){

		for (int i = minValue; i + diff <= maxValue; i++){
			int s = i;
			int e = i + diff;

			// check start positon
			if (map[0][0] < s || map[0][0] > e) continue;

			// set variables for doing bfs
			Queue<Loc> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			q.add(new Loc(0, 0));
			visited[0][0] = true;
			Loc tmp = null;

			// do bfs
			while (!q.isEmpty()){
				tmp = q.poll();

				if (tmp.x == n-1 && tmp.y == n-1) return true; // reach destination

				// search neighbor location
				for (int j = 0; j < 4; j++){
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];

					if (inMap(nx, ny) && !visited[nx][ny] && (s <= map[nx][ny] && map[nx][ny] <= e)){
						visited[nx][ny] = true;
						q.add(new Loc(nx, ny));
					}
				}
			}	
		}

		return false;
	}
	
	// check if input location is in map
	private static boolean inMap(int x, int y){
		if (x < 0 || x >= n || y < 0 || y >= n) return false;
		return true;
	}
}

// Location class
class Loc {
	int x;
	int y;
	public Loc(int x, int y){
		this.x = x;
		this.y = y;
	}
}