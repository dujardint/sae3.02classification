package main.java.fr.grph3.univlille.utils;

import javax.security.auth.Subject;

public interface Observer {
	
	public void update(Subject subj);
    public void update(Subject subj, Object data);

}