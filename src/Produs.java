/**
 * Clasa folosita ca sa modelez un produs din aplicatie.
 * 
 * @author alina
 *
 */
public class Produs {
	String nume;
	int cantitate;
	Double pret;
	String valabilitate;

	/**
	 * 
	 * @param nume         - numele produsului
	 * @param cantitate    - cantitatea de produse
	 * @param pret         - pretul unui produs
	 * @param valabilitate - termen de valabilitate pentru un produs
	 */
	public Produs(String nume, int cantitate, Double pret, String valabilitate) {
		this.nume = nume;
		this.cantitate = cantitate;
		this.pret = pret;
		this.valabilitate = valabilitate;
	}

	/**
	 * @return numele produsului
	 */
	public String toString() {
		return nume;
	}
}
