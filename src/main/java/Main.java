import functions.SineFunction;

public class Main {
    public static void main(String[] args) {
        SineFunction sine = new SineFunction();
        System.out.println(sine.calculate(Math.PI/2, 0.00000000000001));
    }
}
