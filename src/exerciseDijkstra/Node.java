package exerciseDijkstra;

public class Node {
	
	private String name;
	private Edge[] edges;
	
	public Node(String name)
	{
		this.name = name;
		edges = new Edge[0];
	}
	
	public String getName()
	{
		return name;
	}
	
	public Node[] connectedNodes()
	{
		Node[] result = new Node[edges.length];
		for (int i=0; i < edges.length; i++)
			result[i] = edges[i].connectingToStartingFrom(this);
		return result;
	}
	
	public Edge connectionTo(Node n)
	{
		for (int i=0; i < edges.length; i++)
			if (edges[i].connectingToStartingFrom(this).equals(n)) return edges[i];
		return null;
	}
	
	
	private void addEdge(Edge newEdge)
	{
		Edge[] newEdgeList = new Edge[edges.length+1];
		for (int i = 0; i < edges.length; i++)
			newEdgeList[i] = edges[i];
		newEdgeList[edges.length] = newEdge;
		edges = newEdgeList;
	}
	
	public void connectWith(Node destination, int distance)
	{
		Edge newEdge = new Edge(distance, this, destination);
		addEdge(newEdge);
		destination.addEdge(newEdge);
	}

}
