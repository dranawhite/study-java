package com.study.jvm.stream;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author liangyq 2018/3/14
 */
public class NumberCounterTest {

    @Test
    public void testCounter() {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        System.out.println("ordered total: " + countNum(stream));
    }

    private int countNum(Stream<Character> stream) {
        NumberCounter numCounter = stream.reduce(new NumberCounter(0, 0, false),
                NumberCounter::accumulate,
                NumberCounter::combine);
        return numCounter.getSum();
    }
}
