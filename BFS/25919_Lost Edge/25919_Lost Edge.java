import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

	// set static variables
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int N, M, L, E;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sx = 0, sy = 0;

		// get map
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -3){
					sx = i;
					sy = j;
				}
			}
		}

		// explore
		int noLevelUp = 0;
		boolean levelUp = true;
		boolean reach = false;
		while (noLevelUp < 2){

			boolean[][] visited = new boolean[N][M];
			Queue<Loc> q = new LinkedList<>();
			visited[sx][sy] = true;
			q.add(new Loc(sx, sy));
			levelUp = false;

			while (!q.isEmpty()){

				Loc tmp = q.poll();
				int cx = tmp.x;
				int cy = tmp.y;
				if (map[cx][cy]==-2 && K<=L){
					System.out.print("O");
					return;
				}

				for (int i = 0; i < 4; i++){
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (inRange(nx, ny) && !visited[nx][ny]){
						if (map[nx][ny]==-2 && K<=L){
							System.out.print("O");
							return;
						}
						if (map[nx][ny] == 0){
							visited[nx][ny] = true;
							q.add(new Loc(nx, ny));
						}else if (0<map[nx][ny] && map[nx][ny] < L){
							levelUp = doLevelUp(map[nx][ny]);
							map[nx][ny] = 0;
							visited[nx][ny] = true;
							q.add(new Loc(nx, ny));
						}else continue;
					}
				}
			}

			if (levelUp) noLevelUp = 0;
			else noLevelUp++;
		}

		// print answer and end program
		if (reach) System.out.print("O");
		else System.out.print("X");
		br.close();
		return;
	}

	// in range function
	private static boolean inRange(int x, int y){
		return (0<=x && x<N && 0<=y && y<M);
	}

	// do level up
	private static boolean doLevelUp(int exp){

		E += exp;

		if (L <= E){
			E -= L;
			L++;
			return true;
		}

		return false;
	}
}

class Loc{
	int x;
	int y;
	public Loc(int x, int y){
		this.x = x;
		this.y = y;
	}
}