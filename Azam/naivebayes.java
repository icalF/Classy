import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.math.BigDecimal;

public class naivebayes {
		static Vector<String> keluarand = bacafile.baca();
		static Vector<String> hasilparsesd = bacafile.Parse(keluarand.elementAt(0));
		static Integer mainbaris = keluarand.size();
		static Integer mainkolom = hasilparsesd.size();
		Integer banyakatribut = (keluarand.size() - 1);
		static String[][] mainmatrik = bacafile.BacaString();
		static classattribut[] classyangdiproses = new classattribut[jumlahnilaiatributyangbeda(mainkolom-1)];
		static Integer banyakberbeda = 0;
		static Integer banyakclass = 0;
		static attribut[] aarrayattribut = new attribut[(mainkolom-1)];
			
		public static Integer jumlahnilaiatributyangbeda(Integer kolom) {
				banyakberbeda = 1;
				String[] arraykelas = new String[mainbaris];
				arraykelas[0] = mainmatrik[0][kolom];
				Integer i = 0;
				Integer j = 0;
				Integer checker = 1;
				for(i = 1;i < mainbaris;i++) {
						String katasaatini = mainmatrik[i][kolom];
						checker = 1;
						for(j = 0;j < banyakberbeda;j++) {
								if (katasaatini.equals(arraykelas[j])) {
										checker = 0;
										break;
									}
								else{
										checker = 1;
									}
							}
							if(checker == 1) {
								banyakberbeda++;
								arraykelas[banyakberbeda-1] = katasaatini;
							}
					}
				return banyakberbeda;
			}
		
		public static void makeclassarray() {
				banyakclass = 1;
				classattribut[] arraykelass = new classattribut[jumlahnilaiatributyangbeda(mainkolom-1)];
				arraykelass[0]  = new classattribut(mainmatrik[0][mainkolom-1]);
				arraykelass[0].totalvalue += 1;
				Integer i = 0;
				Integer j = 0;
				Integer checker = 1;
				for(i = 1;i < mainbaris;i++) {
						String katasaatini = mainmatrik[i][mainkolom-1];
						checker = 1;
						for(j = 0;j < banyakclass;j++) {
								if (katasaatini.equals(arraykelass[j].nama)) {
										checker = 0;
										arraykelass[j].totalvalue += 1;
										break;
									}
								else{
										checker = 1;
									}
							}
							if(checker == 1) {
								banyakclass++;
								arraykelass[banyakclass-1] = new classattribut(katasaatini);
							}
					}
				for(i = 1;i < banyakclass;i++) {
						arraykelass[i].totalvalue += 1;
					}
				classyangdiproses = arraykelass;
			}
		
		public static Integer getindexclass(String val) {
				Integer i = 0;
				for(i = 0;i < banyakclass;i++) {
						if(val.equals(classyangdiproses[i].nama)) {
								break;
							}
					}
				return i;
			}
		
		public static Integer getindexatr(Integer kolom, String val) {
				Integer i = 0;
				for(i = 0;i < aarrayattribut[kolom].values;i++) {
						if(val.equals(aarrayattribut[kolom].valuepoint[i].nama)) {
								break;
							}
					}
				return i;
			}
			
		static class attribut {
				public Integer values;
				public namaattribut[] valuepoint;
				public attribut(Integer val) {
						values = val;
						valuepoint = new namaattribut[val];
					}
			}
		
		static class classattribut {
				public String nama;
				public Integer totalvalue;
				public classattribut(String val) {
						nama = val;
						totalvalue = 0;
					}
			}
			
		static class namaattribut {
				public String nama;
				public Double[] classcount;
				public namaattribut(String val) {
						nama = val;
						classcount =  new Double[banyakclass];
						Integer i = 0;
						for(i = 0;i < banyakclass;i++) {
								classcount[i] = 0.0;
							}
					}
			}
		
		
				
		public static attribut[] arrayatributyangbeda() {
				Integer z = 0;
				makeclassarray();
				attribut[] arrayattribut = new attribut[(mainkolom-1)];
				for(z = 0;z < (mainkolom-1);z++) {
						arrayattribut[z] = new attribut(jumlahnilaiatributyangbeda(z));
						Integer banyakberbedas = 1;
						String asdf = mainmatrik[0][z];
						String classs = mainmatrik[0][mainkolom-1];
						Integer x = getindexclass(classs);
						arrayattribut[z].valuepoint[banyakberbedas-1] = new namaattribut(asdf);
						arrayattribut[z].valuepoint[banyakberbedas-1].classcount[x] = ((arrayattribut[z].valuepoint[banyakberbedas-1].classcount[x]) + (1));
						Integer i = 0;
						Integer j = 0;
						Integer checker = 1;
						for(i = 1;i < mainbaris;i++) {
								String katasaatini = mainmatrik[i][z];
								checker = 1;
								for(j = 0;j < banyakberbedas;j++) {
										if (katasaatini.equals(arrayattribut[z].valuepoint[j].nama)) {
												checker = 0;
												break;
											}
										else{
												checker = 1;
											}		
									}
								if(checker == 1) {
										banyakberbedas++;
										arrayattribut[z].valuepoint[banyakberbedas-1] = new namaattribut(katasaatini);
									}
								classs = mainmatrik[i][mainkolom-1];
								x = getindexclass(classs);
								arrayattribut[z].valuepoint[banyakberbedas-1].classcount[x] = ((arrayattribut[z].valuepoint[banyakberbedas-1].classcount[x]) + (1));
							}
					}
				return arrayattribut;		
			}	
		
		public static attribut[] makepeluang() {
				attribut[] arrayattributs = new attribut[mainkolom-1];
				arrayattributs = arrayatributyangbeda();
				Integer i = 0;
				Integer j = 0;
				Integer k = 0;
				for(i = 0;i < (mainkolom-1);i++){
						for(j = 0;j < arrayattributs[i].values;j++){
								for(k = 0;k < banyakclass;k++) {
										arrayattributs[i].valuepoint[j].classcount[k] = (arrayattributs[i].valuepoint[j].classcount[k] / classyangdiproses[k].totalvalue);
									}
							}
					}
				aarrayattribut = arrayattributs;
				return arrayattributs;
			}
		
		public static Double Getpeluang(Integer kolom, String val, String cls) {
				Double hasil = 0.0;
				hasil = aarrayattribut[kolom].valuepoint[getindexatr(kolom,val)].classcount[getindexclass(cls)];
				return hasil;
			}
						
		public static void main(String[] args) {
				makeclassarray();
				attribut[] arrayattributss = new attribut[mainkolom-1];
				arrayattributss = makepeluang();
				Integer i = 0;
				Integer j = 0;
				Integer k = 0;
				for(i = 0;i < jumlahnilaiatributyangbeda(mainkolom-1);i++){
						for(j = 0;j < arrayattributss[i].values;j++){
								System.out.println(i+" "+arrayattributss[i].valuepoint[j].nama);
								for(k = 0;k < banyakclass;k++) {
										System.out.println(arrayattributss[i].valuepoint[j].classcount[k]);
									}
							}
						System.out.println("\n");
					}
			}
	}
