package inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import data.Nugget;
import data.NuggetData;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * Load list of nuggets from filename into HashMap
 * Input format is tab seperated list:
 * uniqueID \t nuggetString \t contextBeforeNugget \t contextaAfterNugget
 */

public class LoadNuggets {

	public static HashMap<Integer, Nugget> loadNuggetsFromFile(String filename) {
		
		HashMap<Integer, Nugget> nuggets = new HashMap<Integer, Nugget>();
		
		File file = new File(filename);
		int id;
		String text;
		String context;
		String contextBefore;
		NuggetData newNugget;
		String[] tokens;
		
		try {
			
			Scanner sc = new Scanner(file, "UTF-8");
			
			while (sc.hasNextLine()) {
				
				tokens = sc.nextLine().split("\t");
				
				id = Integer.valueOf(tokens[0]);
				text = tokens[1];
				newNugget = new NuggetData(id, text);
				
				if (tokens.length > 3) {
					contextBefore = tokens[2];
					context = tokens[3];
					newNugget.setNuggetContextBefore(contextBefore);
					newNugget.setNuggetContext(context);
				} else if (tokens.length > 2) {
					context = tokens[2];
					newNugget.setNuggetContext(context);
				}
				
				nuggets.put(id, new Nugget(newNugget));
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuggets;
		
	}
	
}
