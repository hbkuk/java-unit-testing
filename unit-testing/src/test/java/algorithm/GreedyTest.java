package algorithm;

import org.junit.jupiter.api.Test;

import static algorithm.Greedy.battery;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedyTest {
    @Test
    public void batteryTest() {
        //assertEquals(2, battery(5));
        assertEquals(2, battery(6));
    }
}
