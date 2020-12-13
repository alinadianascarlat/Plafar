
public class Produs {
	String nume;
	int cantitate;
	String pret; // trebuie double
	String valabilitate;
	
	public Produs(String nume, int cantitate, String pret, String valabilitate) {
		this.nume = nume;
		this.cantitate = cantitate;
		this.pret = pret;
		this.valabilitate = valabilitate;
	}
	
	public String toString() {
		return nume;
	}
}
