package src.main.java.training.introductionLambdas;

public class SimpleLambda {

    public static void main(String[] args) {

        MathematicalOperation addition = (x, y) -> {return x + y;};
        int result = addition.doIt(1, 3);
        System.out.println("result = " + result);
        
    }

    @FunctionalInterface
    public interface MathematicalOperation {

        /*public abstract*/ int doIt(int x, int y);

    }

}
