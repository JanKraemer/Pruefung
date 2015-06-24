package exerciseDijkstraSolution;

// Diese Klasse enthaelt die geografischen Abstaende und Verbindungen.
// Staedte werden als Knoten (Node) modelliert, die Verbindungen
// als Kanten (Edge).
public class DistanceMap {
	
// Feld mit allen Staedten der Karte
	private Node[] nodes = new Node[] {};

// Auslesen aller Staedte
	public Node[] getNodes()
	{
		return nodes;
	}

// Auslesen eines Knotenobjekts mit Hilfe des Staedtenamens	
	public Node getNodeByName(String name)
	{
		for (int i = 0; i < nodes.length; i++)
			if (nodes[i].getName().equalsIgnoreCase(name))
				return nodes[i];
		throw new UnsupportedOperationException();
	}

// Hinzufuegen einer Stadt	
	private void addNode(Node n)
	{
		Node[] newNodeList = new Node[nodes.length+1];
		for (int i = 0; i < nodes.length; i++)
			newNodeList[i] = nodes[i];
		newNodeList[nodes.length] = n;
		nodes = newNodeList;
	}

// Hinzufuegen einer Stadt per Name 	
	public void addNode(String name)
	{
		Node n = new Node(name);
		addNode(n);
	}

// Einfuegen einer Verbindung zwischen zwei Staedten	
	public void connectNodes(String name1, String name2, int distance)
	{
		Node node1 = getNodeByName(name1);
		Node node2 = getNodeByName(name2);
		node1.connectWith(node2, distance);
	}

// Generieren der Beispielkarte
	public static DistanceMap FranconiaMap()
	{
		DistanceMap result = new DistanceMap();
		
		result.addNode("Wuerzburg");
		result.addNode("Schweinfurt");
		result.addNode("Nuernberg");
		result.addNode("Bamberg");
		result.addNode("Bayreuth");
		result.addNode("Hof");
		result.addNode("Coburg");
				
		result.connectNodes("Nuernberg", "Wuerzburg", 100);
		result.connectNodes("Wuerzburg", "Schweinfurt", 50);
		result.connectNodes("Bamberg", "Schweinfurt", 60);
		result.connectNodes("Bamberg", "Nuernberg", 60);
		result.connectNodes("Bamberg", "Bayreuth", 60);
		result.connectNodes("Nuernberg", "Bayreuth", 90);
		result.connectNodes("Hof", "Bayreuth", 50);
		result.connectNodes("Hof", "Coburg", 80);
		result.connectNodes("Bamberg", "Coburg", 50);
		
		return result;
		
	}
	

}
