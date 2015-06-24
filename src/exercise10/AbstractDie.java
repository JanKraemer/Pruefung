package exercise10;

import java.util.*;


// In dieser Aufgabe soll ein Wuerfel (engl. Die) simuliert werden.
// Genauer gesagt: Der Wuerfel soll eine Unterklasse der nachfolgenden
// abstrakten Klasse sein. Durch die Implementierung des Interfaces
// Iterable kann die Folge von Wuerfelergebnissen mit Hilfe eines
// Iterators abgerufen werden.


public abstract class AbstractDie implements Iterable<Integer> {

    // Diese abstrakte Methode liefert einen Iterator, den
	// man bis in alle Ewigkeit nach neuen Wuerfelergebnissen
	// befragen kann. Sie muessen wohl sowohl diese Methode als
	// auch eine geeignete Rueckgabeklasse implementieren.
	public abstract Iterator<Integer> iterator(); 
	
	
	// Diese Testmethode zeigt, wie der Wuerfel verwendet
	// werden kann.
	public static void test(AbstractDie aDie)
	{		
		int count = 0;
		
		for (Integer i : aDie)
		{
			count++;
			if (i == 6) break;
		}	
		System.out.println("Die 6 kam nach " + count + " Versuchen.");		
	}
	
}
