import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	// set static variables
	static int x, y, a, b;
	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		x = 0; y = 0; a = 0; b = 0;

		// build segment tree
		tree = new long[N * 4];
		init(1, N, 1);

		// do queries
		for (int q = 0; q < Q; q++){

			// get inputs
			st = new StringTokenizer(br.readLine(), " ");
			getInputs(st);

			// get sum (from x to y)
			sb.append(sum(1, N, 1, x, y) + "\n");

			// change value (ath value as b)
			update(1, N, 1, a, b);
		}

		// print answer and end program
		System.out.print(sb);
		br.close();
		return;
	}


	// get inputs of query
	private static void getInputs(StringTokenizer st){
		
		// set needed variables
		int tmpx = 0;
		int tmpy = 0;

		// get x and y
		tmpx = Integer.parseInt(st.nextToken());
		tmpy = Integer.parseInt(st.nextToken());
		if (tmpx > tmpy){
			x = tmpy;
			y = tmpx;
		}else{
			x = tmpx;
			y = tmpy;
		}

		// get a and b
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		return;
	}


	// init segment tree
	private static long init(int start, int end, int node){

		// approach leaf
		if (start == end){
			return tree[node] = arr[start];
		}

		// not leaf
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}


	// get sum
	private static long sum(int start, int end, int node, int left, int right){

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


	// update value
	private static long update(int start, int end, int node, int idx, int val){

		// out of range
		if (idx < start || end < idx){
			return tree[node];
		}

		// update leaf node
		if (start == end){
			return tree[node] = val;
		}

		// update branch
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
	}
}