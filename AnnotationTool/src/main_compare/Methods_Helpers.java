package main_compare;

import inputoutput.LoadGraph;

import java.util.HashMap;
import java.util.Stack;

import data.Bubble;
import data.Nugget;
import data.NuggetList;
import data.NuggetStructure;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * This class contains general helper methods for several evaluation parts
 */

public class Methods_Helpers {

	protected static HashMap<Integer, String> extractNuggetPositionMap(NuggetStructure ns) {
		
		HashMap<Integer, String> nuggetPositions = new HashMap<Integer, String>();
		Stack<Integer> a = new Stack<Integer>();
		
		int stackpos = 1;
		
		for (Bubble b : ns.getMyBubbles()) {
			a.push(stackpos);
			traverseStructure(nuggetPositions, a, b);
			a.pop();
			stackpos++;
		}
		return nuggetPositions;
		
	}

	protected static void traverseStructure(HashMap<Integer, String> nuggetPositions, Stack<Integer> a, Bubble b) {
		
		for (Nugget n: b.getMyNuggets()) {
			// Save Nugget positions in HashMap
			nuggetPositions.put(Integer.parseInt(n.getData().getNuggetString()), convertStackToString(a));
		}
		
		int stackpos = 1;
		
		for (Bubble bn : b.getNextBubbles()) {
			a.push(stackpos);
			traverseStructure(nuggetPositions, a, bn);
			a.pop();
			stackpos++;
		}
		
	}

	protected static String convertStackToString(Stack<Integer> a) {
		
		String s = "|";
		for (Integer i : a) {
			s += (String.valueOf(i) + "|");
		}
		return s;
		
	}

	static NuggetStructure getNuggetsFromFile(String filename_graph) {
		
		NuggetList tl = new NuggetList();
		NuggetStructure ns = new NuggetStructure(tl);
		LoadGraph.loadGraph(null, ns, filename_graph);
		return ns;
		
	}

}
