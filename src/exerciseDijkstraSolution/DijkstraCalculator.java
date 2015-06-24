package exerciseDijkstraSolution;

public class DijkstraCalculator 
{
	// Karte
	DistanceMap map = null;
	
	// Initialisierung des Calculators mit einer Karte
	DijkstraCalculator(DistanceMap map)
	{
		this.map = map;
	}

	// Berechnen der Kosten fuer eine Reise 
	public int priceForTraveling(String from, String to, CalcPriceForDistanceAction action)
	{
		DijkstraSet set = new DijkstraSet(map.getNodes());
		set.getNodeByName(from).improveDistance(0);
		
		while(set.unvisitedCount()>0) {
			DijkstraNode next = set.getNearestUnvisited();
			next.visit();
			Node[] neighbours = next.getNode().connectedNodes();
			for (int i = 0; i < neighbours.length; i++) {
				int distanceToNeighbour =
						next.getNode().connectionTo(neighbours[i]).distance();
				int costToNeighbour = action.priceForDistance(distanceToNeighbour);
				set.improveDistance(neighbours[i], next.getDistance() + costToNeighbour);
			}
		}
		
		return set.getNodeByName(to).getDistance();
	}
	
	
	// Testmethode
	public static void main(String[] args)
	{
		DijkstraCalculator dc = new DijkstraCalculator(DistanceMap.FranconiaMap());
		int distance = dc.priceForTraveling("Wuerzburg", "Hof", new CalcPriceForDistanceAction());
		System.out.println("Die Entfernung von Wuerzburg nach Hof betraegt " + distance + "km.");
		int carprice = dc.priceForTraveling("Wuerzburg", "Hof", new CalcCarPriceForDistanceAction());
		System.out.println("Mit dem Auto kostet die Strecke " + carprice/100 + " Euro.");
		int trainprice = dc.priceForTraveling("Wuerzburg", "Hof", new CalcTrainPriceForDistanceAction());
		System.out.println("Und mit dem Zug kostet die Strecke " + trainprice/100 + " Euro.");
	}
	
}
