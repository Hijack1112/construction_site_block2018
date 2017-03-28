package src.main.java.training.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hijack
 */
public class Company {

    public static List<String> createDemoData() {
        List<String> companies = new ArrayList<>(Arrays.asList("PLOT", "CPB", "ECONTROL", "BRZ", "BAWAG"));
        return companies;
    }

}
