package ttest;

public class Calculate {
    int day =0;
    double final_funding = 0;
    double profit_margin_for_weekday = 0.01;
    double profit_margin_for_weekend = 0.02;

    /**
     * calculate how many days will take to target
     */
    public int calculate_days(int initial_funding,int target,int lever) {
        if (initial_funding > target) {
            System.out.println("target should be bigger than initial_founding");
            return 0;
        }
        while (initial_funding < target) {
            double profitOfDay = (day % 7 == 0 || day % 6 == 0) ?
                    initial_funding * profit_margin_for_weekend:
                    initial_funding * profit_margin_for_weekday;
            initial_funding += (int) (profitOfDay * lever);
            day +=1;
            final_funding = initial_funding;
            System.out.println("Day:" + day+"   profit -> " +(int)(profitOfDay * lever)+ "   All: " + final_funding);
        }
        return day;
    }

}