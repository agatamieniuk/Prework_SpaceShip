import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        Simulation simulation = new Simulation();

//        File phase1File = new File("phase-1.txt");
//        File phase2File = new File("phase-2.txt");

        ArrayList<Item> phase1Item = new ArrayList<Item>();
        phase1Item = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2Item = new ArrayList<Item>();
        phase2Item = simulation.loadItems("phase-2.txt");

        ArrayList<Rocket> phase1U1 = new ArrayList<Rocket>();
        System.out.println("\nLoading UOne rockets with Phase 1 Items");
        phase1U1 = simulation.loadU1(phase1Item);
        System.out.println("Loading UOne rockets with Phase 2 Items");
        ArrayList<Rocket> phase1U2 = new ArrayList<Rocket>();
        phase1U2 = simulation.loadU1(phase2Item);

        System.out.println("Simulation U1: ");
        double trial = simulation.runSimulation(phase1U1);
        double trial2 = simulation.runSimulation(phase1U2);
        System.out.println(trial+trial2);

        System.out.println("Simulation U2: ");
        double trial3 = simulation.runSimulation(phase1U1);
        double trial4 = simulation.runSimulation(phase1U2);
        System.out.println(trial3+trial4);



    }
}
