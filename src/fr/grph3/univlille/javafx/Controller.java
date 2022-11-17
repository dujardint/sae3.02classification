package fr.grph3.univlille.javafx;

public class Controller {
	protected View view;
	
	public Controller(View view) {
		this.view = view;
	}
	
	public Controller() {
		this(null);
	}
	
	public View getView() {
		return this.view;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void closeView() {
		if(this.getView().getStage() != null) {			
			this.getView().getStage().close();
		}
	}

}
