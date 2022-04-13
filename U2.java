public class U2 extends Rocket{

    double random = (Math.random()*10000)+1;
    double chanceOfExplosion;
    double chanceOfCrash;
    public U2() {
        this.rocketCurrentWeight = 18;
        this.maxWeight = 29;
        this.weight = 18;
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
