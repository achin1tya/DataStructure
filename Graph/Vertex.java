package l24;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
	String name;
	HashMap<Vertex, Edge> adjacent;
	
	public Vertex(String name) {
		this.name = name;
		this.adjacent = new HashMap<>();
	}

	public int numEdges() {
		return adjacent.size();
	}

	public ArrayList<Vertex> getAdjacentCities() {
		ArrayList<Vertex> a = new ArrayList<>();
		a.addAll(adjacent.keySet());
		return a;
	}

	public void removeEdgeWith(Vertex v1) {
		adjacent.remove(v1);
	}

	public boolean isAdjacent(Vertex v2) {
		return adjacent.containsKey(v2);
	}

	public void addEdge(Edge e) {
		if (e.from == this) {
			adjacent.put(e.to, e);
		} else if (e.to == this) {
			adjacent.put(e.from, e);
		} else {
			return;
		}
	}

	public void print() {
		System.out.print(name + " : ");
		for (Vertex v: adjacent.keySet()) {
			System.out.print(v.name + " , ");
		}
		System.out.println();
	}
}
