package exercise12;

// Die nachfolgende Klasse repraesentiert eine lebende Zelle.
// Die Position der Zelle wird durch die Koordinaten x und y festgelegt.
// Es stehen Getter fuer die Positionsdaten zur Verfuegung.
// Ausserdem wurden equals und hashcode ueberschrieben.

public class Cell {
	
	// Position der Zelle
	protected int x;
	protected int y;
		
	// Konstruktor
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	// Getter
	public int getX() { return x; }
	public int getY() { return y; }
		
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Cell)
			return ((Cell)o).getX() == x && ((Cell)o).getY() == y;
		return false;
	}
	
	@Override
	public int hashCode()
	{
		long l = x * y;
		return (int) (l % Integer.MAX_VALUE);
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}
