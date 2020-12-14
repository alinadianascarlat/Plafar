import java.io.*;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
public class FileWrite {
	public static void main(String[]args) {

		
	try {
	FileWriter fisier = new FileWriter("alina.txt");
		fisier.write(" akkkk");
		fisier.close();
		}catch(Exception ex) {ex.printStackTrace();
}

	try {
		FileReader citeste = new FileReader("alina.txt");
		BufferedReader BR = new BufferedReader(citeste);
		System.out.println(BR.readLine());
			}catch(Exception ex) {ex.printStackTrace();
	}
	}
}
