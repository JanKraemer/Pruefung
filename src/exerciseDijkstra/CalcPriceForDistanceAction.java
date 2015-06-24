package exerciseDijkstra;

// Klasse, die die Berechnungsmethode fuer die Kosten eines gefahrenen Kilometers bereitstellt.
// Kann z.B. fuer PKW und Zug unterschiedlich sein.
public class CalcPriceForDistanceAction 
{
	// Vorbedingung: Uebergabe einer positiven Entfernungsangabe in Kilometern
	// Nachbedingung: Rueckgabe der Kosten fuer die gesamte Strecke in Cent 
	// d.h. (100 entspricht einem Euro)
	public int priceForDistance(int distance)
	{
		return distance;  // jeder km kostet einen Cent
	}

}
