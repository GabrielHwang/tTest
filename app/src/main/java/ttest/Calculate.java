package ttest;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    Calculate(int init_funding,int target_funding,int lever) {
        this.initial_funding = init_funding;
        this.target_funding = target_funding;
        this.lever = lever;
    }
    int day =0;
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
        int day = 1;
        double owned = initial_funding;
        while (owned > target) {
            owned -= (owned * max_loss_per * lever);
            day ++;
        }
       return day;
    }
}