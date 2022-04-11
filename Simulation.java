import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    ArrayList<Item> loadItems(String fileName) throws Exception{
        ArrayList itemList = new ArrayList();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            Item item = new Item();
            String line = scanner.nextLine();
            String[] lineArray = line.split("="); //split txt by"=" sigh
            item.name = lineArray[0];
            item.weight = Integer.parseInt(lineArray[1]);
            itemList.add(item);
        }return itemList;
    }

    //!!!!!
    ArrayList<Rocket> loadU1(ArrayList<Item> itemList){
        ArrayList<Rocket> u1List = new ArrayList();
        Rocket rocketU1 = new Rocket();
            for(Item item: itemList) {
                if(rocketU1.canCarry(item)){
                    rocketU1.carry(item);
                } else { //<=!!!
                    u1List.add(rocketU1);
                    rocketU1 = new Rocket();
                    rocketU1.carry(item);
                }
        }
            if (itemList.size() != 0){
                u1List.add(rocketU1);
            } return u1List; //<=!!!
    }
    //!!!!!
    ArrayList<Rocket> loadU2(ArrayList<Item> itemList){
        ArrayList<Rocket> u2List = new ArrayList();
        Rocket rocketU2 = new Rocket();
        for(Item item: itemList) {
            if(rocketU2.canCarry(item)){
                rocketU2.carry(item);
            } else { //<=!!!
                u2List.add(rocketU2);
                rocketU2 = new Rocket();
                rocketU2.carry(item);
            }
        }
        if (itemList.size() != 0){
            u2List.add(rocketU2);
        } return u2List; //<=!!!
    }

    double runSimulation(ArrayList<Rocket> rocketList){
        double budget = 0;
        for (Rocket rocket: rocketList){
            budget = budget + rocket.cost;
            while(!rocket.land() || !rocket.launch()){
                budget += rocket.cost;
            }
        }return budget;
    }

}
