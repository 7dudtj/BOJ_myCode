import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class Main{

	// set static variables
	static int N = 0;
	static int[][] student = null;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {-1, 0, 1, 0};
	static boolean[][] sit = null;
	static int[][] room = null;
	static PriorityQueue<Seat> pq = null;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] tmp = null;
		HashMap<Integer, Integer> dict = new HashMap<>();

		// get student's friend list
		student = new int[N * N][5];
		for (int i = 0; i < N * N; i++){
			tmp = br.readLine().split(" ");
			for (int j = 0; j < 5; j++){
				student[i][j] = Integer.parseInt(tmp[j]);
			}
			dict.put(student[i][0], i);
		}

		// sit down students
		sit = new boolean[N + 1][N + 1];
		room = new int[N + 1][N + 1];
		pq = new PriorityQueue<>(new Comparator<Seat>(){
			@Override
			public int compare(Seat s1, Seat s2){
				if (s1.nFriend == s2.nFriend){
					if (s1.nEmpty == s2.nEmpty){
						if (s1.row == s2.row){
							return s1.col - s2.col;
						}else return s1.row - s2.row;
					}else return s2.nEmpty - s1.nEmpty;
				}else return s2.nFriend - s1.nFriend;
			}
		});
		for (int s = 0; s < N * N; s++){
			sitStudent(s);
		}

		// calculate satisfaction point
		int sp = 0;
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= N; j++){

				// find number of nearby friends
				int nF = 0;
				for (int k = 0; k < 4; k++){
					int ni = i + di[k];
					int nj = j + dj[k];
					if (ni < 1 || ni > N || nj < 1 || nj > N) continue;
					for (int f = 1; f <= 4; f++){
						if (room[ni][nj] == student[dict.get(room[i][j])][f]){
							nF++;
						}
					}
				}

				// calculate point
				if (nF == 0) sp += 0;
				else if (nF == 1) sp += 1;
				else if (nF == 2) sp += 10;
				else if (nF == 3) sp += 100;
				else if (nF == 4) sp += 1000;
				else continue;
			}
		}

		// print answer and end program
		System.out.print(sp);
		br.close();
		return;
	}

	// sit student
	private static void sitStudent(int s){

		// search room
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= N; j++){
				if (sit[i][j]) continue; // pass if seat is not empty
				Seat target = new Seat(0, 0, i, j);
				for (int k = 0; k < 4; k++){
					int ni = i + di[k];
					int nj = j + dj[k];
					if (ni < 1 || ni > N || nj < 1 || nj > N) continue; // pass if out of room
					if (!sit[ni][nj]){
						target.nEmpty++; // nearby is empty seat
					}else{
						for (int f = 1; f <= 4; f++){
							if (room[ni][nj] == student[s][f]){
								target.nFriend++; // neardy exists friend
							}
						}
					}
				}
				pq.add(target);
			}
		}

		// sit student at best seat
		Seat best = pq.poll();
		room[best.row][best.col] = student[s][0];
		sit[best.row][best.col] = true;
		pq.clear();

		return;
	}
}

// seat class
class Seat{
	int nFriend;
	int nEmpty;
	int row;
	int col;
	public Seat(int f, int e, int r, int c){
		nFriend = f;
		nEmpty = e;
		row = r;
		col = c;
	}
}