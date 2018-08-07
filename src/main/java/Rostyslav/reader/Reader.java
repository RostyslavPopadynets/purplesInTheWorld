package Rostyslav.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public static List<String> USERS = new ArrayList<>();
	public static List<String> CITYEES = new ArrayList<>();
	public static List<String> COUNTRIES = new ArrayList<>();
	
	public static void read() throws Exception {
		File us = new File("Username.txt");
		File ci = new File("Cityes.txt");
		File co = new File("Countries.txt");
		FileReader frus = new FileReader(us);
		FileReader frci = new FileReader(ci);
		FileReader frco = new FileReader(co);
		BufferedReader brus = new BufferedReader(frus);
		BufferedReader brci = new BufferedReader(frci);
		BufferedReader brco = new BufferedReader(frco);
		
		while(brus.ready()) {
			USERS.add(brus.readLine());
		}
		
		while(brci.ready()) {
			CITYEES.add(brci.readLine());
		}
		
		while(brco.ready()) {
			COUNTRIES.add(brco.readLine());
		}
		brus.close();
		brci.close();
		brco.close();
	}
}
