package ttest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @Test
    public void calculateTest() {
        Calculate calculate = new Calculate();
        List<Double> calculateInfoTest = calculate.calculateInfo(400, 4000, 10);
        System.out.println(calculateInfoTest);
        assertEquals(21.0, calculateInfoTest.get(0));
        assertEquals(4394.5276, calculateInfoTest.get(1));
        assertEquals(59.972400000000015,calculateInfoTest.get(2));

    }
    @Test
    public void getTotalFeeTest(){
        Calculate calculate =new Calculate();
        double totalFee = calculate.getTotalFee(400, 4000, 10);
        assertEquals(59.972400000000015, totalFee);
    }
}
