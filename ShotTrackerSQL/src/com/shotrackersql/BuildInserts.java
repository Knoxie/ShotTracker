package com.shotrackersql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class BuildInserts {

	public static void main(String[] args) {

		try {
			TreeSet<String> insertsTables = new TreeSet<String>();
			TreeSet<String> insertsAllKeyTables = new TreeSet<String>();
			File folder = new File(
					"C:\\Users\\Jason\\workspace\\ShotTracker\\Documents\\csv");

			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					// listFilesForFolder(fileEntry);
				} else {
					FileReader fr = new FileReader(fileEntry);
					BufferedReader br = new BufferedReader(fr);

					String line;
					while ((line = br.readLine()) != null) {
						insertsTables.addAll(INSERT.create_tables(new Weapon(line)));
						insertsAllKeyTables.addAll(INSERT.create_allkeytables(new Weapon(line)));
					}
					br.close();
				}
			}

			FileWriter fw = new FileWriter(new File(
					"C:\\Users\\Jason\\workspace\\ShotTracker\\SQL\\Weapons.sql"));
			BufferedWriter bw = new BufferedWriter(fw);

			for (String strInsert : insertsTables)
				bw.append(strInsert + "\n");
			for (String strInsert : insertsAllKeyTables)
				bw.append(strInsert + "\n");
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void listFilesForFolder(final File folder) {

	}
}
