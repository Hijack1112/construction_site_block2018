package src.main.java.training.introductionLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import src.main.java.training.model.Company;

/**
 *
 * @author Hijack
 */
public class LambdaAsParameter {

    public static void main(String[] args) {
        List<String> companies = Company.createDemoData();
        System.out.println("companies = " + companies);

        lambdaAsParameter(companies);
        lambdaAsReturn(companies);
    }

    public static void lambdaAsParameter(List<String> companies) {
        Collections.sort(companies, (str1, str2) -> Integer.compare(str1.length(), str2.length()));

        //until Java 7
//        Collections.sort(companies, new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
                

        System.out.println("companiesSorted = " + companies);
    }
//

    public static void lambdaAsReturn(List<String> companies) {
        companies.sort(compareByLength());
        System.out.println("companiesSortedReverse = " + companies);
    }

//
    public static Comparator<String> compareByLength() {
        return (str1, str2) -> (Integer.compare(str2.length(), str1.length()));
    }
}
