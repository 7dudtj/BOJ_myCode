import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int money = 0, d = 0, p = 0;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		Lecture tmp = null;

		// get data
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			pq.add(new Lecture(p, d));
		}

		// do search
		while (!pq.isEmpty()){
			tmp = pq.poll();
			
			if (q.size() < tmp.d) q.add(tmp.p);
			else{
				if (tmp.p > q.peek()){
					q.poll();
					q.add(tmp.p);
				}
			}
		}

		// calculate money
		while (!q.isEmpty()) money += q.poll();
		
		// print answer and end program
		System.out.print(money);
		br.close();
		return;
	}
}

// lecture class
class Lecture implements Comparable<Lecture>{
	int p;
	int d;
	public Lecture(int p, int d){
		this.p = p;
		this.d = d;
	}
	@Override
	public int compareTo(Lecture l){
		if (d == l.d) return l.p - p;
		else return d - l.d;
	}
}