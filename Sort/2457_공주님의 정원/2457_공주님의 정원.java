import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];

		// get flowers information with processing
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int start = getDay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int end = getDay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			flowers[i] = new Flower(start, end);
		}
		br.close();

		// sort flowers sort start by asc, sort end by des
		Arrays.sort(flowers);

		// find answer
		int from = 60;
		int to = 334;
		int answer = 0;
		int max = 0;
		int idx = 0;
		boolean find = false;
		
		while (from <= to){

			find = false;

			for (int i = idx; i < N; i++){

				// no answer
				if (flowers[i].start > from){
					break;
				}

				// find flower
				if (max < flowers[i].end){
					idx = i;
					max = flowers[i].end;
					find = true;
				}
			}

			if (find){
				answer++;
				from = max;
			}else{
				break;
			}
		}

		// print answer and end program
		if (max > to) System.out.print(answer);
		else System.out.print(0);
		return;
	}

	private static int getDay(int month, int day){
		/*	
		 *	Get month and day, return day from Jan 1st
		 *  [input]
		 * 		month: int
		 * 		day: int
		 * 	[output]
		 * 		day from Jan 1st: int
		 */

		// set needed variables
		int[] monthList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int answer = 0;

		// calculate
		for (int i = 1; i < month; i++) answer += monthList[i-1];
		answer += day;

		// return
		return answer;
	}
}

// flower class
class Flower implements Comparable<Flower>{
	int start;
	int end;
	public Flower(int s, int e){
		start = s;
		end = e;
	}
	@Override
	public int compareTo(Flower f){
		if (start == f.start) return f.end - end;
		else return start - f.start;
	}
}