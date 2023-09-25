import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main{
    // Set needed static variables
    static Node[] nodes = null;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int minimumCost = 0;
        int edgeNum = 0;
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++){
            nodes[i] = new Node(i, 1);
        }

        // Get edges
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        br.close();

        // Calculate minimum cost
        while (!pq.isEmpty() && edgeNum < N - 1){
            Edge cur = pq.poll();
            int n1 = cur.node1;
            int n2 = cur.node2;
            
            if (find(n1) != find(n2)){
                union(n1, n2);
                minimumCost += cur.cost;
                edgeNum++;
            }
        }

        // Print answer and end program
        System.out.print(minimumCost);
        return;
    }

    // Find function
    private static int find(int n){
        if (nodes[n].parent == n){
            return n;
        }
        return nodes[n].parent = find(nodes[n].parent);
    }

    // Union function
    private static void union(int n1, int n2){
        // Check if n1 & n2 can do union
        n1 = find(n1);
        n2 = find(n2);
        if (n1 == n2){
            return;
        }

        // Union n1 & n2
        int n1Depth = nodes[n1].depth;
        int n2Depth = nodes[n2].depth;
        if (n1Depth > n2Depth){
            nodes[n2].parent = n1;
        }else if (n1Depth < n2Depth){
            nodes[n1].parent = n2;
        }else{
            nodes[n2].parent = n1;
            nodes[n1].depth++;
        }
    }
}

// Edge class
class Edge implements Comparable<Edge>{
    // Edge variables
    int node1;
    int node2;
    int cost;
    // Edge constructor
    public Edge(int n1, int n2, int c){
        node1 = n1;
        node2 = n2;
        cost = c;
    }
    // Edge compare function
    @Override
    public int compareTo(Edge e){
        return cost - e.cost;
    }
}

// Node class
class Node{
    // Node variables
    int parent;
    int depth;
    // Node constructor
    public Node(int p, int d){
        parent = p;
        depth = d;
    }
}