package stingion.diff;

import java.util.*;

/**
 * Created by imalysh on 12/30/2014.
 */
public class Go {
    public static void main(String[] args) {
        String line = "23, 33, 11, 1, 10, 0";
        line = "";
        System.out.println((new Go().convert(line.split(","))));
        System.out.println(new HashSet<Long>(Arrays.asList(new Long[0])));
        System.out.println(new HashSet<>(0).isEmpty());

//        Integer[] int1=new Go().convert(line.split(","));
//        Set set = new HashSet<Integer>(Arrays.asList(int1));
//        System.out.println(set);
    }

    /**
     * Convert String line to Long set with default splitter of "," sign (service method only)
     *
     * @param inLine Line with numbers for conversion
     * @return Long set
     */
    private Set<Long> convert(String inLine) {
        return convert(inLine, ",");
    }

    /**
     * Convert String line to Long set (service method only)
     *
     * @param inLine   Line with numbers for conversion
     * @param splitter (by default it's "," sign)
     * @return Long set
     */
    private Set<Long> convert(String inLine, String splitter) {
        return convert(inLine.split(splitter));
    }

    /**
     * Convert String array to Long set (service method only)
     *
     * @param inArr String array
     * @return Long set
     */
    private Set<Long> convert(String[] inArr) {
        // In case of inArr is empty or consist of spaces only
        if (inArr.length == 1 && inArr[0].trim().equals(""))
            return new HashSet<Long>(0);

        Long[] outArr = new Long[inArr.length];

        for (int i = 0; i < inArr.length; i++) {
            outArr[i] = Long.valueOf(inArr[i].trim());
        }

        return new HashSet<Long>(Arrays.asList(outArr));
    }
}
