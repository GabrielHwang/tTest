package ttest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @Test
    public void calculateTest() {
        Calculate calculate = new Calculate();
        int result = calculate.calculate_days(400, 4000, 10);
        assertEquals(19,result);
    }
}
