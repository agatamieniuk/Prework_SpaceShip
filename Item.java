public class Item {
    String name;
    int weight;

    String getName(){
        return name;
    }
    int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
