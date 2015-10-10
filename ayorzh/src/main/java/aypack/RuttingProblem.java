package aypack;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;

public class RuttingProblem extends AbstractProblem {
    public RuttingProblem () {
        super(5,2);
    }

    public static List<String> read_calibrationfile(String source) throws IOException {
        int i = 0;
        InputStream f = new FileInputStream(source);
        Scanner input = new Scanner(System.in);
        List<String> whole_file = new ArrayList<String>();
        input = new Scanner(f);

        while (input.hasNextLine())
        {
            i++;
            String line = input.nextLine();

            if (i<21){
                String[] str_arr = line.split("	");
                for (int j=0; j < str_arr.length; j++){
                    whole_file.add(str_arr[j]);
                }
            }
            if (i > 20 && i <24){
                String[] str_arr = line.split(" ");
                for (int j=0; j < str_arr.length; j++){
                    whole_file.add(str_arr[j]);
                }
            }
            if (i>23){
                String[] str_arr = line.split("		");
                for (int j=0; j < str_arr.length; j++){
                    whole_file.add(str_arr[j]);
                }
            }
        }
        f.close();
        input.close();
        return whole_file;
    }

    @Override
    public Solution newSolution() {
        // MOEA framework demands the structure to use SOLUTION method
        //1. Create "solution" variable with parameters (5 calibration factors, 2 objective functions)
        //2. Set constraints to the calibration factors (from 0 to 10)

        // 1.
        Solution solution = new Solution(numberOfVariables,
                numberOfObjectives);
        // 2.
        solution.setVariable (0, EncodingUtils.newReal(0.0, 10.0));
        solution.setVariable (1, EncodingUtils.newReal(0.0, 10.0));
        solution.setVariable (2, EncodingUtils.newReal(0.0, 10.0));
        solution.setVariable (3, EncodingUtils.newReal(0.0, 10.0));
        solution.setVariable (4, EncodingUtils.newReal(0.0, 10.0));
        return solution;
    }

    @Override
    public void evaluate(Solution solution) {
        // MOEA framework demands the structure to use EVALUATE method
        //1. Extract suggested by "Solution method" factors to x1..5 variables
        //2. Read and re-write CalibrationFactors.dat with new factors from x1..x5
        //3. Run apads.exe
        //4. Calculate objective functions f1, f2

        //TODO: implement parallelization

        // 1.
        double x1 = EncodingUtils.getReal(solution.getVariable(0));
        double x2 = EncodingUtils.getReal(solution.getVariable(1));
        double x3 = EncodingUtils.getReal(solution.getVariable(2));
        double x4 = EncodingUtils.getReal(solution.getVariable(3));
        double x5 = EncodingUtils.getReal(solution.getVariable(4));

        // 2.
        // a. Create a variable that stores all the data from the CalibrationFactors file
        String source = "C:/1/CalibrationFactor.dat";
        try {
            List<String> new_list = read_calibrationfile(source);

            // b. Apply new values of calibration factors, suggested by Solution method
            new_list.set(17, String.valueOf(x1));
            new_list.set(18, String.valueOf(x2));
            new_list.set(19, String.valueOf(x3));
            new_list.set(32, String.valueOf(x4));
            new_list.set(34, String.valueOf(x5));

            // c. Re-write CalibrationFactors.dat with new factors
            write_file(new_list);

            // 3. Run apads.exe
            run_apads();

            // 4. If process of apads.exe is completed: calculate objective functions
            // Ensure parallelization thread.wait() or framework tools

            String filename1 = "C:/1/120101-1.txt";
            String filename2 = "C:/1/.rut";
            double f1 = calculateObjFn(filename1, filename2, "MSE");
            double f2 = calculateObjFn(filename1, filename2, "STDE");

            solution.setObjective(0, f1);
            solution.setObjective(1, f2);

            // Ensure that "no file" error is handled correctly
        } catch (IOException ie) {
            ie.printStackTrace(); }
    }

    public static void write_file(List<String> output) throws IOException {
        int i=0;
        BufferedWriter writer = null;
        List<String> o = output;
        String eol = System.getProperty("line.separator");
        String tab = "\t";
        writer = new BufferedWriter(new FileWriter("C:/1/CalibrationFactor.dat"));
        writer.write(o.get(0)+ eol + o.get(1) + eol + o.get(2) + eol + o.get(3) + eol + o.get(4) + tab + o.get(5) + eol);
        for (i=6; i < 12; i++) {writer.write(o.get(i) + tab);}
        writer.write(eol + o.get(12)+ eol + o.get(13)+ eol);

        for (i=14; i < 20; i++) {writer.write(o.get(i) + tab);}

        writer.write(eol + o.get(20)+ eol + o.get(21)+ eol);
        for (i=22; i < 26; i++) {writer.write(o.get(i) + tab);}
        writer.write(eol + o.get(26)+ eol + o.get(27)+ eol + o.get(28) + tab + o.get(29) + eol + o.get(30) + eol + o.get(31)+ eol);
        for (i=32; i < 40; i++) {writer.write(o.get(i) + tab);}
        writer.write(eol + o.get(40)+ eol + o.get(41)+ tab + o.get(42)+ tab + o.get(43) + eol);
        for (i=44; i < 52; i++) {writer.write(o.get(i) + " ");}
        writer.write(eol);
        for (i=52; i < 60; i++) {writer.write(o.get(i) + " ");}
        writer.write(eol);
        for (i=60; i < 68; i++) {writer.write(o.get(i) + " ");}
        writer.write(eol);
        for (i=68; i < 152; i=i+2) {writer.write(o.get(i) + tab + tab + o.get(i+1));
            writer.write(eol);}
        writer.close();
    }

