package main_compare;

import java.util.HashSet;

import data.Bubble;
import data.Nugget;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * This class contains the code for the new hierarchy overlap measure
 */

public class Methods_Hierarchy_Overlap {

	protected static double calculate_union_intersect(Integer number, Bubble b_1, Bubble b_2, boolean include_parents, boolean include_children) {
		
		HashSet<Integer> set_1 = new HashSet<Integer>();
		set_1.add(number);
		if (b_1 != null) {
			if (include_parents) addParentIntegers(set_1, b_1);
			if (include_children) addChildrenIntegers(set_1, b_1);
		}
		
		HashSet<Integer> set_2 = new HashSet<Integer>();
		set_2.add(number);
		if (b_2 != null) {
			if (include_parents) addParentIntegers(set_2, b_2);
			if (include_children) addChildrenIntegers(set_2, b_2);
		}
		
		HashSet<Integer> set_intersect = new HashSet<Integer>();
		set_intersect.addAll(set_1);
		set_intersect.retainAll(set_2);
		
		HashSet<Integer> set_union = new HashSet<Integer>();
		set_union.addAll(set_1);
		set_union.addAll(set_2);
		
		return ( (double) set_intersect.size() / (double) set_union.size() );
		
	}

	protected static void addParentIntegers(HashSet<Integer> s, Bubble b) {
		
		for (Nugget n : b.getMyNuggets()) {
			s.add(n.getData().getId());
		}
		
		if (b.getPreviousBubble() != null) {
			addParentIntegers(s, b.getPreviousBubble());
		}
		
	}

	protected static void addChildrenIntegers(HashSet<Integer> s, Bubble b) {
		
		for (Nugget n : b.getMyNuggets()) {
			s.add(n.getData().getId());
		}
		
		for (Bubble child : b.getNextBubbles()) {
			addChildrenIntegers(s, child);
		}
		
	}

	
	
}
