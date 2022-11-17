package fr.grph3.univlille.utils;


public interface Observer {
	
	public void update(Subject subject);
    public void update(Subject subj, Object data);

}
