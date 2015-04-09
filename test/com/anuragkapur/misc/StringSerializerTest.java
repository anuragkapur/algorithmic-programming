package com.anuragkapur.misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class StringSerializerTest {

    StringSerializer serializer = new StringSerializer();

    @Test
    public void testSerializeAndDeserialize() throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("abcd22£$$%.11");
        strings.add("abc");

        String serialized = serializer.serialize(strings);

        List<String> stringsActual = serializer.deserialize(serialized, null);
        assertEquals("[abc, abcd22£$$%.11]", stringsActual.toString());
    }

    @Test
    public void testDeserialize1() throws Exception {

        List<String> strings = serializer.deserialize("abc.3def..4", null);
        System.out.println(strings.toString());
    }
}