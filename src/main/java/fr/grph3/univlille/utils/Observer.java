package main.java.fr.grph3.univlille.utils;

public interface Observer {
	public void update(Subject subj);
    public void update(Subject subj, Object data);
}
