import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	// set static variables
	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a = 0, b = 0, c = 0, tmp = 0;
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) arr[i] = 0;
		tree = new long[N * 4];
		for (int i = 1; i <= N * 4 - 1; i++) tree[i] = 0;
		StringBuilder sb = new StringBuilder();

		// init tree
		init(1, N, 1);

		// do queries
		for (int q = 0; q < M; q++){

			// get query
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			// case 1. Sum
			if (a == 0){

				if (c < b){
					tmp = c;
					c = b;
					b = tmp;
				}
				sb.append(sum(1, N, 1, b, c) + "\n");
			}

			// case 2. Modify
			else{
				modify(1, N, 1, b, c);
			}
		}

		// print answer and end program
		System.out.print(sb);
		br.close();
		return;
	}

	// segment tree init
	private static long init(int start, int end, int node){

		// if node is a leaf
		if (start == end){
			return tree[node] = arr[start];
		}

		// if node is not a leaf
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	// get sum from bth to cth
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

	// modify bth value to c
	private static long modify(int start, int end, int node, int idx, int value){

		// out of range
		if (idx < start || end < idx){
			return tree[node];
		}

		// if node is a leaf
		if (start == end){
			return tree[node] = value;
		}

		// else
		int mid = (start + end) / 2;
		return tree[node] = modify(start, mid, node * 2, idx, value) + modify(mid + 1, end, node * 2 + 1, idx, value);
	}
}