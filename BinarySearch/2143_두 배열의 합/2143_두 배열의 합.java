import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Main{

	// set static variables

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		long T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] A = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		long[] B = new long[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());
		int aCount = (n * (n+1)) / 2;
		int bCount = (m * (m+1)) / 2;
		long[] aList = new long[aCount];
		long[] tmpbList = new long[bCount];
		long tmp = 0, answer = 0, target = 0;
		int left = 0, right = 0, mid = 0;

		// make aList & bList
		aCount = 0;
		for (int i = 0; i < n; i++){
			tmp = A[i];
			aList[aCount] = tmp;
			aCount++;
			for (int j = i+1; j < n; j++){
				tmp += A[j];
				aList[aCount] = tmp;
				aCount++;
			}
		}
		bCount = 0;
		for (int i = 0; i < m; i++){
			tmp = B[i];
			tmpbList[bCount] = tmp;
			bCount++;
			for (int j = i+1; j < m; j++){
				tmp += B[j];
				tmpbList[bCount] = tmp;
				bCount++;
			}
		}
		Arrays.sort(aList);
		Arrays.sort(tmpbList);

		// process bList
		ArrayList<Long> bList = new ArrayList<>();
		HashMap<Long, Long> bMap = new HashMap<>();
		long prev = tmpbList[0];
		long count = 0;

		for (int i = 0; i < bCount; i++){
			
			if (tmpbList[i] != prev){
				bList.add(prev);
				bMap.put(prev, count);
				prev = tmpbList[i];
				count = 1;
			}else count++;
		}
		bList.add(prev);
		bMap.put(prev, count);

		// main process
		for (int i = 0; i < aCount; i++){

			// set variables
			target = T - aList[i];
			left = 0;
			right = bList.size()-1;
			
			// binary search
			while (left <= right){

				mid = (left + right)/2;

				// find answer
				if (bList.get(mid) == target){
					answer += bMap.get(target);
					break;
				}

				// not find answer
				if (bList.get(mid) < target){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}
		}

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}
}