package fr.grph3.univlille.utils;

public class ResourceUtil {

    public static String get(String path) {
        return ResourceUtil.class.getResource(path).toExternalForm();
    }
}
