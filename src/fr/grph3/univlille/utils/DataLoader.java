package fr.grph3.univlille.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


public class DataLoader<T>{

	public List<T> loadFromFile(Class<T> clazz, String path, char separator) throws IOException {
        List<T> res;
        res = new CsvToBeanBuilder<T>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(separator)
                .withType(clazz)
                .build().parse();
        return res;
    }
    
    
    
}
