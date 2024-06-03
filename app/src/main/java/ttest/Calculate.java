package ttest;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    int day =0;
    double final_funding = 0;
    final double fee = 0.00018;
    final double profit_margin_for_weekday = 0.01;
    final double profit_margin_for_weekend = 0.02;

    /**
     * calculate treading information about total profits and fees
     */
    public List<Double> calculateInfo(int initial_funding, int target_funding, int lever) {
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
    public double getTotalProfit(int initial_funding, int target_funding, int lever) {
        List<Double> info = calculateInfo(initial_funding, target_funding, lever);
        return info.get(1);
    }

    /**
     * get total fees from initial to target with lever
     * */
    public double getTotalFee(int initial_funding, int target_funding, int lever) {
        List<Double> info = calculateInfo(initial_funding, target_funding, lever);
        return info.get(2);
    }
    /**
     * get total days from initial to target with lever
     * */
    public double getDays(int initial_funding, int target_funding, int lever) {
        List<Double> info = calculateInfo(initial_funding, target_funding, lever);
        return info.get(0);
    }
    public double MaxLoss(int initial_funding, int target_funding, int lever) {
        //TODO
        double max_loss_per=0.02;
        double max_loss = 8.0;
        return max_loss;
    }
}