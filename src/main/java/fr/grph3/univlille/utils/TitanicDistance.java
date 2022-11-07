package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Titanic;

public class TitanicDistance implements Distance<Titanic> {

    @Override
    public double distanceManhattan(Titanic p1, Titanic p2) {
    	double distance = 0.0;
    	distance += Math.abs(p1.getPassengerId() - p2.getPassengerId());
    	distance += Math.abs(p1.getSurvived() - p2.getSurvived());
    	distance += Math.abs(p1.getPClass() - p2.getPClass());
    	distance += Math.abs(p1.getSibSp() - p2.getSibSp());
    	distance += Math.abs(p1.getAge() - p2.getAge());
    	distance += Math.abs(p1.getParch() - p2.getParch());
    	distance += Math.abs(p1.getFare() - p2.getFare());
    	
    	//Si c'est le meme nom on ajoute pas de distance, sinon on ajoute 1:
    	if(p1.getName().equals(p2.getName())) {
    		distance += 0;
    	}else{
    		distance += 1;
    	};
    	
    	//SEX
    	if(p1.getSex().equals(p2.getSex())) {
    		distance += 0;
    	}else{
    		distance += 1;
    	};
    	
    	//Ticket
    	if(p1.getTicket().equals(p2.getTicket())) {
    		distance += 0;
    	}else{
    		distance += 1;
    	};
    	
    	//Cabin
    	if((p1.getCabin() == null && p2.getCabin() == null) || (p1.getCabin() != null && p2.getCabin() != null)){
    		distance += 0;
    	}else{
    		distance += 1;
    	};
    	
    	//Embarked
    	if(p1.getEmbarked().equals(p2.getEmbarked())) {
    		distance += 0;
    	}else{
    		distance += 1;
    	};
    
    	
    	return Math.sqrt(distance);
    }
    


    @Override
    public double distanceEuclid(Titanic p1, Titanic p2) {
        return 0;
    }
}
