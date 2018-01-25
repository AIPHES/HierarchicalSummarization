package main_compare;

import inputoutput.LoadNuggets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import data.Nugget;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * Container for one dataset (human annotated hierarchies, nuggets and some paths) with some helper methods
 */

public class EvaluationDataset {

	private String[] annotators;
	private String[] filenames;
	private String filenameNuggets;
	private String jointPath;
	private String topic;

	public Set<SameOrderElement> sameElements = new HashSet<SameOrderElement>();
	public HashMap<Integer, Nugget> nuggetMap = new HashMap<Integer, Nugget>();
	
	public EvaluationDataset(String[] annotators, String[] filenames, String filenameNuggets, String jointPath, String topic) {
		
		this.annotators = annotators;
		this.filenames = filenames;
		this.filenameNuggets = filenameNuggets;
		this.jointPath = jointPath;
		this.topic = topic;
		
		resetMaps();
		if (!filenameNuggets.isEmpty()) {
			initNuggetMap(filenameNuggets);
		}
		
	}
	
	public void resetMaps() {
		nuggetMap.clear();
		sameElements.clear();
	}
	
	public void initNuggetMap(String filename) {
		nuggetMap = LoadNuggets.loadNuggetsFromFile(filename);
	}

	public String[] getAnnotators() {
		return annotators;
	}

	public String[] getFilenames() {
		return filenames;
	}

	public String getFilenameNuggets() {
		return filenameNuggets;
	}

	public String getJointPath() {
		return jointPath;
	}

	public String getTopic() {
		return topic;
	}

	public Set<SameOrderElement> getSameElements() {
		return sameElements;
	}

	public HashMap<Integer, Nugget> getNuggetMap() {
		return nuggetMap;
	}
	
	
	
}
