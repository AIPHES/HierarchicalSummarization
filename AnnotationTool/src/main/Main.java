package main;

import gui.Colorpalette;
import gui.MainWindow;
import inputoutput.LoadGraph;
import inputoutput.LoadNuggets;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import data.Nugget;
import data.NuggetList;
import data.NuggetStructure;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * Main class to start the GUI
 */

public class Main {
	
	public static String filename_nugget;
	public static String filename_graph;

	public static void main(String[] args) {
		
		Colorpalette.setColors();
		
		// Local debug files, if no input txt is selected
		// Does not matter if these dont exist
		filename_nugget = "D:/Nuggets.txt";
		filename_graph = "D:/Nuggets.xml";
		
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "txt";
			}
			
			@Override
			public boolean accept(File f) {
				return (f.isDirectory() || f.getName().endsWith(".txt"));
			}			
			
		});
		
		try {
			
			File dir;
			dir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			if (dir.exists()) {
				fc.setCurrentDirectory(dir);
			}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//In response to a button click:
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filename_nugget = file.getAbsolutePath();
    		filename_graph = file.getAbsolutePath() + ".xml";
        }
		
		// First: Load the nuggets from the input txt
		HashMap<Integer, Nugget> nuggetMap = LoadNuggets.loadNuggetsFromFile(filename_nugget);
		
		// Create empty lists for remaining nuggets and trash
		NuggetList nl = new NuggetList();
		NuggetList tl = new NuggetList();
		
		// Create empty hierarchy with associated trash list
		NuggetStructure ns = new NuggetStructure(tl);
		
		// Now load the xml file (if any)
		LoadGraph.loadGraph(nuggetMap, ns, filename_graph);
		
		// Everything that is left is either trash or remaining nuggets
		for (Nugget n : nuggetMap.values()) {
			if (n.isTrash()) {
				tl.addNugget(n);
			} else {
				nl.addNugget(n);
			}
		}
		
		// Now show me the window
		MainWindow mainWindow = new MainWindow(ns, nl, tl);
		mainWindow.setVisible(true);
		
	}
	
	// Almost same code as before - can be consolidated
	// Open another txt / xml file
	public static boolean openFile() {
		
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "txt";
			}
			
			@Override
			public boolean accept(File f) {
				return (f.isDirectory() || f.getName().endsWith(".txt"));
			}			
			
		});
		
		try {
			
			File dir;
			dir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			if (dir.exists()) {
				fc.setCurrentDirectory(dir);
			}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//In response to a button click:
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filename_nugget = file.getAbsolutePath();
    		filename_graph = file.getAbsolutePath() + ".xml";
        } else {
        	return false;
        }
		
		HashMap<Integer, Nugget> nuggetMap = LoadNuggets.loadNuggetsFromFile(filename_nugget);
		
		NuggetList nl = new NuggetList();
		NuggetList tl = new NuggetList();
		
		NuggetStructure ns = new NuggetStructure(tl);
		
		LoadGraph.loadGraph(nuggetMap, ns, filename_graph);
		
		for (Nugget n : nuggetMap.values()) {
			if (n.isTrash()) {
				tl.addNugget(n);
			} else {
				nl.addNugget(n);
			}
		}
		
		MainWindow mainWindow = new MainWindow(ns, nl, tl);
		mainWindow.setVisible(true);
		
		return true;
		
	}
	
}
