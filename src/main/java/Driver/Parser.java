package Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Parser {
		public static Vector<String> Parse(String equation) {
				Vector<String> tokens = new Vector<String>();
				String accumulator = "";
				while (equation.length() != 0) {
						if (equation.length() == 0) {
								tokens.addElement(new String(accumulator));  
								break;
							}
						switch (equation.charAt(0)) { 			
								case ',': {
										if(accumulator.length() != 0) {
												tokens.addElement(new String(accumulator));
												equation = equation.substring(1);
												accumulator = "";
											}
										break;
									}
								default : {
										accumulator += equation.substring(0,1);
										equation = equation.substring(1);
										if(equation.length() == 0) {
												tokens.addElement(new String(accumulator));
											}
										break;
									}
							}
					}
				return(tokens);
			}
		public static Vector<String> baca() {
				BufferedReader br = null;
				Integer i = 0;
				Vector<String> result = new Vector<String>();
				try {
						String sCurrentLine = "";
						br = new BufferedReader(new FileReader("car.data.txt"));
						while ((sCurrentLine = br.readLine()) != null) {
								result.addElement(new String(sCurrentLine));
								i++;
							}
					}
				catch (IOException e) {
					}
				return result;
			}
		public static String[][] BacaString () {
				Vector<String> keluaran = new Vector<String>();
				keluaran = baca();
				Integer i = 0;
				Integer j = 0;
				Vector<String> hasilparses = new Vector<String>();
				hasilparses = Parse(keluaran.elementAt(0));
				String[][] graphII = new String[keluaran.size()+1][hasilparses.size()+1];
				for(i = 0; i< (keluaran.size());i++) {
						Vector<String> hasilparse = new Vector<String>();
						hasilparse = Parse(keluaran.elementAt(i));
						for(j = 0; j< (hasilparse.size());j++) {
								graphII[i][j] = hasilparse.elementAt(j);
							}
					}
				return graphII;
			}
		public static void main(String[] args) {
				Vector<String> keluarand = Parser.baca();
				Vector<String> hasilparsesd = Parser.Parse(keluarand.elementAt(0));
				Integer mainbaris = keluarand.size();
				Integer mainkolom = hasilparsesd.size();
				String[][] mainmatrik = Parser.BacaString();
				Integer i = 0;
				Integer j = 0;
				for(i = 0;i < mainbaris;i++) {
						for(j = 0;j < mainkolom;j++){
								System.out.println(mainmatrik[i][j]+",");
							}
						System.out.println("\n");
					}
			}
	}	
