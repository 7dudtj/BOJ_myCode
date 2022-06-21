import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // set needed components
        Scanner read = new Scanner(System.in);
        int xCor=0, yCor=0;
        int answer=0;
        String s = "";
        
        // get xCor and yCor
        s = read.nextLine();
        xCor = Integer.parseInt(s);
        s = read.nextLine();
        yCor = Integer.parseInt(s);
        read.close();
        
        // find answer
        // 1
        if (xCor > 0 && yCor > 0) answer = 1;
        // 2
        else if (xCor < 0 && yCor > 0) answer = 2;
        // 3
        else if (xCor < 0 && yCor < 0) answer = 3;
        // 4
        else answer = 4;
        
        System.out.print(answer);

        return;
    }
}