package fr.grph3.univlille.utils.parsers;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class IPointParser {

    private List<INormalizableColumn> columns;

    public IPointParser() {
        this.columns = new ArrayList<>();
    }

    public void initColumns(List<INormalizableColumn> columns) {
        this.columns = columns;
    }

    public abstract IPoint parse(String line);

    protected String parseArg(String token, String[] args) {
        return args[tokenPosition(token)];
    }

    protected int tokenPosition(String token) {
        System.out.println(token);
        String[] split = token.split(" ");
        return IntStream.range(0, split.length)
                .filter(i -> split[i].equals("${" + token + "}"))
                .findFirst()
                .orElse(0);
    }

    public String format() {
        return columns.stream()
                .map(c -> "${" + c.getName() + "} ")
                .collect(Collectors.joining());
    }

    public List<INormalizableColumn> getColumns() {
        return columns;
    }
}
