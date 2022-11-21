package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.*;
import fr.grph3.univlille.models.points.IPoint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnFactory {

    public List<IColumn> generate(Class<? extends IPoint> dataType) {
        return Arrays.stream(dataType.getDeclaredFields())
                .map(field -> getColumnByType(field.getName(), field.getType()))
                .collect(Collectors.toList());
    }

    private IColumn getColumnByType(String name, Class<?> type) {
        if (type == Integer.class || type == Double.class) return new NumberColumn(name);
        if (type == Boolean.class) return new BooleanColumn(name);
        if (type == String.class) return new StringColumn(name);
        return new NullColumn();
    }
}
