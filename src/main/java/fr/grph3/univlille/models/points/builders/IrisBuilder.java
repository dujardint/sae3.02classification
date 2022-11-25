package fr.grph3.univlille.models.points.builders;

import fr.grph3.univlille.models.points.Iris;

public class IrisBuilder {

    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String variety;

    public IrisBuilder withSepalLength(double sepalLength, double sepalWidth, double petalLength, double pet) {
        this.sepalLength = sepalLength;
        return this;
    }

    public IrisBuilder withSepalWidth(double sepalWidth, double sepalLength) {
        this.sepalWidth = sepalWidth;
        return this;
    }

    public IrisBuilder withPetalLength(double petalLength) {
        this.petalLength = petalLength;
        return this;
    }

    public IrisBuilder withPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
        return this;
    }

    public IrisBuilder withVariety(String variety) {
        this.variety = variety;
        return this;
    }

    public Iris build() {
        Iris iris = new Iris();
        iris.setSepalLength(sepalLength);
        iris.setSepalWidth(sepalWidth);
        iris.setPetalLength(petalLength);
        iris.setPetalWidth(petalWidth);
        iris.setCategory(variety);
        return iris;
    }
}
