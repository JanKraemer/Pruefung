package exercise05;

// Ihre Aufgabe ist es, in der nachfolgenden Klasse die geerbte
// Methode getChange zu ueberschreiben. Natuerlich muss der
// Softwarevertrag der Oberklasse eingehalten werden. Ihre
// Spezialisierung soll aber darueber hinaus sicherstellen,
// dass die Anzahl der ausgegeben Muenzen minimal ist.

public class EnhancedChangeCalculator extends SimpleChangeCalculator 
{
	
	// Hier fehlt Ihre Implementierung

	// Die nachfolgende main-Methode kann genutzt werden, um das
	// Ergebnis zu ueberpruefen.
	public static void main(String[] args)
	{
		
		EnhancedChangeCalculator calc = new EnhancedChangeCalculator();
		
		int[] result = calc.getChange(13,45);
		
		System.out.println("Der Automat gibt folgende Muenzen zurueck:");
		
		for (int i=0; i<Coin.availableCoins.length; i++)
		{
			System.out.println(result[i] + " x " + Coin.availableCoins[i].name());
		}
	}
	
	
	
}
