package fr.grph3.univlille.utils.parsers;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.builders.IrisBuilder;

import java.util.List;

public class IIrisParser extends IPointParser<Iris> {

    public IIrisParser(List<INormalizableColumn> columns) {
        super(columns);
    }

    @Override
    public Iris parse(String line) {
        String[] args = line.split(" ");
        try {
            return new IrisBuilder()
                    .withPetalLength(Double.parseDouble(parseArg("petal.length", args)))
                    .withPetalWidth(Double.parseDouble(parseArg("petal.width", args)))
                    .withSepalLength(Double.parseDouble(parseArg("sepal.length", args)))
                    .withSepalWidth(Double.parseDouble(parseArg("sepal.width", args)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
