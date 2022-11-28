package fr.grph3.univlille.utils;

import com.opencsv.bean.CsvBindByName;
import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.*;
import fr.grph3.univlille.models.points.IPoint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnFactory {

    public List<IColumn> generate(Class<? extends IPoint> dataType, IDataSet dataSet) {
        return Arrays.stream(dataType.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(CsvBindByName.class))
                .map(field -> getColumnByType(field.getAnnotation(CsvBindByName.class).column(), dataSet, field.getType()))
                .collect(Collectors.toList());
    }

    private IColumn getColumnByType(String name, IDataSet dataSet, Class<?> type) {
        if (type == Integer.class || type == Double.class || type == Float.class) return new NumberColumn(name, dataSet);
        if (type == Boolean.class) return new BooleanColumn(name, dataSet) ;
        if (type == String.class) return new StringColumn(name, dataSet);
        return new NullColumn();
    }
}
