import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    // Set needed static variables
    static int N = 0;
    static int L = 0;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int answer = 0;

        // Get map
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // Calculate answer
        int[] tmp = null;
        for (int i = 0; i < N; i++){
            // Check row road
            tmp = new int[N];
            for (int j = 0; j < N; j++){
                tmp[j] = map[i][j];
            }
            answer += checkRoad(tmp);
            // Check col road
            tmp = new int[N];
            for (int j = 0; j < N; j++){
                tmp[j] = map[j][i];
            }
            answer += checkRoad(tmp);
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }

    // Check if this road is crossable
    private static int checkRoad(int[] road){
        boolean possible = true;
        int[] construct = new int[N];

        // Search road
        int prev = road[0];
        for (int i = 1; i < N; i++){
            // Go same
            if (prev == road[i]){
                prev = road[i];
            }
            // Go up
            else if (prev + 1 == road[i]){
                if (i - L < 0){
                    possible = false;
                    break;
                }else{
                    for (int j = i - L; j < i; j++){
                        if (road[j] != prev || construct[j] == 1){
                            possible = false;
                        }
                    }
                    if (!possible){
                        break;
                    }else{
                        prev = road[i];
                        for (int j = i - L; j < i; j++){
                            construct[j] = 1;
                        }
                    }
                }
            }
            // Go down
            else if (prev - 1 == road[i]){
                if (i + L - 1 >= N){
                    possible = false;
                    break;
                }else{
                    for (int j = i; j < i + L; j++){
                        if (road[j] != road[i] || construct[j] == 1){
                            possible = false;
                        }
                    }
                    if (!possible){
                        break;
                    }else{
                        prev = road[i];
                        for (int j = i; j < i + L; j++){
                            construct[j] = 1;
                        }
                    }
                }
            }
            // Cannot move
            else{
                possible = false;
                break;
            }
        }

        return possible ? 1 : 0;
    }
}