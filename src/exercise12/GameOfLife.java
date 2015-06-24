package exercise12;

import java.util.*;

public class GameOfLife {
	
	
	public static void main(String[] args)
	{
		// Startpopulation
		Evolvable p = null;
		
		// Diese Zeile bitte auskommentieren, 
		// sobald die Klasse Population vorhanden ist. 
		// p = new Population();

		
		// zufaellige Zellen generieren
		Collection<Cell> cells = new ArrayList<Cell>();
		while (cells.size() < 40)
		{
			Cell c = new Cell((int) (Math.random()*10), (int) (Math.random()*10));
			if (!cells.contains(c))
				cells.add(c);
		}
		
		// Einfuegen der Zellen in die Startpopulation
		p.initWithCells(cells);
		
		// Berechnen und Ausgeben von 100 Generationen
		for (int generation = 1; generation <= 100; generation++)
		{
			System.out.println("Generation " + generation);
			showPopulation(p);
			p = p.evolve();
		}
	}
	
	
	// Ausgabe einer Population auf der Konsole
	private static void showPopulation(Evolvable p)
	{
		int 	minx = Integer.MAX_VALUE, 
				miny = Integer.MAX_VALUE, 
				maxx = Integer.MIN_VALUE, 
				maxy = Integer.MIN_VALUE;
		
		// Ermitteln der Extrempositionen von lebenden Zellen
		for (Cell c : p.cells()) 
		{
			minx = (minx < c.x ? minx : c.x);
			miny = (miny < c.y ? miny : c.y);
			maxx = (maxx > c.x ? maxx : c.x);
			maxy = (maxy > c.y ? maxy : c.y);
		}	
		
		System.out.println(minx + " " + maxx + " " + miny + " " + maxy);
		showPopulationField(p, minx, maxx, miny, maxy);
	}


	// Ausgabe des Rechtecks zwischen den Extrempositionen einer Population
	private static void showPopulationField(Evolvable p, 
			int minx, int maxx,
			int miny, int maxy) 
	{
		for (int y = miny; y <= maxy; y++)
		{
			for (int x = minx; x <= maxx; x++)
				showCell(p, x, y);
			System.out.println();
		}
		System.out.println();
	}

	// Ausgabe einer Zellposition einer Population
	// Ist dort eine lebende Zelle, wird "O" ausgegeben, sonst "."
	private static void showCell(Evolvable p, int x, int y) 
	{
		boolean alive = false;
		for (Cell c : p.cells())
			if ((c.x == x) && (c.y == y))
				alive = true;
		System.out.print(alive ? "O" : ".");
	}
	
}
