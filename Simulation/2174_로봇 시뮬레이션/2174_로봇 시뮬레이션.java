import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	// set static variables
	static Robot[] robots;
	static int[][] map;
	static boolean crash = false, wall = false;
	static int from = 0, to = 0;
	static int A = 0, B = 0;

	public static void main(String[] args) throws IOException{
		
		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = 0, M = 0;

		// get variables
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// make map
		map = new int[B+1][A+1];

		// make robots
		robots = new Robot[N+1];
		int xLoc = 0, yLoc = 0, dir = -1;
		String tmp = "";
		for (int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			xLoc = Integer.parseInt(st.nextToken());
			yLoc = Integer.parseInt(st.nextToken());
			tmp = st.nextToken();
			if (tmp.equals("N")) dir = 0;
			else if (tmp.equals("W")) dir = 1;
			else if (tmp.equals("S")) dir = 2;
			else dir = 3;
			robots[i] = new Robot(xLoc, yLoc, dir);
			map[yLoc][xLoc] = i;
		}

		// check commands
		int bot = 0, repeat = 0;
		String command = "";
		for (int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine(), " ");
			bot = Integer.parseInt(st.nextToken());
			command = st.nextToken();
			repeat = Integer.parseInt(st.nextToken());

			checkSimulation(bot, command, repeat);

			if (crash || wall) break;
		}

		// print status
		if (!(crash || wall)) System.out.print("OK");
		else{
			if (crash){
				System.out.printf("Robot %d crashes into robot %d", from, to);
			}else if (wall){
				System.out.printf("Robot %d crashes into the wall", from);
			}
		}
		br.close();
		return;
	}

	private static void checkSimulation(int bot, String command, int repeat){

		// check simulation by command
		if (command.equals("L")){
			// command L
			robots[bot].dir = (robots[bot].dir + repeat) % 4;

		}else if (command.equals("R")){
			// command R
			robots[bot].dir = (robots[bot].dir + 100 - repeat) % 4;

		}else{
			// command F
			int dir = robots[bot].dir;
			int prevxLoc = robots[bot].xLoc;
			int prevyLoc = robots[bot].yLoc;
			int curxLoc = 0;
			int curyLoc = 0;

			// check step by step
			for (int i = 1; i <= repeat; i++){
				if (dir == 0){
					curxLoc = prevxLoc;
					curyLoc = prevyLoc + i;
				}else if (dir == 1){
					curxLoc = prevxLoc - i;
					curyLoc = prevyLoc;
				}else if (dir == 2){
					curxLoc = prevxLoc;
					curyLoc = prevyLoc - i;
				}else{
					curxLoc = prevxLoc + i;
					curyLoc = prevyLoc;
				}

				// crash with wall
				if (curxLoc < 1 || curxLoc > A || curyLoc < 1 || curyLoc > B){
					wall = true;
					from = bot;
					break;
				}

				// crash with other robots
				if (map[curyLoc][curxLoc] != 0){
					crash = true;
					from = bot;
					to = map[curyLoc][curxLoc];
					break;
				}
			}

			// any problem
			if (wall || crash) return;

			// no problem! move robots
			map[prevyLoc][prevxLoc] = 0;
			map[curyLoc][curxLoc] = bot;
			robots[bot].xLoc = curxLoc;
			robots[bot].yLoc = curyLoc;
		}

		return;
	}
}

class Robot{
	int xLoc;
	int yLoc;
	int dir;
	public Robot(int x, int y, int d){
		xLoc = x;
		yLoc = y;
		dir = d;
	}
}