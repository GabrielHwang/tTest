package ttest;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    Calculate(int init_funding,int target_funding,int lever) {
        this.initial_funding = init_funding;
        this.target_funding = target_funding;
        this.lever = lever;
    }
    Calculate(int target_funding,int lever){
        this.target_funding = target_funding;
        this.lever = lever;
    }
    int day = 0;
    int lever;
    double initial_funding;
    double target_funding;
    double final_funding = 0;
    final double fee = 0.00018;
    final double max_loss_per = 0.02;
    final double profit_margin_for_weekday = 0.01;
    final double profit_margin_for_weekend = 0.02;

    /**
     * calculate treading information about total profits and fees
     */
    public List<Double> calculateInfo() {
        ArrayList<Double> result = new ArrayList<>();
        if (initial_funding > target_funding) {
            System.out.println("target should be bigger than initial_founding");
            return null;
        }
        //TODO exception
        if (initial_funding < 200) {
            System.out.println("you need more than 200 to trading");
            return null;
        }
        double owned = initial_funding;
        double profitOfDay;
        double feeOfDay;
        double totalFee = 0;
        double totalProfit = 0;
        for (int d = 1; owned < target_funding; d++) {
            profitOfDay = lever * ((d % 7 == 0 || d % 6 == 0) ?
                    owned * profit_margin_for_weekend :
                    owned * profit_margin_for_weekday);
            feeOfDay = owned * lever * fee;
            owned += (int) (profitOfDay - feeOfDay);
            day = d;
            final_funding = owned;
            totalFee += feeOfDay;
            totalProfit += (profitOfDay - feeOfDay);
           System.out.println("Day:" + day + "   profit -> " + String.format("%.2f", profitOfDay)
                   + "   fee:   " + String.format("%.2f", feeOfDay)
                   + "   All: " + final_funding);
        }
        result.add((double) day);
        result.add(totalProfit);
        result.add(totalFee);
        return result;
    }

    /**
     * get total profits from initial to target with lever
     * */
    public double getTotalProfit() {
        List<Double> info = calculateInfo();
        double total_profit;
        total_profit = info.get(1) - initial_funding;
        return total_profit;
    }

    /**
     * get total fees from initial to target with lever
     * */
    public double getTotalFee() {
        List<Double> info = calculateInfo();
        return info.get(2);
    }
    /**
     * get total days from initial to target with lever
     * */
    public double getDays() {
        List<Double> info = calculateInfo();
        return info.get(0);
    }
    /**
     * given a specific target that can be calculated
     * how many days loss it from initial funding
     * */
    public int MaxLoss(int target) {
        if (target < 200) {
            System.out.println("you need more than 200 to trading");
            return -1;
        }
        int day = 1;
        double owned = initial_funding;
        while (owned > target) {
            owned -= (owned * max_loss_per * lever);
            day ++;
        }
       return day;
    }
    public int pure() {
        double profit_box = 0;
        double owned = initial_funding;
        double profitOfDay;
        double feeOfDay;
        int pure_day = 0;
        for (int d = 1; owned < target_funding; d++) {
            profitOfDay = lever * ((d % 7 == 0 || d % 6 == 0) ?
                    owned * profit_margin_for_weekend :
                    owned * profit_margin_for_weekday);
            feeOfDay = owned * lever * fee;
            profit_box += (int) (profitOfDay - feeOfDay);
            owned = profit_box;
            pure_day = d;
            System.out.println(" day:  "+ d +"   profit-> "
                    + String.format("%.2f", profitOfDay)
                    + "   owned:   " + owned
                    + "  box: "+ profit_box);
        }
        final_funding = profit_box + initial_funding;
        return pure_day;
    }
}