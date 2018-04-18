package l24;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import l15.QueueEmptyException;
import l15.QueueImplementation;

public class Graph {

	HashMap<String, Vertex> cities; 

	public Graph() {
		this.cities = new HashMap<>();
	}

	public int numCities() {
		return cities.size();
	}

	private Vertex getVertex(String cityName) {
		return cities.get(cityName);
	}

	public int numEdges() {
		int ans = 0;
		for (String cityName: cities.keySet()) {
			ans += getVertex(cityName).numEdges();
		}
		return ans/2;
	}

	public void removeCity(String city1) {
		Vertex v1 = getVertex(city1);
		if (v1 == null) {
			return;
		}
		
		ArrayList<Vertex> adjacentCities = v1.getAdjacentCities();
		for (Vertex adjacent: adjacentCities) {
			adjacent.removeEdgeWith(v1);
		}
		
		cities.remove(city1);
	}

	public void removeEdge(String city1, String city2) {
		Vertex v1 = getVertex(city1);
		Vertex v2 = getVertex(city2);
		if (v1 == null || v2 == null) {
			return;
		}
		
		v1.removeEdgeWith(v2);
		v2.removeEdgeWith(v1);
	}

	public boolean hasCity(String city1) {
		return cities.containsKey(city1);
	}

//	public ArrayList<String> getPath(String city1, String city2)  {
//		Vertex v1=getVertex(city1);
//		Vertex v2=getVertex(city2);
//		if(v1==null||v2==null)
//		{
//			ArrayList<String> arr=new ArrayList<>(0);
//			return arr;
//		}
//		
//	}

	//depth first search
	private boolean hasPath(Vertex v1, Vertex v2, HashSet<Vertex> visited) {
		if (v1.isAdjacent(v2)) {
			return true;
		}
		visited.add(v1);
		
		ArrayList<Vertex> adjacentVertices = v1.getAdjacentCities();
		for (Vertex adjacent: adjacentVertices) {
			if (visited.contains(adjacent)) {
				continue;
			}
			if (hasPath(adjacent, v2, visited)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPath(String city1, String city2)  {
		Vertex v1 = getVertex(city1);
		Vertex v2 = getVertex(city2);
		if (v1 == null || v2 == null) {
			return false;
		}
		HashSet<Vertex> visited = new HashSet<>();
		return hasPath(v1, v2, visited);
	}
	//breadth first search
	public boolean hasPathBFS(Vertex v1,Vertex v2,HashSet<Vertex> visited) throws QueueEmptyException
	{
		boolean ans=false;
		QueueImplementation<Vertex> bfsQueue=new QueueImplementation<>();	//queue
		bfsQueue.enqueue(v1);
		while(bfsQueue.isEmpty()==false){							//for empty queue iterartor
			Vertex currentNode=bfsQueue.dequeue();
			if(currentNode.isAdjacent(v2))								//true case
			{
				ans=true;
				break;
			}
			visited.add(currentNode);								//update visited
			ArrayList<Vertex> adjacentVertices=currentNode.getAdjacentCities();		
			for (Vertex adjacent: adjacentVertices) {
				if (visited.contains(adjacent)) {
					continue;
				}
				else
					bfsQueue.enqueue(adjacent);
			}
		}
		return ans;
		
	}
	public boolean hasPathBFS(String city1,String city2) throws QueueEmptyException
	{
		Vertex v1 =getVertex(city1);
		Vertex v2=getVertex(city2);
		if(v1==null||v2==null)
			return false;
		HashSet<Vertex> visited=new HashSet<>();
		return hasPathBFS(v1,v2,visited);
	}

	public boolean areAdjacent(String city1, String city2)  {
		Vertex v1 = getVertex(city1);
		Vertex v2 = getVertex(city2);
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.isAdjacent(v2);
	}

	public void addEdge(String city1, String city2) {
		Vertex v1 = getVertex(city1);
		Vertex v2 = getVertex(city2);
		if (v1 == null || v2 == null) {
			return;
		}
		if (!v1.isAdjacent(v2)) {
			Edge e = new Edge(v1, v2);
			v1.addEdge(e);
			v2.addEdge(e);
		}
	}

	public void print() {
		System.out.println("Num Cities: " + numCities());
		System.out.println("Num Edges: " + numEdges());
		for (Vertex v: cities.values()) {
			v.print();
		}
		
	}
	
	public void addCity(String cityName) {
		if (hasCity(cityName)) {
			return;
		}
		Vertex v = new Vertex(cityName);
		cities.put(cityName, v);
	}

	public ArrayList<Vertex> isConnectedHelper(Vertex v1,ArrayList<Vertex> visited) {
		
		
		
		ArrayList<Vertex> adjacentVertices = v1.getAdjacentCities();
		for (Vertex adjacent: adjacentVertices) {
			if (visited.contains(adjacent)) {
				continue;
			}
			else
			{
				visited=isConnectedHelper(adjacent, visited);
			}
			
		}
		visited.add(v1);
		return visited;
	}
	public boolean isConnected(String v1)
	{
		Vertex city=getVertex(v1);
		if(city==null)
			return false;
		ArrayList<Vertex> visited=new ArrayList<>();
		 ArrayList<Vertex> ans=isConnectedHelper(city, visited);
		 Set<String> arr=new HashSet<>();
		 arr=this.cities.keySet();
		 if(arr.size()!=ans.size())
		 {
			 return false;
		 }
		 
			return true;	
	}
//
//	public ArrayList<ArrayList<String>> getConnectedComponents() {
//
//	}
	
	public static void main(String[] args) throws QueueEmptyException {
		Graph g = new Graph();
		g.addCity("D");
		g.addCity("G");
		g.addCity("F");
		g.addCity("N");
		g.addCity("K");
		g.addEdge("D", "N");
		g.addEdge("D", "K");
		g.addEdge("D", "F");
		g.addEdge("G", "N");
		g.addEdge("G", "F");
		g.addEdge("K", "N");
		g.addEdge("K", "F");
		g.print();
		g.removeEdge("D", "K");
		g.print();
		g.removeCity("K");
		g.print();
		System.out.println(g.hasPath("N", "G"));
		System.out.println(g.hasPathBFS("N", "K"));
		System.out.println(g.isConnected("N"));
		
		 
		
	}
	
}
