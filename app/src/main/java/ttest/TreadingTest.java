package ttest;

public class TreadingTest {
    int day =1;
    double final_funding = 0;
    double profit_margin_for_weekday = 0.01;
    double profit_margin_for_weekend = 0.02;

    public int calculateMoney(int initial_funding,int target,int lever) {
        if (initial_funding < target) {
            System.out.println("target should be bigger than initial_founding");
        }
        for (int d =1;initial_funding < target;d++) {
            double profitOfDay = (d%7==0 ||d%6==0) ?
                    initial_funding * profit_margin_for_weekend:
                    initial_funding * profit_margin_for_weekday;
            initial_funding += (int) profitOfDay * lever;
            day = d;
            final_funding = initial_funding;
            System.out.println("Day:" + day+"   profit -> " +(int)profitOfDay+ "   All: " + final_funding);
        }
        return (int)final_funding;
    }

    public static void main(String[] args) {
        TreadingTest treadingTest = new TreadingTest();
        int before_4000 = treadingTest.calculateMoney(400, 4000, 10);
        System.out.println(before_4000);
    }

}