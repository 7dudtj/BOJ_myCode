import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int A, B, C, D, pos, width, height;
		int[] list = new int[4];
		String s;
		
		// get A, B, C, and D
		// get A
		s = read.nextLine();
		pos = s.indexOf(" ");
		A = Integer.parseInt(s.substring(0, pos));
		// get B
		s = s.substring(pos + 1);
		pos = s.indexOf(" ");
		B = Integer.parseInt(s.substring(0, pos));
		// get C
		s = s.substring(pos + 1);
		pos = s.indexOf(" ");
		C = Integer.parseInt(s.substring(0, pos));
		// get D
		s = s.substring(pos + 1);
		D = Integer.parseInt(s);
		
		// make list
		list[0] = A;
		list[1] = B;
		list[2] = C;
		list[3] = D;
			
		// do sort
		quickSort(list, 0, 3);
		
		// find width and height
		width = list[2];
		height = list[0];
		
		// display answer
		System.out.println(width * height);
		
		// end program
		read.close();
		return;
	}
	
	public static void quickSort(int[] data, int l, int r) {
		int left = l, right = r, pivot = data[(l + r) / 2];
		
		do {
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			if(left <= right) {
				int tmp = data[left];
				data[left] = data[right];
				data[right] = tmp;
				left++;
				right--;
			}
		}while (left <= right);
		
		if(l < right) quickSort(data, l, right);
		if(r > left) quickSort(data, left, r);
	}

}
