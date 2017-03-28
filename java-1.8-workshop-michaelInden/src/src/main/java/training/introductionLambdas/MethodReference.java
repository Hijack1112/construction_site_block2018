package src.main.java.training.introductionLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import src.main.java.training.model.Company;

/**
 *
 * @author Hijack
 */
public class MethodReference {

    public static void main(String[] args) {
        
        List<String> companies = Company.createDemoData();
        companies.forEach(System.out::println);
        
        companies.sort(MethodReference::stringLengthComparator);
        System.out.println("companies = " + companies);
        
        
    }
    
    public static int stringLengthComparator(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
    
    

}
