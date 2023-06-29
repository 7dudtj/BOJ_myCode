import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    // Set needed static variables
    static int N = 0;
    static int answer = Integer.MAX_VALUE;
    static int[][][] mirror = null;
    static char[][] map = null;
    static int startX = -1;
    static int startY = -1;
    static int endX = -1;
    static int endY = -1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mirror = new int[N][N][4];
        map = new char[N][N];
        String tmp = null;
        boolean findStart = false;

        // Get map
        for (int i = 0; i < N; i++){
            tmp = br.readLine();
            map[i] = tmp.toCharArray();
        }
        br.close();

        // Initialize mirror
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < 4; k++){
                    mirror[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // Find start & end point
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == '#' && !findStart){
                    findStart = true;
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                }else if (map[i][j] == '#' && findStart){
                    endX = i;
                    endY = j;
                    map[i][j] = '.';
                }
            }
        }

        // Do bfs
        bfs();

        // Print answer and end program
        System.out.print(answer);
        return;
    }

    // Bfs function
    private static void bfs(){
        // Set needed variables
        Queue<Node> q = new LinkedList<>();

        // Push start node to queue
        for (int i = 0; i < 4; i++){
            q.add(new Node(startX, startY, i, 0));
        }
        
        // Do bfs
        while (!q.isEmpty()){
            // Poll node
            Node cur = q.poll();

            // Reach end point
            if (cur.x == endX && cur.y == endY){
                if (answer > cur.count){
                    answer = cur.count;
                }
            }

            // Move to next point
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            int ndir = cur.dir;
            if (!checkAvailablePoint(nx, ny)) continue;

            // Check next point
            if (mirror[nx][ny][ndir] > cur.count){
                mirror[nx][ny][ndir] = cur.count;
                q.add(new Node(nx, ny, ndir, cur.count));
            }

            // If that point is '!'
            if (map[nx][ny] == '!'){
                // Install / mirror
                if (cur.dir == 0) ndir = 3;
                else if (cur.dir == 1) ndir = 2;
                else if (cur.dir == 2) ndir = 1;
                else if (cur.dir == 3) ndir = 0;
                if (mirror[nx][ny][ndir] > cur.count + 1){
                    mirror[nx][ny][ndir] = cur.count + 1;
                    q.add(new Node(nx, ny, ndir, cur.count + 1));
                }

                // Install \ mirror
                if (cur.dir == 0) ndir = 1;
                else if (cur.dir == 1) ndir = 0;
                else if (cur.dir == 2) ndir = 3;
                else if (cur.dir == 3) ndir = 2;
                if (mirror[nx][ny][ndir] > cur.count + 1){
                    mirror[nx][ny][ndir] = cur.count + 1;
                    q.add(new Node(nx, ny, ndir, cur.count + 1));
                }
            }
        }

        return;
    }

    // Check available point
    private static boolean checkAvailablePoint(int x, int y){
        if (0 <= x && x < N && 0 <= y && y < N && map[x][y] != '*') return true;
        return false;
    }
}

// Node class
class Node{
    // Node variables
    int x;
    int y;
    int dir;
    int count;

    // Node constructor
    public Node(int x, int y, int dir, int count){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
} {
    
}
