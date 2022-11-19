package com.anuragkapur.ds.graph;

import org.junit.Assert;
import org.junit.Test;

public class CurrencyConversionTest {

    @org.junit.Test
    public void getConversionRate() {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        Assert.assertEquals(0.99, currencyConversion.getConversionRate("USD", "EUR"), 0);
        Assert.assertEquals(0.99*0.85, currencyConversion.getConversionRate("USD", "GBP"), 0);
        Assert.assertEquals(0.99*0.85*94.69, currencyConversion.getConversionRate("USD", "INR"), 0);
        Assert.assertEquals(0.99*0.85*164.35, currencyConversion.getConversionRate("USD", "YEN"), 0);
        Assert.assertEquals(0.99*0.85*164.35*0.011, currencyConversion.getConversionRate("USD", "AUD"), 0);

        Assert.assertEquals(164.35*0.011, currencyConversion.getConversionRate("GBP", "AUD"), 0);
    }

    @Test(expected = RuntimeException.class)
    public void getConversionRateThatIsNotPossible() {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        // cycle detection
        currencyConversion.getConversionRate("USD", "CAD");
    }
}