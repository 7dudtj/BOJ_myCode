import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main{

	// set static variables

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N+1];
		for (int i = 1; i <= N; i++) nodes[i] = new Node(null, null);
		StringTokenizer st = null;
		int nodeNum = 0, leftNum = 0, rightNum = 0;
		Node root = null;

		// get nodes data
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			nodeNum = Integer.parseInt(st.nextToken());
			leftNum = Integer.parseInt(st.nextToken());
			rightNum = Integer.parseInt(st.nextToken());
			if (leftNum == -1 && rightNum == -1){
				continue;
			}
			else if (leftNum == -1){
				nodes[nodeNum].right = nodes[rightNum];
			}
			else if (rightNum == -1){
				nodes[nodeNum].left = nodes[leftNum];
			}
			else{
				nodes[nodeNum].right = nodes[rightNum];
				nodes[nodeNum].left = nodes[leftNum];
			}
		}

		// find root
		for (int i = 1; i <= N; i++){
			if (dfs(nodes[i]) == N) root = nodes[i];
		}

		// traverse tree: check level and node info
		root.level = 1;
		traverse(root);

		// check column
		checkColumn(root, 1);

		// find max level
		int maxLevel = 0;
		for (int i = 1; i <= N; i++){
			if (nodes[i].level > maxLevel) maxLevel = nodes[i].level;
		}

		// make level list
		List<Integer>[] levelList = new List[maxLevel + 1];
		for (int i = 1; i <= maxLevel; i++) levelList[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			levelList[nodes[i].level].add(nodes[i].column);
		}

		// sort level list
		for (int i = 1; i <= maxLevel; i++){
			Collections.sort(levelList[i]);
		}

		// find answer
		int targetLevel = 0;
		int width = 0;
		for (int i = 1; i <= maxLevel; i++){
			if (width < (levelList[i].get(levelList[i].size()-1) - levelList[i].get(0) + 1)){
				width = levelList[i].get(levelList[i].size()-1) - levelList[i].get(0) + 1;
				targetLevel = i;
			}
		}

		// print answer and end program
		System.out.printf("%d %d", targetLevel, width);
		br.close();
		return;
	}

	// dfs: calculate how many nodes exist at given tree
	private static int dfs(Node root){

		if (root == null) return 0;
		return dfs(root.left) + dfs(root.right) + 1;
	}

	// traverse: check nodes' level, leftCount, and rightCount
	private static int traverse(Node root){

		// if root is leaf
		if (root.left == null && root.right == null){
			return 1;
		}
		// if only left node is null
		else if (root.left == null){
			root.right.level = root.level + 1;
			root.rightCount = traverse(root.right);
			return root.rightCount + 1;
		}
		// if only right node is null
		else if (root.right == null){
			root.left.level = root.level + 1;
			root.leftCount = traverse(root.left);
			return root.leftCount + 1;
		}
		// node has two children
		else{
			root.left.level = root.level + 1;
			root.right.level = root.level + 1;
			root.leftCount = traverse(root.left);
			root.rightCount = traverse(root.right);
			return root.leftCount + root.rightCount + 1;
		}
	}
	
	// check column number
	private static void checkColumn(Node root, int leftEnd){

		// if node is leaf
		if (root.left == null && root.right == null){
			root.column = leftEnd;
		}
		// if left child is null
		else if (root.left == null){
			root.column = leftEnd;
			checkColumn(root.right, root.column + 1);
		}
		// if right child is null
		else if (root.right == null){
			root.column = leftEnd + root.leftCount;
			checkColumn(root.left, leftEnd);
		}
		// node has two children
		else{
			root.column = leftEnd + root.leftCount;
			checkColumn(root.left, leftEnd);
			checkColumn(root.right, root.column + 1);
		}
	}
}

// Node class
class Node{
	int level = 0, column = 0;
	int leftCount = 0, rightCount = 0;
	Node left = null, right = null;
	public Node(Node l, Node r){
		left = l;
		right = r;
	}
}