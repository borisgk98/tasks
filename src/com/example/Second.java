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

    public static BigInteger f(BigInteger n, BigInteger m) {
        if (m.equals(BigInteger.ZERO) || n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        if (n.equals(m)) {
            return BigInteger.ONE;
        }

        Pair<BigInteger, BigInteger> pair = new Pair<>(n, m);
        if (precomputed.containsKey(pair)) {
            return precomputed.get(pair);
        }
        BigInteger res = f(n.add(BigInteger.ONE.negate()), m.add(BigInteger.ONE.negate()))
                .add(f(n.add(BigInteger.ONE.negate()), m));
        precomputed.put(pair, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = new BigInteger(scanner.next()), n = new BigInteger(scanner.next());
        System.out.println(f(n, m));
    }
}
