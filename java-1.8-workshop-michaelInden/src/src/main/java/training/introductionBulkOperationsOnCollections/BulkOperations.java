package src.main.java.training.introductionBulkOperationsOnCollections;

import java.util.List;
import java.util.ListIterator;
import src.main.java.training.model.Company;

/**
 *
 * @author Hijack
 */
public class BulkOperations {

    public static void main(String[] args) {
        List<String> companies = Company.createDemoData();

        for (String company : companies) {
            System.out.println("company = " + company);
        }

        companies.forEach((String s) -> System.out.println(s));
    }

}
