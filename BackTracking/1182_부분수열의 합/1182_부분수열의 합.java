import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    // Set needed static variables
    static int answer = 0;
    static int[] arr = null;
    static boolean[] visited = null;
    static int N = 0;
    static int S = 0;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        // Get array
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // Do backtracking
        for (int i = 1; i <= N; i++){
            bt(i, 0, 0);
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }

    // Back tracking function
    private static void bt(int total, int cur, int loc){
        // Collect all items
        if (total == cur){
            if (count() == S){
                answer++;
            }
            return;
        }

        // Abort condition
        if (loc == N){
            return;
        }

        // Do backtracking
        for (int i = loc; i < N; i++){
            visited[i] = true;
            bt(total, cur + 1, i + 1);
            visited[i] = false;
        }
    }

    // Count sum
    private static int count(){
        int answer = 0;
        for (int i = 0; i < N; i++){
            if (visited[i]){
                answer += arr[i];
            }
        }
        return answer;
    }
}