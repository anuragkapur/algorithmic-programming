package com.anuragkapur.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumberTest {

    @Test
    public void testIsPrime1() throws Exception {
        assertEquals(true, new PrimeNumber().isPrime(2));
        assertEquals(true, new PrimeNumber().isPrime(3));
        assertEquals(false, new PrimeNumber().isPrime(4));
        assertEquals(true, new PrimeNumber().isPrime(5));
        assertEquals(false, new PrimeNumber().isPrime(6));
        assertEquals(true, new PrimeNumber().isPrime(7));
        assertEquals(false, new PrimeNumber().isPrime(8));
        assertEquals(false, new PrimeNumber().isPrime(9));
        assertEquals(true, new PrimeNumber().isPrime(127));
        assertEquals(false, new PrimeNumber().isPrime(125));
        assertEquals(false, new PrimeNumber().isPrime(169));
        assertEquals(true, new PrimeNumber().isPrime(2269));
        assertEquals(true, new PrimeNumber().isPrime(2267));
        assertEquals(false, new PrimeNumber().isPrime(1651));
    }
}