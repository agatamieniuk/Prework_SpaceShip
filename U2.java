public class U2 extends Rocket{

    int costU2 = 120;
    int weightU2 = 18000; //in kg - the same unit of measure as weight of equipment in txt files
    int maxWeightU2 = 29000;
    double random = Math.random();
    double chanceOfExplosion;
    double chanceOfCrash;

    @Override
    public boolean launch() {
        chanceOfExplosion = 0.04*((double) weightU2 + Item.getWeight()/(double) maxWeightU2);
        if(chanceOfExplosion<=random){
            return true;
        }else {
            return false; //exploded
        }
    }

    @Override
    public boolean land() {
        chanceOfCrash = 0.08*((double) weightU2 + Item.getWeight()/(double) maxWeightU2);
        if(chanceOfCrash<=random){
            return true;
        }else {
            return false; //crash
        }
    }
}
