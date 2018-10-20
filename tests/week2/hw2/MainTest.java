package week2.hw2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void leapYearCount() {
        Assert.assertEquals(0, Main.leapYearCount(1));
        Assert.assertEquals(1, Main.leapYearCount(4));
        Assert.assertEquals(24, Main.leapYearCount(100));
    }
}
