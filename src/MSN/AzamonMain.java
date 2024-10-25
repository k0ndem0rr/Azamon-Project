package MSN;

import java.util.List;
import java.util.Properties;
import java.util.Iterator;
import java.util.Scanner;

import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.Problem;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

public class AzamonMain {

    public static void main(String[] args) {


        int nPaquetes;
        double ratio;
        int seed;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de paquetes: ");
        nPaquetes = scanner.nextInt();

        System.out.print("Introduce el ratio: ");
        ratio = scanner.nextDouble();

        System.out.print("Introduce la semilla: ");
        seed = scanner.nextInt();

        scanner.close();

        long startTime = System.currentTimeMillis();

        AzamonState state = new AzamonState(nPaquetes, ratio, seed);

        System.out.println(state.getPaquetes());
        System.out.println(state.getOfertas());
        System.out.println(state.toString());

        HillClimbingMSN(state);
        SimulatedAnnealingMSN(state);

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");
    }

    private static void HillClimbingMSN(AzamonState azamon) {
        try{
            Problem problem = new Problem(azamon, new AzamonSuccesorFunction(), new AzamonGoalTest(), new AzamonHeuristicFunction());
            Search search = new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem, search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void SimulatedAnnealingMSN(AzamonState azamon) {
        try{
            Problem problem = new Problem(azamon, new AzamonSuccesorFunctionSA(), new AzamonGoalTest(), new AzamonHeuristicFunction());
            Search search = new SimulatedAnnealingSearch(2000, 100, 5, 0.001);
            SearchAgent agent = new SearchAgent(problem, search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }
        
    }
    
    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i).toString();
            System.out.println(action);
        }
    }
    
}
