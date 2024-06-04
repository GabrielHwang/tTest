package ttest;

public class Main {
    public static void main(String[] args) {
        int initial = Integer.parseInt(args[0]);
        int target = Integer.parseInt(args[1]);
        int lever = Integer.parseInt(args[2]);
        Calculate calculate = new Calculate(initial, target, lever);
        calculate.calculateInfo();
    }
}
