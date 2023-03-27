import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main{

	// set static variables
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static List<Archer> archers = new ArrayList<>();
	static int count = 0;
	static int answer = 0;
	static int nMonsters = 0;

	public static void main (String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// make map
		map = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) nMonsters++;
			}
		}

		// play game
		place(0, 0);

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}

	// place archers
	private static void place(int idx, int num){

		// finish placing -> play game
		if (num == 3){
			play();
			return;
		}

		// placing with combination
		for (int i = idx; i < M; i++){
			archers.add(new Archer(N, i));
			place(idx + 1, num + 1);
			archers.remove(archers.size() - 1);
		}
	}

	// play game
	private static void play(){

		// copy map
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				copyMap[i][j] = map[i][j];
			}
		}

		// set monsters
		int nMon = nMonsters;
		
		// play game
		while (nMon > 0){

			// set target for every archer
			for (Archer a: archers){

				// reset target
				a.ti = -1;
				a.tj = -1;
				int minDis = Integer.MAX_VALUE;

				// search target from left to right, bottom to top
				for (int j = 0; j < M; j++){
					for (int i = N-1; i >= 0; i--){

						// find monster -> calculate distance
						if (copyMap[i][j] == 1){

							int dis = Math.abs(i - a.i) + Math.abs(j - a.j);
							if (dis > D) continue;

							if (minDis > dis){
								minDis = dis;
								a.ti = i;
								a.tj = j;
							}
						}
					}
				}
			}

			// remove monsters
			for (Archer a: archers){

				// if target exists
				if (a.ti != -1 && copyMap[a.ti][a.tj] == 1){
					copyMap[a.ti][a.tj] = 0;
					nMon--;
					count++;
				}
			}

			// move monsters
			for (int i = N-1; i >= 0; i--){
				for (int j = 0; j < M; j++){

					// if monster exits
					if (copyMap[i][j] == 1){

						// if monster goes to out of map
						if (i == N-1){
							copyMap[i][j] = 0;
							nMon--;
						}
						// if monster alive at map
						else{
							copyMap[i][j] = 0;
							copyMap[i+1][j] = 1;
						}
					}
				}
			}
		}

		// check answer
		answer = Math.max(answer, count);
		count = 0;
		return;
	}
}

// archer class
class Archer{
	int i;
	int j;
	int ti;
	int tj;
	public Archer(int i, int j){
		this.i = i;
		this.j = j;
	}
}