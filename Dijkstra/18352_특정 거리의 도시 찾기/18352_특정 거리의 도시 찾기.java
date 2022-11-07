import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Edge>[] adjList = new List[N+1];
		for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
		int from = 0, to = 0;
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] distance = new int[N+1];
		for (int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;
		distance[X] = 0;
		StringBuilder sb = new StringBuilder("");

		// get map
		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, 1));
		}

		// do dijkstra
		pq.add(new Edge(X, 0));
		while (!pq.isEmpty()){

			Edge tmp = pq.poll();
			if (visited[tmp.to]) continue;
			visited[tmp.to] = true;

			for (Edge e: adjList[tmp.to]){
				if (!visited[e.to] && distance[tmp.to] + e.weight < distance[e.to]){
					distance[e.to] = distance[tmp.to] + e.weight;
					pq.add(new Edge(e.to, distance[e.to]));
				}
			}
		}

		// find answer
		for (int i = 1; i <= N; i++){
			if (distance[i] == K){
				sb.append(i).append('\n');
			}
		}

		// print answer and end program
		if (sb.length() == 0) System.out.println("-1");
		else System.out.print(sb);
		br.close();
		return;
	}
}

// Edge class
class Edge implements Comparable<Edge> {
	int to;
	int weight;
	public Edge(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge e){
		return weight - e.weight;
	}
}