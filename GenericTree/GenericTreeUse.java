package l17;

import java.util.Scanner;

public class GenericTreeUse {
	public static GenericTreeNode<Integer> takeInput(Scanner s) {
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(rootData);
		System.out.println("Enter num children for " + rootData);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			GenericTreeNode<Integer> nextChild = takeInput(s);
			root.children.add(nextChild);
		}
		return root;
	}
	public static void print(GenericTreeNode<Integer> root) {
		System.out.print(root.data + ":");
		for (int i = 0; i < root.children.size(); i++) {
			System.out.print(root.children.get(i).data + ",");
		}
		System.out.println();
		
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	GenericTreeNode<Integer> root=takeInput(s);
	print(root);
}
}	
