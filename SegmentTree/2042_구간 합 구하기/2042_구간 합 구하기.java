import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	// set static variables
	static long[] arr, tree;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++){
			arr[i] = Long.parseLong(br.readLine());
		}

		// init tree
		tree = new long[N * 4];
		init(1, N, 1);

		// do queries
		int a = 0, b = 0;
		long c = 0;
		StringBuilder sb = new StringBuilder();

		for (int q = 0; q < M + K; q++){

			// get inputs
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());

			// case 1: modify
			if (a == 1){
				update(1, N, 1, b, c);
			}

			// case 2: get sum
			else{
				sb.append(sum(1, N, 1, b, c) + "\n");
			}
		}

		// print answer and end program
		System.out.print(sb);
		br.close();
		return;
	}


	// init tree
	private static long init(int start, int end, int node){

		// find leaf
		if (start == end){
			return tree[node] = arr[start];
		}

		// not a leaf
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}


	private static long update(int start, int end, int node, int idx, long val){

		// out of range
		if (idx < start || end < idx) return tree[node];

		// find leaf
		if (start == end) return tree[node] = val;

		// update branch
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
	}

	// get sum
	private static long sum(int start, int end, int node, long left, long right){

		// out of range
		if (end < left || right < start){
			return 0;
		}

		// in range
		if (left <= start && end <= right){
			return tree[node];
		}

		// else
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
}