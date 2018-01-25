package main_compare;

import java.util.List;

import data.Bubble;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * This contains one possible position to add a nugget into the (gold) hierarchy
 * In the optimization loop, we iterate all possible actions and take the best result
 */

public class PossibleAction {

	private Bubble b;
	private boolean before = false;
	private boolean after = false;
	private boolean branch = false;
	private List<Bubble> additionalChildren = null;
	private double score = 0;
	
	public PossibleAction(Bubble b, boolean before, boolean after, boolean branch, List<Bubble> additionalChildren) {
		this.b = b;
		this.before = before;
		this.after = after;
		this.branch = branch;
		this.additionalChildren = additionalChildren;
	}
	
	public PossibleAction(Bubble b, boolean before, boolean after, boolean branch) {
		this.b = b;
		this.before = before;
		this.after = after;
		this.branch = branch;
	}
	
	public Bubble getB() {
		return b;
	}

	public boolean isBefore() {
		return before;
	}

	public boolean isAfter() {
		return after;
	}

	public boolean isBranch() {
		return branch;
	}
	
	public List<Bubble> getAdditionalChildren() {
		return additionalChildren;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
	
}
