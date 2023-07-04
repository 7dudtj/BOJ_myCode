import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // T is 1. And it is not used.
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int K = Integer.parseInt(tmp[2]);
        int answer = Integer.MAX_VALUE;
        int[][] memo = new int[N + 1][M + 1];
        List<Edge>[] adjList = new List[N + 1];
        for (int i = 0; i <= N; i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
            adjList[i] = new LinkedList<>();
        }
        for (int i = 0; i <= M; i++){
            memo[1][i] = 0;
        }
        Queue<Edge> pq = new PriorityQueue<>();
        int u = 0;
        int v = 0;
        int c = 0;
        int d = 0;
        Edge cur = null;
        int cost = 0;
        int time = 0;

        // Make adjList
        for (int i = 0; i < K; i++){
            tmp = br.readLine().split(" ");
            u = Integer.parseInt(tmp[0]);
            v = Integer.parseInt(tmp[1]);
            c = Integer.parseInt(tmp[2]);
            d = Integer.parseInt(tmp[3]);
            adjList[u].add(new Edge(v, c, d));
        }
        br.close();

        // Do dijkstra
        pq.add(new Edge(1, 0, 0));
        while (!pq.isEmpty()){
            // Get new Edge
            cur = pq.poll();
            if (answer <= memo[cur.adj][cur.cost]) continue;

            // Iterate adj nodes
            for (Edge e: adjList[cur.adj]){
                // Calculate cost
                cost = cur.cost + e.cost;
                if (cost > M) continue;

                // Calculate time
                time = memo[cur.adj][cur.cost] + e.time;
                if (answer <= time) continue;

                // Arrive at destination
                if (e.adj == N){
                    answer = time;
                    continue;
                }

                // Find next path
                if (time < memo[e.adj][cost]){
                    if (memo[e.adj][cost] == Integer.MAX_VALUE){
                        pq.add(new Edge(e.adj, cost, time));
                    }
                    memo[e.adj][cost] = time;
                }
            }
        }

        // Print answer and end program
        if (answer == Integer.MAX_VALUE){
            System.out.print("Poor KCM");
        }else{
            System.out.print(answer);
        }
        return;
    }
}

// Edge class
class Edge implements Comparable<Edge>{
    // Edge variables
    int adj;
    int cost;
    int time;

    // Edge constructor
    public Edge(int a, int c, int t){
        adj = a;
        cost = c;
        time = t;
    }

    // Compare function
    @Override
    public int compareTo(Edge e){
        return cost - e.cost;
    }
}