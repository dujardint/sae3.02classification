package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NullColumn;

public class ColumnFactory {

    public IColumn createColumn(String name) {
        return new NullColumn();
    }
}
