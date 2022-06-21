import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, i, j;
		String s;
		int[] map;
		
		// get N
		s = read.nextLine();
		N = Integer.parseInt(s);
		
		// make default map
		map = new int[N*N];
		
		// make map
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			for (j = 0; j < N; j++) {
				map[N*i+j] = Integer.parseInt(s.substring(j, j+1));
			}
		}
		read.close();
		
		// call DFS
		dfs mydfs = new dfs(N, map);
		mydfs.DFS();
		mydfs.showAnswer();
		
		// end program
		return;
	}

}

class dfs {
	int n; // size of one side of map
	int[] map;
	int total = 0; // number of total town
	boolean[] visited;
	int i;
	int numofHouse = 0; // used for shuttle
	int[] houseList;
	Node[] fList;
	
	// dfs constructor
	public dfs(int N, int[] MAP) {
		n = N;
		map = new int[n*n];
		map = MAP;
		visited = new boolean[n*n];
		for (i = 0; i < n*n; i++) visited[i] = false;
		houseList = new int[n*n];
		for (i = 0; i < n*n; i++) houseList[i] = Integer.MAX_VALUE;
		fList = new Node[n*n];
		for (i = 0; i < n*n; i++) fList[i] = new Node();
		setNodes();
	}
	
	// DFS function
	public void DFS() {
		for (i = 0; i < n*n; i++) {
			if (!visited[i] && map[i] == 1) {
				numofHouse = 0;
				doDFS(i);
				houseList[total] = numofHouse;
				total++;
			}
		}
	}
	
	// doDFS function
	public void doDFS(int i) { // 'i' is starting point
		visit(i);
		for (int j = 0; j < fList[i].fNum; j++) {
			if (map[fList[i].friend[j]] == 1 &&
					visited[fList[i].friend[j]] == false) {
				doDFS(fList[i].friend[j]);
			}
		}
	}
	
	// visit function
	public void visit(int i) {
		visited[i] = true;
		numofHouse++;
	}
	
	// show answer function
	public void showAnswer() {
		quickSort(houseList, 0, n*n-1);
		System.out.println(total);
		for (i = 0; i < total; i++) {
			System.out.println(houseList[i]);
		}
	}
	
	// quick sort function
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
	
	// setNodes function
	public void setNodes() {
		for (i = 0; i < n * n; i++) {
			fList[i].nodeNumber = i;
			if (i == 0 || i == n-1 || i == n*n-n || i == n*n-1) {
				fList[i].fNum = 2;
				fList[i].friend = new int[fList[i].fNum];
				if (i == 0) {
					fList[i].addFriend(1);
					fList[i].addFriend(n);
				}else if (i == n - 1) {
					fList[i].addFriend(n - 2);
					fList[i].addFriend(2*n - 1);
				}else if (i == n*n - n) {
					fList[i].addFriend(n*n-2*n);
					fList[i].addFriend(n*n-n+1);
				}else {
					fList[i].addFriend(n*n-2);
					fList[i].addFriend(n*n-n-1);
				}
			}else if (1 <= i && i <= n-2) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i - 1);
				fList[i].addFriend(i + 1);
				fList[i].addFriend(i + n);
			}else if (n*n-n+1 <= i && i <= n*n-2) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i - 1);
				fList[i].addFriend(i + 1);
				fList[i].addFriend(i - n);
			}else if (i % n == 0 && i != 0 && i != n*n-n) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i - n);
				fList[i].addFriend(i + n);
				fList[i].addFriend(i + 1);
			}else if (i % n == n-1 && i != n-1 && i != n*n-1) {
				fList[i].fNum = 3;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i - n);
				fList[i].addFriend(i + n);
				fList[i].addFriend(i - 1);
			}else {
				fList[i].fNum = 4;
				fList[i].friend = new int[fList[i].fNum];
				fList[i].addFriend(i - 1);
				fList[i].addFriend(i + 1);
				fList[i].addFriend(i - n);
				fList[i].addFriend(i + n);
			}
		}
	}
}

class Node {
	int[] friend;
	int fNum;
	int nodeNumber;
	int count = 0;
	
	// add friend function
	public void addFriend(int i) {
		friend[count] = i;
		count++;
	}
	
	// show friends
	public void showFriend() {
		for (int i = 0; i < fNum; i++) {
			System.out.print(friend[i] + " ");
		}
	}
}
