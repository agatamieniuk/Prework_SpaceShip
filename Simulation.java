import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    List<Item> loadItems(String fileName) throws Exception {
        List<Item> itemList = new ArrayList();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            Item item = new Item();
            String line = scanner.nextLine();
            String[] lineArray = line.split("="); //split txt by"=" sigh
            item.name = lineArray[0];
            item.weight = Integer.parseInt(lineArray[1]);
            itemList.add(item);
        }
        return itemList;
    }

    //!!!!!
    List<Rocket> loadU1(List<Item> itemList) {
        List<Rocket> u1List = new ArrayList();
        Rocket first = new U1();
        for (Item item : itemList) {
            if (first.canCarry(item)) {
                first.carry(item);
            } else { //<=!!!
                u1List.add(first);
                first = new U1();
                first.carry(item);
            }
        }
        if (itemList.size() != 0) {
            u1List.add(first);
        }
        return u1List; //<=!!!
    }

    //!!!!!
    List<Rocket> loadU2(List<Item> itemList) {
        List<Rocket> u2List = new ArrayList();
        Rocket second = new U2();
        for (Item item : itemList) {
            if (second.canCarry(item)) {
                second.carry(item);
            } else { //<=!!!
                u2List.add(second);
                second = new U2();
                second.carry(item);
            }
        }
        if (itemList.size() != 0) {
            u2List.add(second);
        }
        return u2List; //<=!!!
    }

    double runSimulation(List<Rocket> rocketList) {
        System.out.println("rocketList.size() = " + rocketList.size());
        double budget = 0;
        for (Rocket rocket : rocketList) {
            System.out.println("rocket = " + rocket);
            budget = budget + rocket.cost;
            while (!rocket.launch()||!rocket.land() ) {
                budget += rocket.cost;
            }
        }
        return budget;
    }

}
