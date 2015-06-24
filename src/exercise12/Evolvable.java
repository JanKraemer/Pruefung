package exercise12;

import java.util.*;

// Das nachfolgende Interface beschreibt, welche Methoden eine Klasse
// besitzen muss, die das Game Of Live implementiert.

public interface Evolvable {

	// Zu Beginn wird mit dieser Methode eine Menge lebender Zellen 
	// (inkl. Positionsdaten) als Startpopulation uebergeben.
	public void initWithCells(Collection<Cell> cells);

	// Die Regeln für die Weiterentwicklung der Population werden 
	// angewandt. Nach Ausfuehrung der Methode ist die neue 
	// Population am Leben.
	public Evolvable evolve();

	// Mit dieser Methode koennen alle aktuell lebenden Zellen 
	// (inkl. Positionsdaten) abgerufen werden.
	public Collection<Cell> cells();

}
