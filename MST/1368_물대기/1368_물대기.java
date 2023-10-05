import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main{
    // Set needed static variables
    static Node[] nodes = null;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Edge> pq = new PriorityQueue<>();
        nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++){
            nodes[i] = new Node(i, 1);
        }
        int numEdge = 0;
        int cost = 0;

        // Get edges from power supply
        for (int i = 1; i <= N; i++){
            pq.add(new Edge(0, i, Integer.parseInt(br.readLine())));
        }

        // Get edges between nodes
        for (int i = 1; i <= N; i++){
            String[] tmp = br.readLine().split(" ");
            for (int j = i + 1; j <= N; j++){
                pq.add(new Edge(i, j, Integer.parseInt(tmp[j - 1])));
            }
        }
        br.close();

        // Do MST
        while (numEdge < N){
            Edge cur = pq.poll();

            if (find(cur.node1) != find(cur.node2)){
                union(cur.node1, cur.node2);
                cost += cur.weight;
                numEdge++;
            }
        }

        // Print answer and end program
        System.out.print(cost);
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
    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (nodes[a].depth > nodes[b].depth){
            nodes[b].parent = a;
        }else if (nodes[a].depth < nodes[b].depth){
            nodes[a].parent = b;
        }else{
            nodes[b].parent = a;
            nodes[a].depth++;
        }
    }
}

// Edge class
class Edge implements Comparable<Edge>{
    // Edge variables
    int node1;
    int node2;
    int weight;
    // Edge constructor
    public Edge(int n1, int n2, int w){
        node1 = n1;
        node2 = n2;
        weight = w;
    }
    // Compare function
    @Override
    public int compareTo(Edge e){
        return weight - e.weight;
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