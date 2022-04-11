public class U1 extends Rocket{

    int costU1 = 100;
    int weightU1 = 10000; //in kg - the same unit of measure as weight of equipment in txt files
    int maxWeightU1 = 18000;
    double random = Math.random();
    double chanceOfExplosion;
    double chanceOfCrash;

    @Override
    public boolean launch() {
        chanceOfExplosion = 0.05*((double) weightU1 + Item.getWeight()/(double) maxWeightU1);
        if(chanceOfExplosion<=random){
            return true;
        }else {
            return false; //exploded
        }
    }

    @Override
    public boolean land() {
        chanceOfCrash = 0.01*((double) weightU1 + Item.getWeight()/(double) maxWeightU1);
        if(chanceOfCrash<=random){
            return true;
        }else {
            return false; //crash
        }
    }
}
