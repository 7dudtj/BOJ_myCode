import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main{
    // Set needed static variables
    static int[][] A = new int[101][101];
    static int[] idxList = new int[101];
    static Queue<Node> pq = new PriorityQueue<>();
    static int rowLen = 3;
    static int colLen = 3;

    public static void main(String[] args) throws IOException{
        // Set needed vairables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        // Get A
        for (int i = 1; i <= 3; i++){
            input = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++){
                A[i][j] = Integer.parseInt(input[j - 1]);
            }
        }
        br.close();

        // Do calculation
        int numCal = 0;
        boolean findAnswer = false;
        while (numCal <= 100){
            // Check if A[r][c] == k
            if (A[r][c] == k){
                findAnswer = true;
                break;
            }

            // Do R calculation
            if (colLen >= rowLen){
                doCalculationR();
            }
            // Do C calculation
            else{
                doCalculationC();
            }
            
            numCal++;
        }

        // Print answer and end program
        System.out.print(findAnswer == true ? numCal : -1);
        return;
    }

    // Reset idxList & priority queue (data structures)
    private static void resetDS(){
        pq.clear();
        for (int i = 1; i <= 100; i++){
            idxList[i] = 0;
        }
    }

    // R calculation function
    private static void doCalculationR(){
        int maxRowNum = Integer.MIN_VALUE;
        for (int i = 1; i <= colLen; i++){
            // Reset data structures
            resetDS();
            // Get A informations
            for (int j = 1; j <= 100; j++){
                if (A[i][j] != 0){
                    idxList[A[i][j]]++;
                    A[i][j] = 0;
                }
            }
            // Sort data
            for (int idx = 1; idx <= 100; idx++){
                if (idxList[idx] != 0){
                    pq.add(new Node(idx, idxList[idx]));
                }
            }
            // Make new A by sorted data
            int numData = 0;
            while (!pq.isEmpty() && numData < 50){
                Node cur = pq.poll();
                numData++;
                A[i][numData * 2 - 1] = cur.num;
                A[i][numData * 2] = cur.count;
            }
            // Check if maximum row number is made
            if (numData * 2 > maxRowNum){
                maxRowNum = numData * 2;
            }
        }
        rowLen = maxRowNum;
    }

    // C calculation function
    private static void doCalculationC(){
        int maxColNum = Integer.MIN_VALUE;
        for (int j = 1; j <= rowLen; j++){
            // Reset data structures
            resetDS();
            // Get A informations
            for (int i = 1; i <= 100; i++){
                if (A[i][j] != 0){
                    idxList[A[i][j]]++;
                    A[i][j] = 0;
                }
            }
            // Sort data
            for (int idx = 1; idx <= 100; idx++){
                if (idxList[idx] != 0){
                    pq.add(new Node(idx, idxList[idx]));
                }
            }
            // Make new A by sorted data
            int numData = 0;
            while (!pq.isEmpty() && numData < 50){
                Node cur = pq.poll();
                numData++;
                A[numData * 2 - 1][j] = cur.num;
                A[numData * 2][j] = cur.count;
            }
            // Check if maximum col number is made
            if (numData * 2 > maxColNum){
                maxColNum = numData * 2;
            }
        }
        colLen = maxColNum;
    }
}

// Node class
class Node implements Comparable<Node>{
    // Node variables
    int num;
    int count;
    // Node constructor
    public Node(int n, int c){
        num = n;
        count = c;
    }
    // Node compare function
    @Override
    public int compareTo(Node n){
        if (count == n.count){
            return num - n.num;
        }else{
            return count - n.count;
        }
    }
}