package data;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * A single information nugget
 */

public class Nugget {

	// This contains id, nugget String and context
	private NuggetData data;
	
	// Helper for GUI
	private boolean clicked;
	private boolean isTrash;
	
	public boolean isClicked() {
		return clicked;
	}

	public Nugget(NuggetData data) {
		this.data = data;
		clicked = false;
	}

	public String getNuggetString() {
		return data.getNuggetString();
	}
	
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public NuggetData getData() {
		return data;
	}

	public boolean isTrash() {
		return isTrash;
	}

	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}
	
}
