import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    // Set needed static variables
    static int M = 0;
    static int N = 0;
    static int[][] map = null;
    static boolean[][] visited = null;
    static Queue<Tomato> q = null;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        int answer = 0;

        // Get map
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // Check if all tomatoes are ripen
        if (checkRipen()){
            System.out.print(answer);
            return;
        }

        // Find ripe tomatoes
        findRipeTomatoes();

        // Do bfs to ripe all tomatoes
        while (!q.isEmpty()){
            // Get tomato
            Tomato t = q.poll();

            // Ripe neighbor tomatoes
            for (int d = 0; d < 4; d++){
                int ni = t.i + di[d];
                int nj = t.j + dj[d];

                if (!inRange(ni, nj)) continue;

                if (!visited[ni][nj] && map[ni][nj] ==0){
                    visited[ni][nj] = true;
                    map[ni][nj] = t.day + 1;
                    q.add(new Tomato(ni, nj, map[ni][nj]));
                }
            }
        }
        
        // Find answer
        answer = findAnswer();

        // Print answer and end program
        System.out.print(answer);
        return;
    }

    // Find answer
    private static int findAnswer(){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] > max){
                    max = map[i][j];
                }
                if (map[i][j] == 0){
                    return -1;
                }
            }
        }
        
        return max - 1;
    }

    // Check if this location is in range
    private static boolean inRange(int i, int j){
        return (0 <= i && i < N && 0 <= j && j < M) ? true : false;
    }

    // Find tomatoes and push to queue
    private static void findRipeTomatoes(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1){
                    q.add(new Tomato(i, j, 1));
                    visited[i][j] = true;
                }
            }
        }
    }

    // Check if all tomates are ripen
    private static boolean checkRipen(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}

// Tomato class
class Tomato{
    // Tomato variables
    int i;
    int j;
    int day;
    // Tomato constructor
    public Tomato(int i, int j, int day){
        this.i = i;
        this.j = j;
        this.day = day;
    }
}