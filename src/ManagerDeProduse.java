import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author alina
 *
 */
public class ManagerDeProduse {
	/**
	 * Tine in memorei lista de produse pe care le incarcam din fisier si pe care
	 * trebuie sa le salvam atunci cand modificam cantitatea
	 * 
	 */
	private static ArrayList<Produs> produse = null;

	/**
	 * 
	 * @return produsele incarcate din fisierul produse.txt
	 */

	public static Produs[] getProduse() {
		if (produse != null) {
			return (Produs[]) produse.toArray(new Produs[produse.size()]);
		}

		produse = new ArrayList<Produs>();

		BufferedReader fisierCitireCuBuffer;
		try {
			fisierCitireCuBuffer = new BufferedReader(new FileReader("produse.txt"));
			String linie = fisierCitireCuBuffer.readLine();

			while (linie != null) {
				String[] produsDinLinie = { "", "", "", "" };
				int j = 0;

				for (int i = 0; i < linie.length(); i++) {
					if (linie.charAt(i) != ',') {
						produsDinLinie[j] += linie.charAt(i);
					} else {
						j++;
					}
				}
				
				/**
				 * Am convertit stringul la int si double
				 */
				produse.add(new Produs(produsDinLinie[0], Integer.parseInt(produsDinLinie[1]),
						Double.parseDouble(produsDinLinie[2]), produsDinLinie[3]));
				linie = fisierCitireCuBuffer.readLine();
			}
			fisierCitireCuBuffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Produs[]) produse.toArray(new Produs[produse.size()]);
	}

	/**
	 * Scade stocul unui produs si il salveaza in fisier
	 * 
	 * @param produs    - produsul pentru care se scade cantitatea
	 * @param cantitate - cantitatea care se scade
	 */
	public static void scadeCantitate(Produs produs, int cantitate) {
		for (int i = 0; i < produse.size(); i++) {
			if (produse.get(i).equals(produs)) {
				produse.get(i).cantitate -= cantitate;
			}
		}
		salveazaProdusele();
	}

	/**
	 * Adauga un produs nou si il salveaza in fisier
	 * 
	 * @param produs-produsul care trebuie adaugat
	 */

	public static void adaugaProdus(Produs produs) {
		produse.add(produs);
		salveazaProdusele();
	}

	/**
	 * Salveaza toate produsele din variabila(@link #produse)in fisierul
	 * <b>produse.txt</b>
	 */

	private static void salveazaProdusele() {
		try {
			
			/**
			 * 
			 * 
			 */
			FileWriter fisier = new FileWriter("produse.txt", false);
			/**
			 * Parcurgem tot array de produse pentru fiecare produs
			 * din Produse
			 */
			for (Produs produs : produse) {
				fisier.write(
						produs.nume + "," + produs.cantitate + "," + produs.pret + "," + produs.valabilitate + "\n");
			}
			fisier.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
