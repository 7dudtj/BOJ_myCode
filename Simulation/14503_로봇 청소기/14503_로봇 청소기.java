import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    // Set needed static variables
    static int N = -1;
    static int M = -1;
    static int r = -1;
    static int c = -1;
    static int d = -1;
    static int[][] map = null;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int numClean = 0;

        // Get map
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // Clean room
        while (true){
            // Step 1: Clean current room
            if (map[r][c] == 0){
                map[r][c] = 2;
                numClean++;
            }
            // Step 2: Room which needs cleaning does not exist nearby
            if (!dirtyRoomExistNearby(r, c)){
                // Step 2-1: Move back
                if (canMoveBack(r, c)){
                    moveBack(r, c);
                }
                // Step 2-2: Stop working
                else{
                    break;
                }
            }
            // Step 3: Room which needs cleaning exists nearby
            else{
                // Step 3-1: Ratate 90 degrees counterclockwise
                rotate90CC();
                // Step 3-2: Move front if front room is dirty room
                if (canMoveFront(r, c)){
                    moveFront(r, c);
                }
            }
        }

        // Print answer and end program
        System.out.print(numClean);
        return;
    }

    // Rotating robot 90 degrees counterclockwise
    private static void rotate90CC(){
        d = (d + 3) % 4;
    }

    // Check if robot can move front
    private static boolean canMoveFront(int row, int col){
        int nRow = row + di[d];
        int nCol = col + dj[d];
        if (inRoom(nRow, nCol) && map[nRow][nCol] == 0){
            return true;
        }else{
            return false;
        }
    }

    // Move robot to front
    private static void moveFront(int row, int col){
        r = row + di[d];
        c = col + dj[d];
    }

    // Check if robot can move back
    private static boolean canMoveBack(int row, int col){
        int backDir = getBackDirection(d);
        int nRow = row + di[backDir];
        int nCol = col + dj[backDir];
        if (inRoom(nRow, nCol) && map[nRow][nCol] != 1){
            return true;
        }else{
            return false;
        }
    }

    // Move robot to back
    private static void moveBack(int row, int col){
        int backDir = getBackDirection(d);
        r = row + di[backDir];
        c = col + dj[backDir];
    }

    // Get back direction
    private static int getBackDirection(int dir){
        return (dir + 2) % 4;
    }

    // Check if dirty room exists nearby of current room
    private static boolean dirtyRoomExistNearby(int row, int col){
        boolean exist = false;

        for (int dir = 0; dir < 4; dir++){
            int nRow = row + di[dir];
            int nCol = col + dj[dir];
            if (inRoom(nRow, nCol) && map[nRow][nCol] == 0){
                exist = true;
                break;
            }    
        }

        return exist;
    }

    // Check if current room locates in map
    private static boolean inRoom(int row, int col){
        return (0 <= row && row < N && 0 <= col && col < M);
    }
}