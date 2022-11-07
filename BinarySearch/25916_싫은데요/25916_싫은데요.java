import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main{

	// set static variables
	static long[] cs;
	static long M;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		long[] A = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) A[i] = Long.parseLong(st.nextToken());
		long answer = 0;

		// make cumulative sum list
		cs = new long[N+1];
		for (int i = 1; i <= N; i++) cs[i] = cs[i-1] + A[i-1];

		// find answer
		for (int i = 0; i <= N; i++){
			long left = leftBinarySearch(0, i-1, cs[i]);
			long right = rightBinarySearch(i+1, N, cs[i]);

			answer = Math.max(answer, Math.max(left, right));
		}

		// print answer and end program
		System.out.print(answer);
	}

	// binary search function for left area
	private static long leftBinarySearch(int left, int right, long pivot){

		long answer = 0;

		while (left <= right){
			int mid = (left + right) / 2;
			long target = Math.abs(pivot - cs[mid]);

			if (target > M){
				left = mid + 1;
			}else if (target < M){
				answer = target;
				right = mid - 1;
			}else{
				System.out.print(M);
				System.exit(0);
			}
		}

		return answer;
	}

	// binary search function for right area
	private static long rightBinarySearch(int left, int right, long pivot){

		long answer = 0;

		while (left <= right){
			int mid = (left + right) / 2;
			long target = Math.abs(pivot - cs[mid]);

			if (target > M){
				right = mid - 1;
			}else if (target < M){
				answer = target;
				left = mid + 1;
			}else{
				System.out.print(M);
				System.exit(0);
			}
		}

		return answer;
	}
}