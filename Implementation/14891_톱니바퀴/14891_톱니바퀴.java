import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    // Set needed static variables
    static char[][] wheels = new char[4][];

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels[0] = br.readLine().toCharArray();
        wheels[1] = br.readLine().toCharArray();
        wheels[2] = br.readLine().toCharArray();
        wheels[3] = br.readLine().toCharArray();
        int K = Integer.parseInt(br.readLine());

        // Do rotate
        for (int i = 0; i < K; i++){
            String[] input = br.readLine().split(" ");
            int wheelNum = Integer.parseInt(input[0]) - 1;
            int rotateDir = Integer.parseInt(input[1]);
            selectWheel(wheelNum, rotateDir);
        }
        br.close();
        
        // Print answer and end program
        System.out.print(countTotalScore());
        return;
    }

    // Rotate wheel
    private static void selectWheel(int wn, int rd){
        // Select wheel 0
        if (wn == 0){
            if (wheels[0][2] == wheels[1][6]){
                rotateWheel(wn, rd);
            }else{
                if (wheels[1][2] == wheels[2][6]){
                    rotateWheel(wn, rd);
                    rotateWheel(1, flipRotateDir(rd));
                }else{
                    if (wheels[2][2] == wheels[3][6]){
                        rotateWheel(wn, rd);
                        rotateWheel(1, flipRotateDir(rd));
                        rotateWheel(2, rd);
                    }else{
                        rotateWheel(wn, rd);
                        rotateWheel(1, flipRotateDir(rd));
                        rotateWheel(2, rd);
                        rotateWheel(3, flipRotateDir(rd));
                    }
                }
            }
        }
        // Select wheel 1
        else if (wn == 1){
            if (wheels[0][2] != wheels[1][6]){
                rotateWheel(0, flipRotateDir(rd));
            }
            if (wheels[1][2] == wheels[2][6]){
                rotateWheel(wn, rd);
            }else{
                if (wheels[2][2] == wheels[3][6]){
                    rotateWheel(wn, rd);
                    rotateWheel(2, flipRotateDir(rd));
                }else{
                    rotateWheel(wn, rd);
                    rotateWheel(2, flipRotateDir(rd));
                    rotateWheel(3, rd);
                }
            }
        }
        // Select wheel 2
        else if (wn == 2){
            if (wheels[2][2] != wheels[3][6]){
                rotateWheel(3, flipRotateDir(rd));
            }
            if (wheels[1][2] == wheels[2][6]){
                rotateWheel(wn, rd);
            }else{
                if (wheels[0][2] == wheels[1][6]){
                    rotateWheel(wn, rd);
                    rotateWheel(1, flipRotateDir(rd));
                }else{
                    rotateWheel(wn, rd);
                    rotateWheel(1, flipRotateDir(rd));
                    rotateWheel(0, rd);
                }
            }
        }
        // Select wheel 3
        else{
            if (wheels[2][2] == wheels[3][6]){
                rotateWheel(wn, rd);
            }else{
                if (wheels[1][2] == wheels[2][6]){
                    rotateWheel(wn, rd);
                    rotateWheel(2, flipRotateDir(rd));
                }else{
                    if (wheels[0][2] == wheels[1][6]){
                        rotateWheel(wn, rd);
                        rotateWheel(2, flipRotateDir(rd));
                        rotateWheel(1, rd);
                    }else{
                        rotateWheel(wn, rd);
                        rotateWheel(2, flipRotateDir(rd));
                        rotateWheel(1, rd);
                        rotateWheel(0, flipRotateDir(rd));
                    }
                }
            }
        }
    }

    // Rotate wheel
    private static void rotateWheel(int wn, int rd){
        if (rd == 1){
            char tmp = wheels[wn][7];
            for (int i = 6; i >= 0; i--){
                wheels[wn][i + 1] = wheels[wn][i];
            }
            wheels[wn][0] = tmp;
        }else{
            char tmp = wheels[wn][0];
            for (int i = 0; i < 7; i++){
                wheels[wn][i] = wheels[wn][i + 1];
            }
            wheels[wn][7] = tmp;
        }
    }

    // Flip rotate direction
    private static int flipRotateDir(int rd){
        return rd == 1 ? -1 : 1;
    }

    // Count total score
    private static int countTotalScore(){
        int score = 0;

        score += wheels[0][0] == '0' ? 0 : 1;
        score += wheels[1][0] == '0' ? 0 : 2;
        score += wheels[2][0] == '0' ? 0 : 4;
        score += wheels[3][0] == '0' ? 0 : 8;

        return score;
    }
}