    public static void run_apads () throws IOException{
        //1. Set path to apads.exe
        //2. Set options to run apads.exe (open cmd, start file, windows caption "running apads", filename, argument "\.dgd")
        //3. Run apads.exe
        //4. Wait for apads to finish working (1000ms * 60 * 4 = 4 min)
        Thread t = Thread.currentThread();
        String fileName = "c:\\1\\Flexible\\apads.exe";
        String[] commands = {"cmd", "/c", "start", "\"Running apads\"",fileName, "c:\\1\\.dgd"};

        Process process = Runtime.getRuntime().exec(commands);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Double calculateObjFn(String source, String source1, String obj_fun) throws IOException {
        //First we create objects, which help to read files
        String source2 = "C:/1/rut.tmp";
        InputStream f = new FileInputStream(source);
        InputStream f1 = new FileInputStream(source1);
        InputStream f2 = new FileInputStream(source2);

        Scanner input_measured = new Scanner(System.in);
        Scanner input_dotrut = new Scanner(System.in);
        Scanner input_ruttmp = new Scanner(System.in);


        input_measured = new Scanner(f);
        input_dotrut = new Scanner(f1);
        input_ruttmp = new Scanner(f2);

        // Here we declare variables which we use to calculate objective functions
        Double result = 0.0; 	// Output of method
        Double mse = 0.0; 		// Mean squared error (MSE)
        Double stde = 0.0; 		// Standard deviation of errors (STDE)

        // Below are auxiliary variables
        Double sse = 0.0;
        Double mean = 0.0;
        Double submean = 0.0;
        Double sr = 0.0;
        Integer num = 0;

        // For each file, which we read (dotrut, and measured data files) we create two lists
        // keys - for a number of months, values - for the value of rutting
        // So far we use only two files - one rut file and one file with measured data 120101-1.txt
        List<Double> dotrut_values = new ArrayList<Double>();
        List<Double> dotrut_keys = new ArrayList<Double>();
        List<Double> meas_values = new ArrayList<Double>();
        List<Double> meas_keys = new ArrayList<Double>();

        // Since our files start with "columns' descriptions we skip first row
        int k = 0;
        int m = 0;
        input_measured.nextLine();
        input_ruttmp.nextLine();

        while (input_dotrut.hasNextLine())
        {
            String line = input_dotrut.nextLine();
            if (line.contains("Total Permanent Deformation")) {
                input_dotrut.nextLine();
                break;
            }
        }

        // We read each line of file with measured data and write months' numbers and rut values
        // in lists: keys and values.
        while (input_measured.hasNextLine()){
            String line_measured = input_measured.nextLine();
            String[] str_arr_measured = line_measured.split(", ");
            for (int j=0; j < 1; j++){
                meas_keys.add(Double.parseDouble((str_arr_measured[0])));
                meas_values.add(Double.parseDouble(str_arr_measured[1]));
            }
        }
        input_measured.close();

        // We do similar with dotrut file
        while (input_dotrut.hasNextLine()){
            String line_dotrut = input_dotrut.nextLine();
            String[] str_arr_dotrut = line_dotrut.split("	");
            String line_ruttmp = input_ruttmp.nextLine();
            String[] str_arr_ruttmp = line_ruttmp.split(",");
            for (int i=0; i < 1; i++){
                dotrut_keys.add(Double.parseDouble((str_arr_ruttmp[0])));
                dotrut_values.add(Double.parseDouble(str_arr_dotrut[0])*25.4);
            }
        }
        input_ruttmp.close();
        input_dotrut.close();

        // For each month of dotrut file we check weather we have the same month in file with measured data
        // and if month are equal, we compare rutting values
        // With "sse" variable I subtract dotrut value from each measured value, square the result and
        // add it to the previous value. Thus I get a sum of square errors.
        //
        //If we need to calculate the relative error - write me another equation.
        // sq = sse
        //With "submean" variable I sum up the errors
        // "num" variable stores the number of elements
        for (k = 0; k < dotrut_keys.size(); k++) {
            for (m = 0; m < meas_keys.size(); m++){
                if (dotrut_keys.get(k).equals(meas_keys.get(m)) ) {
                    sse = sse + Math.pow((dotrut_values.get(k) - meas_values.get(m)), 2);
                    submean = submean + (dotrut_values.get(k) - meas_values.get(m));
                    num++;
                }
            }
        }

        // Here we calculate arithmetic mean
        mean = submean/num;
        // Below we calculate a sum of squares of error - mean_error, in order to
        // calculate variance and standard deviation later
        for (k = 0; k < dotrut_keys.size(); k++) {
            for (m = 0; m < meas_keys.size(); m++){
                if (dotrut_keys.get(k).equals(meas_keys.get(m)) ) {
                    sr = sr + Math.pow((dotrut_values.get(k) - meas_values.get(m) - mean), 2);
                }
            }
        }

        // Below we calculate standard deviation of errors "stde" and mean square error 'mse"
        stde = Math.sqrt(sr/(num-1));
        mse = sse/num;

        // Hypothetically it could be good to use only one method to calculate different objective functions
        // Here we would add another while loop to read another measured data file and another similar
        // for loop to calculate a 3rd objective function

        if (obj_fun == "MSE"){
            result = mse;
        }
        if (obj_fun == "STDE"){
            result = stde;
        }
        if (obj_fun == "3rd function"){
            result = null; // any other thing we want to calculate
        }
        // ... etc

        f.close();
        f1.close();
        return result;
    }
}
