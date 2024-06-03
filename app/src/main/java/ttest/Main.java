package ttest;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        int initial = Integer.parseInt(args[0]);
        int target = Integer.parseInt(args[1]);
        int lever = Integer.parseInt(args[2]);
        calculate.calculateInfo(initial, target, lever);
    }
}
