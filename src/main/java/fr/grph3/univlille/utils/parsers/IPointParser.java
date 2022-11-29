package fr.grph3.univlille.utils.parsers;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class IPointParser<T extends IPoint> {

    private List<INormalizableColumn> columns;

    public IPointParser(List<INormalizableColumn> columns) {
        this.columns = columns;
    }

    public abstract T parse(String line);

    protected String parseArg(String token, String[] args) {
        return args[tokenPosition(token)];
    }

    protected int tokenPosition(String token) {
        String[] split = token.split(" ");
        return IntStream.range(0, split.length)
                .filter(i -> split[i].equals("${" + token + "}"))
                .findFirst()
                .orElse(-1);
    }

    public String format() {
        return columns.stream()
                .map(c -> "${" + c.getName() + "} ")
                .collect(Collectors.joining());
    }
}
