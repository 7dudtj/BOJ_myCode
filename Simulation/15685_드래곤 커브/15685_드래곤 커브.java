import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    // Set needed static variables
    static int[][] map = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        // Draw dragon curve
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x, y));
            drawDragonCurve(q, new Node(x + dx[d], y + dy[d]), g, 0);
        }
        br.close();

        // Print answer and end program
        System.out.print(calculateAnswer());
        return;
    }

    // Draw dragon curve
    private static void drawDragonCurve(Queue<Node> q, Node end, int tg, int cg){
        // Finish drawing
        if (tg == cg){
            while (!q.isEmpty()){
                Node cur = q.poll();
                map[cur.y][cur.x] = 1;
            }
            map[end.y][end.x] = 1;
            return;
        }

        // Calculate new generation
        Queue<Node> nq = new LinkedList<>();
        Node first = q.poll();
        Node last = translate(first, end);
        nq.add(first);
        nq.add(end);
        while (!q.isEmpty()){
            Node cur = q.poll();
            nq.add(translate(cur, end));
            nq.add(cur);
        }

        // Move to next generation
        drawDragonCurve(nq, last, tg, cg + 1);
    }

    // Translate Node 90 degrees by end Node
    private static Node translate(Node target, Node criteria){
        // Function variables
        int xdiff = target.x - criteria.x;
        int ydiff = target.y - criteria.y;
        int nx = -1;
        int ny = -1;

        // From 1 quadrant to 4 quadrant
        if (xdiff >= 0 && ydiff < 0){
            nx = criteria.x + Math.abs(ydiff);
            ny = criteria.y + Math.abs(xdiff);
        }
        // From 2 quadrant to 1 quadrant
        else if (xdiff < 0 && ydiff <= 0){
            nx = criteria.x + Math.abs(ydiff);
            ny = criteria.y - Math.abs(xdiff);
        }
        // From 3 quadrant to 2 quadrant
        else if (xdiff <= 0 && ydiff > 0){
            nx = criteria.x - Math.abs(ydiff);
            ny = criteria.y - Math.abs(xdiff);
        }
        // From 4 quadrant to 3 quadrant
        else if (xdiff > 0 && ydiff >= 0){
            nx = criteria.x - Math.abs(ydiff);
            ny = criteria.y + Math.abs(xdiff);
        }

        return new Node(nx, ny);
    }

    // Calculate answer
    private static int calculateAnswer(){
        int count = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (map[i][j] == 1 && map[i + 1][j] == 1 && 
                    map[i][j + 1] == 1 && map[i + 1][j + 1] == 1){
                        count++;
                    }
            }
        }
        return count;
    }
}

// Node class
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}