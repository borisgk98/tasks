package com.example;

/**
 * Написать программу, которая выводит числа от 1 до 100, но вместо
 * чисел кратных 2 нужно выводить строку Two, вместо чисел кратных 7 -
 * строку Seven, вместо чисел кратных 2 и 7 - строку TwoSeven.
 */
public class First {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i % 7 == 0) {
                System.out.println("TwoSeven");
            }
            else if (i % 2 == 0) {
                System.out.println("Two");
            }
            else if (i % 7 == 0) {
                System.out.println("Seven");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
