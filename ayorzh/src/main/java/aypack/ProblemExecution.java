package aypack;

import java.io.*;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import java.io.*;

public class ProblemExecution {

    public static void main (String[] args) throws IOException {
        NondominatedPopulation result = new Executor()
                .withProblemClass(RuttingProblem.class)
                .withAlgorithm("NSGAII")
                .withMaxEvaluations(21)
                .withProperty("populationSize", 10)
                        //.distributeOnAllCores() - runs 4 instances of apads for my quad core
                .run();

        for (Solution solution : result) {
            System.out.println(solution.getObjective(0) + " " + solution.getObjective(1));
            System.out.println(solution.getVariable(0) + " " + solution.getVariable(1) + " " + solution.getVariable(2) + " "+ solution.getVariable(3) + " " + solution.getVariable(4));

            //for (int i = 0; i < result.size(); i++) {
            //	Solution solution = result.get(i);
            //	double[] objectives = solution.getObjectives();
            //	System.out.println(objectives[0]);
            //	System.out.println(objectives[1]);
        }
    }
}
