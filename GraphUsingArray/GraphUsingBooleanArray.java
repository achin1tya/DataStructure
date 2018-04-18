package l25;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import l15.QueueEmptyException;
import l15.QueueImplementation;

public class GraphUsingBooleanArray {
public static int RED=1;
public static int BLUE=0;
	public static boolean[][] takeGraphInput() {
		int n, m;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		boolean edges[][] = new boolean[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			int first = s.nextInt();
			int second = s.nextInt();
			edges[first][second] = true;
			edges[second][first] = true;
		}
		return edges;
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		boolean[][] edges = takeGraphInput();
		Scanner s = new Scanner(System.in);
		int startVertex = s.nextInt();
//		int endVertex = s.nextInt();
		int n = edges.length - 1;
//		boolean visited[] = new boolean[n + 1];
//		boolean ans = hasPath(edges, startVertex, endVertex, visited);
		boolean ansConnected= isConnected(edges, startVertex);
//		System.out.println(ans);
		
		System.out.println(ansConnected);
		boolean isTree=isItATree(edges);
		System.out.println("the given graph is"+isTree);
		boolean colour=colourTheGraph(edges,startVertex);
		System.out.println("the graph can be "+colour);
		 
	}

	private static boolean[] isConnectedHelper(boolean[][] edges, int startVertex, boolean visited[]) {

		visited[startVertex] = true;
		
		int n = edges.length - 1;
		for (int vertex = 1; vertex <= n; vertex++) {
			if (edges[startVertex][vertex]) {
				if (!visited[vertex]) {
					visited = isConnectedHelper(edges, vertex, visited);
					
				}
			}
		}
		return visited;
	}
	
	public static  boolean colourTheGraph(boolean[][] edges,int startIndex) throws QueueEmptyException
	{
		QueueImplementation<Integer> colourQueue=new QueueImplementation<>();
		int[] B =new int[edges.length];
		int[] R=new int[edges.length];
		
		colourQueue.enqueue(startIndex);
		B[startIndex]=1;
		int flag=BLUE;
		while(!colourQueue.isEmpty())
		{
			int current=colourQueue.dequeue();
			for(int adjacent=1;adjacent<=edges.length-1;adjacent++)
			{
				
				if(edges[current][adjacent]){
					if(R[adjacent]==0&&B[adjacent]==0)
					{
						if(flag==BLUE)
						{
							R[adjacent]=1;
							colourQueue.enqueue(adjacent);
						}
						if(flag==RED)
						{
							B[adjacent]=1;
							colourQueue.enqueue(adjacent);
						}
					}
					else 
					{
						return false;
					}
					
					}
			}
			if(flag==RED)
				flag=BLUE;
			else
				flag=RED;
		}
		return true;
	}
	private static boolean isConnected(boolean[][] edges, int startVertex)
	{
		if(edges.length<1)
			return false;
		if(edges.length==1)
		{
			return true;
		}
		boolean[] visited=new boolean[edges.length+1];
		visited=isConnectedHelper(edges, startVertex, visited);
		for(int i=1;i<=edges.length-1;i++)
		{
			if(visited[i]!=true)
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isItATree(boolean edges[][]){
		int noOfVertex=edges.length-1;
		int noOfEdges=0;
		if(edges.length<1)
			return false;
		for(int i=1;i<edges.length;i++)
		{
			for(int j=1;j<edges[i].length;j++)
			{
				if(edges[i][j]==true)
					noOfEdges++;
			}
		}
		noOfEdges/=2;
		boolean ans=false;
		if(noOfEdges!=noOfVertex-1)
			return false;
		int v=1;
		if(isConnected(edges, v)){
			ans=true;
			System.out.println(ans);
		}
		return ans;
	}
	private static boolean hasPath(boolean[][] edges, int startVertex,
			int endVertex, boolean visited[]) {
		if (startVertex == endVertex) {
			return true;
		}
		if (edges[startVertex][endVertex]) {
			return true;
		}
		
		visited[startVertex] = true;
		int n = edges.length - 1;
		for (int vertex = 1; vertex <= n; vertex++) {
			if (edges[startVertex][vertex]) {
				if (!visited[vertex]) {
					boolean path = hasPath(edges, vertex, endVertex, visited);
					if (path) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
