import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    // Set needed static variables
    static int N = 0;
    static int M = 0;
    static char[][] map = null;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited = null;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int answer = 0;

        // Get map
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        br.close();

        // Do simulation
        while (countCheese() > 0){
            answer++;

            checkMap();

            deleteCheese();
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }

    // Delete cheeses
    private static void deleteCheese(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == '1'){
                    if (delTarget(i, j)){
                        map[i][j] = 2;
                    }
                }
            }
        }
    }

    // Check if this cheese has to be deleted
    private static boolean delTarget(int i, int j){
        int count = 0;
        boolean delete = false;
        for (int n = 0; n < 4; n++){
            int nx = i + dx[n];
            int ny = j + dy[n];

            if (!inRange(nx, ny)) continue;

            if (map[nx][ny] == '2') count++;
        }
        if (count >= 2) delete = true;

        return delete;
    }

    // Check map info
    private static void checkMap(){
        visited = new boolean[N][M];
        map[0][0] = '2';
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (!visited[i][j]){
                    dobfs(i, j);
                }
            }
        }
    }

    // Bfs function
    private static void dobfs(int i, int j){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j, map[i][j]));
        visited[i][j] = true;
        while (!q.isEmpty()){
            Node cur = q.poll();

            for (int n = 0; n < 4; n++){
                int nx = cur.i + dx[n];
                int ny = cur.j + dy[n];

                if (!inRange(nx, ny)) continue;

                if (!visited[nx][ny] && map[nx][ny] != '1' && cur.v == '2'){
                    map[nx][ny] = '2';
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, map[nx][ny]));
                }
            }
        }
    }

    // Check node is in map
    private static boolean inRange(int i, int j){
        return (0 <= i && i < N && 0 <= j && j < M);
    }

    // Check number of cheeses
    private static int countCheese(){
        int answer = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == '1'){
                    answer++;
                }
            }
        }
        return answer;
    }
}

// Node class
class Node{
    // Node variables
    int i;
    int j;
    char v;

    // Node constructor
    public Node(int i, int j, char v){
        this.i = i;
        this.j = j;
        this.v = v;
    }
}