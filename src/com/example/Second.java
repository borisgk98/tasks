package com.example;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Написать программу, вычисляющую для любых натуральных m и r,
 * таких что r ≤ m, значение функции
 * 𝑓(𝑚, 𝑟) =
 * 𝑚!
 * 𝑟! (𝑚 − 𝑟)!
 */
public class Second {

    /**
     * Нужно для того чтобы сохранять результат выполнения функции, чтобы не считать несколько раз
     */
    private static Map<Pair<BigInteger, BigInteger>, BigInteger> precomputed;

    static {
        precomputed = new HashMap<>();
    }

    public static BigInteger f(BigInteger m, BigInteger r) {
        if (m.equals(BigInteger.ZERO) || r.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        if (r.equals(m)) {
            return BigInteger.ONE;
        }

        Pair<BigInteger, BigInteger> pair = new Pair<>(m, r);
        if (precomputed.containsKey(pair)) {
            return precomputed.get(pair);
        }
        BigInteger res = f(m.add(BigInteger.ONE.negate()), r.add(BigInteger.ONE.negate()))
                .add(f(m.add(BigInteger.ONE.negate()), r));
        precomputed.put(pair, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = new BigInteger(scanner.next()), r = new BigInteger(scanner.next());
        System.out.println(f(m, r));
    }
}
