package exercise04;


// Die nachfolgende Klasse repraesentiert einen Punkt in einem 
// zweidimensionalen Koordinatensystem.

public class Point {
	
	// Die Instanzvariablen zur Aufnahme der Koordinatenwerte
	private double x, y;
	
	// Konstruktor mit Uebergabe der x und y - Koordinate
	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	// Auslesen der x-Koordinate
	double x()
	{
		return x; 
	}
	
	// Auslesen der y-Koordinate
	double y()
	{
		return y; 
	}
	
	// Abstand zu einem anderen Punkt
	double distance(Point other)
	{
		double dx = x()-other.x();
		double dy = y()-other.y();		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	// Erzeugung eines neuen Punktes, der zum Ausgangspunkt verschoben ist
	Point moved(double deltaX, double deltaY)
	{
		return new Point(x() + deltaX, y() + deltaY);
	}
	
	// Rueckgabe der Koordinaten in einem String in lesbarer Form
	public String toString()
	{
		return String.format("(%.2f;%.2f)", x(), y());
	}
	
}
