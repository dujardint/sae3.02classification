package fr.grph3.univlille.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> attached;

    public Subject() {
        attached = new ArrayList<>();
    }

    public void attach(Observer obs) {
        if (!attached.contains( obs)) {
            attached.add(obs);
        }
    }

    public void detach(Observer obs) {
        attached.remove(obs);
    }

    public void notifyObservers() {
        attached.forEach(o -> o.update(this));
    }


    public void notifyObservers(Object data) {
        attached.forEach(o -> o.update(this, data));
    }
}
