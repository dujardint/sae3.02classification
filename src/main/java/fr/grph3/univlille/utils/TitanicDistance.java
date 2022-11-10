package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.Titanic;

public class TitanicDistance implements Distance<Titanic> {
	
	private TitanicNormalizer nomalizer;
	
    public TitanicDistance(TitanicNormalizer nomalizer) {
		this.nomalizer = nomalizer;
	}

	@Override
    public double distanceManhattan(Titanic p1, Titanic p2) {
    	double distance = 0.0;
    	distance += Math.pow(nomalizer.normalize((p1.getPassengerId()) - nomalizer.normalize(p2.getPassengerId())),2);
    	distance += Math.pow(nomalizer.normalize(p1.getSurvived()) - nomalizer.normalize(p2.getSurvived()),2);
    	distance += Math.pow(nomalizer.normalize(p1.getPClass()) - nomalizer.normalize(p2.getPClass()),2);
    	distance += Math.pow(nomalizer.normalize(p1.getSibSp()) - nomalizer.normalize(p2.getSibSp()),2);
    	distance += Math.pow(nomalizer.normalize(p1.getAge()) - nomalizer.normalize(p2.getAge()),2);
    	distance += Math.pow(nomalizer.normalize(p1.getParch()) - nomalizer.normalize(p2.getParch()),2);
    	distance += Math.pow(nomalizer.normalize(p1.getFare()) - nomalizer.normalize(p2.getFare()),2);
    	
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
    	double distance = 0.0;
    	distance += Math.abs(nomalizer.normalize((p1.getPassengerId()) - nomalizer.normalize(p2.getPassengerId())));
    	distance += Math.abs(nomalizer.normalize(p1.getSurvived()) - nomalizer.normalize(p2.getSurvived()));
    	distance += Math.abs(nomalizer.normalize(p1.getPClass()) - nomalizer.normalize(p2.getPClass()));
    	distance += Math.abs(nomalizer.normalize(p1.getSibSp()) - nomalizer.normalize(p2.getSibSp()));
    	distance += Math.abs(nomalizer.normalize(p1.getAge()) - nomalizer.normalize(p2.getAge()));
    	distance += Math.abs(nomalizer.normalize(p1.getParch()) - nomalizer.normalize(p2.getParch()));
    	distance += Math.abs(nomalizer.normalize(p1.getFare()) - nomalizer.normalize(p2.getFare()));
    	
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
}
