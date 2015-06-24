package exerciseDijkstraSolution;

// Die nachfolgende Klasse erleichtert das Verwalten der
// besuchten und unbesuchten Knoten im Dijkstra-Algorithmus.
// ("Dijkstra-Menge")
// Da die in DijkstraNode ergaenzten Attribute benoetigt werden,
// werden DijkstraNodes (und nicht Nodes) als Elemente verwendet. 

public class DijkstraSet {
	
	private DijkstraNode[] set;  // Speicher fuer die Menge
	
	// Konstruktor
	// Erhaelt ein Node-Array und legt dazu eine Dijkstra-Menge an
	public DijkstraSet(Node[] nodes) {
		set = new DijkstraNode[nodes.length];
		for (int i = 0; i < nodes.length; i++)
			set[i] = new DijkstraNode(nodes[i]);
	}

	// Wie viele Knoten sind noch unbesucht?
	public int unvisitedCount() {
		int result = 0;
		for (int i = 0; i < set.length; i++)
			if (!set[i].isVisited()) result++;
		return result;
	}
	
	// Ermittelt einen Knoten zu einem Staedtenamen
	public DijkstraNode getNodeByName(String name) {
		for (int i = 0; i < set.length; i++)
			if (set[i].getName().equalsIgnoreCase(name)) return set[i];
		throw new UnsupportedOperationException();
	}
	
	// Ermittelt den unbesuchten Knoten mit der geringsten Entfernung
	public DijkstraNode getNearestUnvisited() {
		DijkstraNode nearestNode = null;
		for (int i = 0; i < set.length; i++)
			if (!set[i].isVisited()) 
				if ((nearestNode == null) || (nearestNode.getDistance()>set[i].getDistance()))
					nearestNode = set[i];
		return nearestNode;
	}
	
	// Aktualisiert die Entfernung zu einem Knoten
	public void improveDistance(Node node, int newDistance) {
		DijkstraNode dijkstraNode = getNodeByName(node.getName());
		dijkstraNode.improveDistance(newDistance);
	}	
}
