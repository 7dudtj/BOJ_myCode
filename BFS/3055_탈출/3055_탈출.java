import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

	// set static variables
	static int R = -1, C = -1;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		String tmp = "";
		Queue<Loc> water = new LinkedList<>();
		Queue<Loc> danger = new LinkedList<>();
		Queue<Loc> hedgehog = new LinkedList<>();
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, -1, 0, 1};
		int moveTime = 0;

		// make map
		for (int i = 0; i < R; i++){
			tmp = br.readLine();
			int j = 0;
			for (char ch: tmp.toCharArray()){
				map[i][j] = charToMap(ch);
				if (ch == '*') water.add(new Loc(i, j));
				if (ch == 'S') hedgehog.add(new Loc(i, j));
				j++;
			}
		}
		br.close();

		// find answer
		while (true){

			// 1. check danger zone
			Loc curWater = null;
			while (!water.isEmpty()){
				curWater = water.poll();
				int curi = curWater.i;
				int curj = curWater.j;

				for (int i = 0; i < 4; i++){
					int newi = curi+di[i];
					int newj = curj+dj[i];
					if (!inMap(newi, newj)) continue;

					if (map[newi][newj] == 0) {
						map[newi][newj] = 5;
						danger.add(new Loc(newi, newj));
					}else if (map[newi][newj] == 4){
						map[newi][newj] = 6;
						danger.add(new Loc(newi, newj));
					}
				}
			}

			// 2. move hedgehog
			Loc curHedgehog = null;
			int numHedgehog = hedgehog.size();
			moveTime++;
			for (int h = 0; h < numHedgehog; h++){
				curHedgehog = hedgehog.poll();
				int curi = curHedgehog.i;
				int curj = curHedgehog.j;

				for (int i = 0; i < 4; i++){
					int newi = curi+di[i];
					int newj = curj+dj[i];
					if (!inMap(newi, newj)) continue;

					if (map[newi][newj] == 0){
						map[newi][newj] = 4;
						hedgehog.add(new Loc(newi, newj));
					}else if (map[newi][newj] == 3){
						System.out.print(moveTime);
						return;
					}
				}
				if (map[curi][curj] == 6){
					map[curi][curj] = 5;
				}else{
					hedgehog.add(new Loc(curi, curj));
				}
			}

			// 3. move water
			Loc curDanger = null;
			while (!danger.isEmpty()){
				curDanger = danger.poll();
				int curi = curDanger.i;
				int curj = curDanger.j;

				map[curi][curj] = 1;
				water.add(new Loc(curi, curj));
			}

			// 4. check if any hedgehog exists
			if (hedgehog.size() == 0) break;
		}

		// print answer and end program
		System.out.print("KAKTUS");
		return;
	}
	
	// read character, convert to map code
	private static int charToMap(char ch){

		int answer = -1;

		if (ch == '.') answer = 0;
		else if (ch == '*') answer = 1;
		else if (ch == 'X') answer = 2;
		else if (ch == 'D') answer = 3;
		else if (ch == 'S') answer = 4;
		else System.out.println("error"); // for test

		return answer;
	}

	// check if next move will in map
	private static boolean inMap(int i, int j){
		if (i<0 || i>=R || j<0 || j>=C) return false;
		return true;
	}
}

class Loc{
	int i = -1;
	int j = -1;
	public Loc(int i, int j){
		this.i = i;
		this.j = j;
	}
}