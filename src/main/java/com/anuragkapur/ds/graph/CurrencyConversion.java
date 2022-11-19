package com.anuragkapur.ds.graph;

import java.util.*;

/**
 * Given a file of currency conversion rates, write a function that converts one currency to another.
 *
 * Sample log file entries:
 * {"from":"USD", "to":"EUR", "rate":0.99}
 * {"from":"EUR", "to":"GBP", "rate":0.85}
 * {"from":"USD", "to":"CNY", "rate":6.76}
 * {"from":"CNY", "to":"EUR", "rate":0.15}
 *
 * Means USD is worth 0.8415 GBP
 */
public class CurrencyConversion {

    private static final Map<String, List<ConversionRate>> conversionRatesFromGivenCurrency = new HashMap<>();

    public double getConversionRate(String from, String to) {

        Set<String> cycleDetection = new HashSet<>();

        Queue<ConversionStep> conversionsStepsQueue = new LinkedList<>();
        conversionsStepsQueue.add(new ConversionStep(from, 1.0));
        cycleDetection.add(from);

        Double rate = breadthFirstSearchInCurrencyConversionGraph(to, cycleDetection, conversionsStepsQueue);
        if (rate != null) return rate;

        throw new RuntimeException("Conversion not possible");
    }

    private Double breadthFirstSearchInCurrencyConversionGraph(String to, Set<String> cycleDetection, Queue<ConversionStep> conversionsStepsQueue) {
        while (!conversionsStepsQueue.isEmpty()) {
            ConversionStep currentConversionStep = conversionsStepsQueue.poll();
            List<ConversionRate> rates = getDirectConversionsFrom(currentConversionStep.currencyId);
            if (rates != null) {
                for (ConversionRate rate : rates) {
                    if (rate.toCurrencyId.equals(to)) {
                        return rate.rate * currentConversionStep.rate;
                    }

                     if (cycleDetection.add(rate.toCurrencyId)) {
                        ConversionStep conversionStep = new ConversionStep(rate.toCurrencyId, rate.rate * currentConversionStep.rate);
                        conversionsStepsQueue.add(conversionStep);
                     }
                }
            }
        }
        return null;
    }

    private List<ConversionRate> getDirectConversionsFrom(String currencyId) {
        return conversionRatesFromGivenCurrency.get(currencyId);
    }

    public static class ConversionStep {
        String currencyId;
        double rate;

        public ConversionStep(String currencyId, double rate) {
            this.currencyId = currencyId;
            this.rate = rate;
        }
    }

    public static class ConversionRate {
        String fromCurrencyId;
        String toCurrencyId;
        double rate;

        public ConversionRate(String fromCurrencyId, String toCurrencyId, double rate) {
            this.fromCurrencyId = fromCurrencyId;
            this.toCurrencyId = toCurrencyId;
            this.rate = rate;
        }
    }

    public CurrencyConversion() {
        List<ConversionRate> ratesFromUSD = new ArrayList<>();
        ratesFromUSD.add(new ConversionRate("USD", "EUR", 0.99));
        ratesFromUSD.add(new ConversionRate("USD", "CNY", 6.76));

        List<ConversionRate> ratesFromEUR = new ArrayList<>();
        ratesFromEUR.add(new ConversionRate("EUR", "GBP", 0.85));
        ratesFromEUR.add(new ConversionRate("EUR", "USD", 1.01));

        List<ConversionRate> ratesFromCNY = new ArrayList<>();
        ratesFromCNY.add(new ConversionRate("CNY", "EUR", 0.15));

        List<ConversionRate> ratesFromGBP = new ArrayList<>();
        ratesFromGBP.add(new ConversionRate("GBP", "INR", 94.69));
        ratesFromGBP.add(new ConversionRate("GBP", "YEN", 164.35));

        List<ConversionRate> ratesFromYEN = new ArrayList<>();
        ratesFromYEN.add(new ConversionRate("YEN", "INR", 0.58));
        ratesFromYEN.add(new ConversionRate("YEN", "AUD", 0.011));

        conversionRatesFromGivenCurrency.put("USD", ratesFromUSD);
        conversionRatesFromGivenCurrency.put("EUR", ratesFromEUR);
        conversionRatesFromGivenCurrency.put("CNY", ratesFromCNY);
        conversionRatesFromGivenCurrency.put("GBP", ratesFromGBP);
        conversionRatesFromGivenCurrency.put("YEN", ratesFromYEN);

    }
}
