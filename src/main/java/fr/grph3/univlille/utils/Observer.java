package fr.grph3.univlille.utils;

public interface Observer {
        void update(Subject subj);
        void update(Subject subj, Object data);
}
