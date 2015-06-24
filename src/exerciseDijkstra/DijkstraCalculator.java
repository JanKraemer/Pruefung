package exerciseDijkstra;

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
		DijkstraList City = new DijkstraList();
		for(Node n: DistanceMap.FranconiaMap().getNodes())
			City.addElement(n.getName());
		City.updateCity(City.getCitybyName(from), 0);
		while(City.unvisitedCities()!= 0)
		{
			City nearest = City.getNearestCity();
			Node actual = DistanceMap.FranconiaMap().getNodeByName(nearest.getName());
			Node[] neighbors = actual.connectedNodes();
			int distance = 0;
			for(int i = 0 ;i <neighbors.length;i++)
			{
				distance = actual.connectionTo(neighbors[i]).distance();
				City.updateCity(City.getCitybyName(neighbors[i].getName()),(nearest.getDistance() +action.priceForDistance(distance)));
			}	
			City.cityVisited(nearest);
		}
		return City.getCitybyName(to).getDistance();
	}
	
	
	// Testmethode
	public static void main(String[] args)
	{
		DijkstraCalculator dc = new DijkstraCalculator(DistanceMap.FranconiaMap());
		int distance = dc.priceForTraveling("Wuerzburg", "Hof", new CalcPriceForDistanceAction());
		System.out.println("Die Entfernung von Wuerzburg nach Hof betraegt " + distance + "km.");
	}
	
}
