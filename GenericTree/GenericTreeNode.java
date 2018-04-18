package l17;

import java.util.ArrayList;

public class GenericTreeNode<T> {
	T data;
	ArrayList<GenericTreeNode<T>> children;
	public GenericTreeNode(T data) {
		this.data=data;
		children=new ArrayList<>();
	}
}
