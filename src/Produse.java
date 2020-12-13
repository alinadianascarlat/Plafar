
public class Produse {
	private static Produs[] produse = { new Produs("Ceai musetel", 20, "3", "2023"),
			new Produs("Ceai tei", 10, "5", "2025"), new Produs("Ceai sunatoare", 10, "3", "2022"),
			new Produs("Rostopasca", 5, "15", "2025"), new Produs("Spirulina", 2, "10", "2026") };

	public static Produs[] getProduse() {
		return produse;
	}

	public static void scadeCantitate(Produs produs, int cantitate) {
		for (int i = 0; i < produse.length; i++) {
			if (produse[i].equals(produs)) {
				produse[i].cantitate -= cantitate;
			}
		}
	}

	public static void adaugaProdus(Produs produs) {
		// ne trebuie ca sa salveze in fisier
	}
}
