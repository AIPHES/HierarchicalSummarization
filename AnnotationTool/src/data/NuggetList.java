package data;

import java.util.LinkedList;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * This contains all nuggets that are not yet implemented into the hierarchy
 * There should be one NuggetList for all remaining nuggets, and one additional List for the trashed nuggets
 * that were left out of the hierarchy on purpose
 */

public class NuggetList implements Cloneable {

	private LinkedList<Nugget> nuggetList;
	
	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		
		NuggetList newList = new NuggetList();
		newList.setNuggetList((LinkedList<Nugget>) nuggetList.clone());
		return newList;
		
	}
	
	public NuggetList() {
		nuggetList = new LinkedList<Nugget>();
	}
	
	public void setNuggetList(LinkedList<Nugget> nuggetList) {
		this.nuggetList = nuggetList;
	}
	
	public LinkedList<Nugget> getNuggetList() {
		return nuggetList;
	}
	
	public void addNugget(Nugget nugget) {
		nuggetList.add(nugget);
	}
	
	public void addNuggetOnFront(Nugget nugget) {
		nuggetList.addFirst(nugget);
	}
	
}
