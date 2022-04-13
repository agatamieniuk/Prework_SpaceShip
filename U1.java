public class U1 extends Rocket {

    double random = (Math.random()*10000)+1;
    double chanceOfExplosion;
    double chanceOfCrash;

    public U1() {
        this.rocketCurrentWeight = 10;
        this.maxWeight = 18;
        this.weight = 10;
        this.cost = 100;
    }

    @Override
    public boolean launch() {
        chanceOfExplosion = 0.05 * ((double) rocketCurrentWeight - weight / (double) maxWeight - weight);
        boolean result = chanceOfExplosion <= random;
        System.out.println("result = " + result);
        System.out.println("chanceOfExplosion = " + chanceOfExplosion);
        System.out.println("random = " + random);
        System.out.println();
        if (result) {
            return true;
        } else {
            return false; //exploded
        }
    }

    @Override
    public boolean land() {
        chanceOfCrash = 0.01 * ((double) rocketCurrentWeight - weight / (double) maxWeight - weight);
        if (chanceOfCrash <= random) {
            return true;
        } else {
            return false; //crash
        }
    }
}
