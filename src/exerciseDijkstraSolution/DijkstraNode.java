package exerciseDijkstraSolution;


// Die folgende Klasse erweitert den bekannten Node
// um die zwei Attribute distance und visited mit
// zugehoerigen Getter- und Setter-Funktionen.
//
// Man haette auch Vererbung verwenden koennen, aber
// der nachfolgende Ansatz erscheint logischer.

public class DijkstraNode {
	
	private Node node;			// ein klassischer Knoten 
	private int distance;		// die Entfernung
	private boolean visited;	// wurde er schon besucht
	
	public DijkstraNode(Node n) {
		node = n;
		distance = Integer.MAX_VALUE; 	// "unendlich"
		visited = false;				// zunaechst alle false
	}
	
	// Getter und Setter fuer visited
	public boolean isVisited() {
		return visited;
	}
	public void visit() {
		visited = true;
	}
	
	// Getter fuer node
	public Node getNode() {
		return node;
	}
	
	// Getter und Setter fuer distance 
	public int getDistance() {
		return distance;
	}
	public void improveDistance(int newDistance) {
		distance = newDistance < distance ? newDistance : distance;
	}
	
	// Hilfsmethode, die Anfragen an den eingebetteten Node weiterreicht
	public String getName() {
		return node.getName();
	}
}
