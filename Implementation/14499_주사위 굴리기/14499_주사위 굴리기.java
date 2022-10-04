import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	
	// set static variables
	static int N = 0, M = 0, x = -1, y = -1;
	static int diceTop = 0, diceBottom = 0, diceFront = 0;
	static int diceBack = 0, diceLeft = 0, diceRight = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int K = 0;
		StringBuilder sb = new StringBuilder();

		// get data
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// get map
		map = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// get commands
		int[] commands = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++){
			commands[i] = Integer.parseInt(st.nextToken());
		}

		// do commands
		int command = 0;
		for (int i = 0; i < K; i++){
			command = commands[i];
			
			if (!moveDice(command)) continue;
			copyValues();
			sb.append(diceTop).append('\n');
		}

		// print answer and end program
		System.out.print(sb);
		br.close();
		return;
	}

	// move dice
	private static boolean moveDice(int command){

		if (command == 1){
			if (y == M-1) return false;
			else y++;
		}else if (command == 2){
			if (y == 0) return false;
			else y--;
		}else if (command == 3){
			if (x == 0) return false;
			else x--;
		}else{
			if (x == N-1) return false;
			else x++;
		}

		adjustDiceNumber(command);

		return true;
	}

	// find and adjust dice number
	private static void adjustDiceNumber(int command){
		
		// copy previous values
		int top = diceTop, bottom = diceBottom, front = diceFront;
		int back = diceBack, left = diceLeft, right = diceRight;

		// adjust dice number
		if (command == 1){
			// move East
			diceTop = left;
			diceBottom = right;
			diceLeft = bottom;
			diceRight = top;

		}else if (command == 2){
			// move West
			diceTop = right;
			diceBottom = left;
			diceLeft = top;
			diceRight = bottom;

		}else if (command == 3){
			// move North
			diceTop = back;
			diceBottom = front;
			diceFront = top;
			diceBack = bottom;

		}else if (command == 4){
			// move South
			diceTop = front;
			diceBottom = back;
			diceFront = bottom;
			diceBack = top;

		}

		return;
	}
	
	// copy values with map and dice
	private static void copyValues(){

		// from dice to map
		if (map[x][y] == 0){
			map[x][y] = diceBottom;
		}
		// from map to dice
		else if (map[x][y] != 0){
			diceBottom = map[x][y];
			map[x][y] = 0;
		}
		return;
	}
}