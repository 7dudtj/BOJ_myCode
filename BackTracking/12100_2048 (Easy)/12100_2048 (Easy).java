\import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    // Set needed static variables
    static int N = 0;
    static int[][] board = null;
    static int answer = 0;
    static int[][] copyBoard = null;

    public static void main(String[] args) throws IOException{
        // Set needed vairables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // Get board
        for (int i = 0; i < N; i++){
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        br.close();

        // Do game by backtracking
        getBoardCopy();
        bt(0);

        // Print answer and end program
        System.out.println(answer);
        return;
    }

    // Function for moving board by selected direction
    private static void moveBoard(int dir){
        // dir: 0-up, 1-right, 2-down, 3-left
        if (dir == 0){
            moveUp();
        }else if (dir == 1){
            moveRight();
        }else if (dir == 2){
            moveDown();
        }else{
            moveLeft();
        }
    }

    // Function for moving board by up direction
    private static void moveUp(){
        Queue<Integer> q = new LinkedList<>();
        int prev = -1;
        for (int j = 0; j < N; j++){
            // Collect data
            for (int i = 0; i < N; i++){
                if (board[i][j] != 0){
                    if (prev == -1){
                        prev = board[i][j];
                    }else{
                        if (prev == board[i][j]){
                            q.add(prev * 2);
                            prev = -1;
                        }else{
                            q.add(prev);
                            prev = board[i][j];
                        }
                    }
                }
            }
            if (prev != -1){
                q.add(prev);
                prev = -1;
            }
            // Reallocate data
            for (int i = 0; i < N; i++){
                board[i][j] = !q.isEmpty() ? q.poll() : 0;
            }
        }
    }

    // Function for moving board by right direction
    private static void moveRight(){
        Queue<Integer> q = new LinkedList<>();
        int prev = -1;
        for (int i = 0; i < N; i++){
            // Collect data
            for (int j = N - 1; j >= 0; j--){
                if (board[i][j] != 0){
                    if (prev == -1){
                        prev = board[i][j];
                    }else{
                        if (prev == board[i][j]){
                            q.add(prev * 2);
                            prev = -1;
                        }else{
                            q.add(prev);
                            prev = board[i][j];
                        }
                    }
                }
            }
            if (prev != -1){
                q.add(prev);
                prev = -1;
            }
            // Reallocate data
            for (int j = N - 1; j >= 0; j--){
                board[i][j] = !q.isEmpty() ? q.poll() : 0;
            }
        }
    }

    // Function for moving board by down direction
    private static void moveDown(){
        Queue<Integer> q = new LinkedList<>();
        int prev = -1;
        for (int j = 0; j < N; j++){
            // Collect data
            for (int i = N - 1; i >= 0; i--){
                if (board[i][j] != 0){
                    if (prev == -1){
                        prev = board[i][j];
                    }else{
                        if (prev == board[i][j]){
                            q.add(prev * 2);
                            prev = -1;
                        }else{
                            q.add(prev);
                            prev = board[i][j];
                        }
                    }
                }
            }
            if (prev != -1){
                q.add(prev);
                prev = -1;
            }
            // Reallocate data
            for (int i = N - 1; i >= 0; i--){
                board[i][j] = !q.isEmpty() ? q.poll() : 0;
            }
        }
    }

    // Function for moving board by left direction
    private static void moveLeft(){
        Queue<Integer> q = new LinkedList<>();
        int prev = -1;
        for (int i = 0; i < N; i++){
            // Collect data
            for (int j = 0; j < N; j++){
                if (board[i][j] != 0){
                    if (prev == -1){
                        prev = board[i][j];
                    }else{
                        if (prev == board[i][j]){
                            q.add(prev * 2);
                            prev = -1;
                        }else{
                            q.add(prev);
                            prev = board[i][j];
                        }
                    }
                }
            }
            if (prev != -1){
                q.add(prev);
                prev = -1;
            }
            // Reallocate data
            for (int j = 0; j < N; j++){
                board[i][j] = !q.isEmpty() ? q.poll() : 0;
            }
        }
    }

    // Get copy of board
    private static void getBoardCopy(){
        copyBoard = board;
    }

    // Function for doing game by backtracking 
    private static void bt(int count){
        // Find answer and end backtracking
        if (count == 5){
            searchAnswer();
            return;
        }

        // Copy board to tmp
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++){
            tmp[i] = board[i].clone();
        }
        
        // Move for every direction by backtracking
        for (int i = 0; i < 4; i++){
            moveBoard(i);
            bt(count + 1);
            for (int j = 0; j < N; j++){
                board[j] = tmp[j].clone();
            }
        }
    }

    // Function for searching answer
    private static void searchAnswer(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (board[i][j] > answer){
                    answer = board[i][j];
                }
            }
        }
    }
}