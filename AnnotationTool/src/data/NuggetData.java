package data;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * ID, nuggte String and Context
 */

public class NuggetData {

	private int id;
	private String nuggetString;
	private String nuggetContext = "";
	private String nuggetContextBefore = "";
	
	public NuggetData(int id, String nuggetString) {
		this.id = id;
		this.nuggetString = nuggetString;
	}

	public String getNuggetContext() {
		return nuggetContext;
	}

	public void setNuggetContext(String nuggetContext) {
		this.nuggetContext = nuggetContext;
	}

	public int getId() {
		return id;
	}

	public String getNuggetString() {
		return nuggetString;
	}
	
	public String getNuggetContextBefore() {
		return nuggetContextBefore;
	}
	
	public void setNuggetContextBefore(String nuggetContextBefore) {
		this.nuggetContextBefore = nuggetContextBefore;
	}
	
}
