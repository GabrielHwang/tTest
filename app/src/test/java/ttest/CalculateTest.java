package ttest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @Test
    public void calculateTest() {
        Calculate calculate = new Calculate(400,4000,10);
        List<Double> calculateInfoTest = calculate.calculateInfo();
        System.out.println(calculateInfoTest);
        assertEquals(21.0, calculateInfoTest.get(0));
        assertEquals(4394.5276, calculateInfoTest.get(1));
        assertEquals(59.972400000000015,calculateInfoTest.get(2));

    }
    @Test
    public void getTotalFeeTest(){
        Calculate calculate =new Calculate(400,4000,10);
        double totalFee = calculate.getTotalFee();
        assertEquals(59.972400000000015, totalFee);
    }
    @Test
    public void getTotalProfit(){
        Calculate calculate =new Calculate(400,4000,10);
        double totalFee = calculate.getTotalProfit();
        assertEquals(3994.5276000000003, totalFee);
    }
    @Test
    public void MaxLossTest() {
        Calculate calculate = new Calculate(400, 4000, 10);
        int days = calculate.MaxLoss(10);
        assertEquals(18,days);
    }
}
