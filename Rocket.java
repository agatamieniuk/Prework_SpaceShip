public class Rocket implements SpaceShip{
    int rocketCurrentWeight;
    int maxWeight;
    int weight;
    double cost;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) { //can carry item or it will exceed the weight limit.
        if(maxWeight>=item.weight + rocketCurrentWeight){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public final int carry(Item item) { //updates the current weight
        rocketCurrentWeight = item.weight + rocketCurrentWeight;
        return rocketCurrentWeight;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocketCurrentWeight=" + rocketCurrentWeight +
                ", maxWeight=" + maxWeight +
                ", cost=" + cost +
                '}';
    }
}
//final - nie pozwala na nadpisanie pozniej
