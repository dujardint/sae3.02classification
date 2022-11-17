package fr.grph3.univlille.utils.normalizers;

public class BooleanNormalizer implements INormalizer {

    @Override
    public double normalize(Object value) { //on peut ajouter le p1 et p2 ici ?
        //on ne peut pas normaliser un boolean

        if((boolean) value){
            return 0;
        }
        return 1;
    }

    @Override
    public Object denormalize(double value) {
        //on ne peut pas dénormaliser un boolean car on ne peux pas le normaliser
        if(value == 0){
            return 0;
        }
        return 1;

        // Ou juste : return value;
    }
}
