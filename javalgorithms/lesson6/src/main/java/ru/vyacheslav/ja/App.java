package ru.vyacheslav.ja;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 1. Создать программу для построения двоичного дерева. В цикле построить двадцать деревьев.
 Данные, которыми необходимо заполнить узлы деревьев представляются в виде чисел типа int.
 Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от 0 до 100.
 2. Проанализировать, какой процент созданных деревьев является несбалансированными.
 */

public class App {

    private static void uniqueRandom(ArrayList<Integer> a, int amount) {
        Random r = new Random();
        SecureRandom sr = new SecureRandom();
        while (a.size() < amount) {
            int num = sr.nextInt();
            if (!a.contains(num))
                a.add(num);
        }
    }

    public static void main(String[] args) {
        final int TREES = 20;
        int balanced = 0;
        for (int i = 0; i < TREES; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            uniqueRandom(a, 10000);
            Tree t = new Tree(a);
            balanced += (t.isBalanced(false)) ? 1 : 0;
        }
        System.out.println(balanced * 100f / TREES + "%");
    }
}
