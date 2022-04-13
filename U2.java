public class U2 extends Rocket{

    double random = Math.random();
    double chanceOfExplosion;
    double chanceOfCrash;
    public U2() {
        this.rocketCurrentWeight = 18000;
        this.maxWeight = 29000;  //in kg - the same unit of measure as weight of equipment in txt files
        this.weight = 18000;
        this.cost = 120;
    }

    @Override
    public boolean launch() {
        chanceOfExplosion = 0.04*((double) rocketCurrentWeight - weight / (double) maxWeight - weight);
        if(chanceOfExplosion<=random){
            return true;
        }else {
            return false; //exploded
        }
    }

    @Override
    public boolean land() {
        chanceOfCrash = 0.08*((double) rocketCurrentWeight - weight / (double) maxWeight - weight);
        if(chanceOfCrash<=random){
            return true;
        }else {
            return false; //crash
        }
    }
}
