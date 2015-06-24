package exerciseDijkstra;

public class Edge {
	
	private int lengthOfEdge;
	private Node node1, node2; 
	
	public Edge(int distance, Node n1, Node n2)
	{
		lengthOfEdge = distance;
		node1 = n1;
		node2 = n2;
	}

	int distance()
	{
		return lengthOfEdge;
	}
		
	Node connectingToStartingFrom(Node start)
	{
		if (node1.equals(start))
			return node2;
		if (node2.equals(start))
			return node1;
		return null;
	}
	
}
