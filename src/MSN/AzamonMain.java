package MSN;

import java.util.List;
import java.util.Properties;
import java.util.Iterator;

import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.Problem;
import aima.search.informed.HillClimbingSearch;

public class AzamonMain {

    public static void main(String[] args) {

        AzamonState state = new AzamonState(10, 1, 0);

        HillClimbingMSN(state);
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
            String action = (String) actions.get(i);
            System.out.println(action);
        }
    }
    
}
