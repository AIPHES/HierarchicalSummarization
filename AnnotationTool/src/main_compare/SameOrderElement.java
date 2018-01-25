package main_compare;

public class SameOrderElement {

	/**
	 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
	 * 29.09.2017
	 */
	
	/*
	 * This class is needed to compare annotator aggreement by matched nugget tupels 
	 * A total of <sameAnnotators> annotators aggreed that <element1> and <element2> have <myType> relation
	 */
	
	public enum sameType {PARENT, CLUSTER};
	
	private sameType myType;
	private int element1;
	private int element2;
	private int sameAnnotators;
	
	public SameOrderElement(sameType myType, int element1, int element2, int sameAnnotators) {
		
		this.myType = myType;
		this.element1 = element1;
		this.element2 = element2;
		this.sameAnnotators = sameAnnotators;
		
	}
	
	public int getElement1() {
		return element1;
	}
	
	public int getElement2() {
		return element2;
	}
	
	public sameType getMyType() {
		return myType;
	}
	
	public int getSameAnnotators() {
		return sameAnnotators;
	}
	
}
