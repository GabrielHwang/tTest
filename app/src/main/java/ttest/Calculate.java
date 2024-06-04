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
    int lever = 1;
    double initial_funding = 0;
    double target_funding = 0;
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

        double profitOfDay = 0;
        double feeOfDay = 0;
        double totalFee = 0;
        double totalProfit = 0;
        for (int d = 1; initial_funding < target_funding; d++) {
            profitOfDay = lever * ((d % 7 == 0 || d % 6 == 0) ?
                    initial_funding * profit_margin_for_weekend :
                    initial_funding * profit_margin_for_weekday);
            feeOfDay = initial_funding * lever * fee;
            initial_funding += (int) (profitOfDay - feeOfDay);
            day = d;
            final_funding = initial_funding;
            totalFee += feeOfDay;
            totalProfit += profitOfDay - feeOfDay;
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
        return info.get(1);
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
     * given a specific last position that can be calculated
     * how many days loss it from initial funding
     * */
    public int MaxLoss(int lastPosition) {
        int day = 1;
        double position = initial_funding;
        while (position > lastPosition) {
            position -= (position * max_loss_per * lever);
            day ++;
        }
       return day;
    }
}