import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main{
    // Set needed static variables
    static int N = 0;
    static List<Edge>[] adjList = null;
    static int[] heights = null;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        heights = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++){
            adjList[i] = new LinkedList<>();
        }

        // Get map
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            adjList[from].add(new Edge(to, distance));
            adjList[to].add(new Edge(from, distance));
        }
        br.close();

        // Do dijkstra for asc and desc
        long[] ascDistance = dijkstra(1);
        long[] descDistance = dijkstra(N);

        // Find maximum value
        long value = Long.MIN_VALUE;
        for (int i = 2; i <= N - 1; i++){
            if (ascDistance[i] != Long.MAX_VALUE && descDistance[i] != Long.MAX_VALUE){
                value = Math.max(value, E * heights[i] - D * (ascDistance[i] + descDistance[i]));
            }
        }

        // Print answer and end program
        if (value == Long.MIN_VALUE){
            System.out.print("Impossible");
        }else{
            System.out.print(value);
        }
        return;
    }

    // Dijkstra function
    private static long[] dijkstra(int start){
        // Set needed variables for dijkstra
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[] distanceList = new long[N + 1];
        for (int i = 1; i <= N; i++){
            distanceList[i] = Long.MAX_VALUE;
        }

        // Do dijkstra
        pq.add(new Edge(start, 0));
        distanceList[start] = 0;
        while (!pq.isEmpty()){
            // Get new Edge
            Edge cur = pq.poll();
            if (cur.weight > distanceList[cur.adj]) continue;

            // Search neighbors
            for (Edge e: adjList[cur.adj]){
                if (heights[cur.adj] < heights[e.adj] && distanceList[cur.adj] + e.weight < distanceList[e.adj]){
                    distanceList[e.adj] = distanceList[cur.adj] + e.weight;
                    pq.add(new Edge(e.adj, distanceList[e.adj]));
                }
            }
        }

        return distanceList;
    }
}

// Edge class
class Edge implements Comparable<Edge>{
    // Edge variables
    int adj;
    long weight;
    // Edge constructor
    public Edge(int a, long w){
        adj = a;
        weight = w;
    }
    // Edge compare function
    @Override
    public int compareTo(Edge e){
        if (weight <= e.weight){
            return -1;
        }else{
            return 1;
        }
    }
}