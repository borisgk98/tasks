package com.example;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * На вход программе подается литературный текст. Программа должна
 * вывести список слов, встречающихся в тексте, в котором для каждого
 * слова указывается количество вхождений этого слова в текст, а слова
 * выводятся в порядке убывания частоты вхождения.
 */
public class Third {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(w -> {
            if (!map.containsKey(w)) {
                map.put(w, 0);
            }
            map.replace(w, map.get(w) + 1);
        });
        map.entrySet().stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .forEach(x -> {
                    System.out.printf("%s: %d\n", x.getKey(), x.getValue());
                });
    }
}
