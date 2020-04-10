package com.pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class Main {
    private static final String libProperty = "dynamic.library.path";
    public static void main(String[] args) {
        String property = System.getProperty(libProperty);
        System.load(property);
        out.println("Добро пожаловать в этот мир. Чекалка на то что из одной строки можно получить другую путем перестановки символов!");
        while (true) {
            out.println("Щас мы введем две строки которые протестим...");
            out.println("Первая пошла");
            String first = readLine();
            out.println("Вторая пошла");
            String second = readLine();
            out.println("Go чекнем можно ли получить из одной строки другую путем перестановок!");
            if (check(first, second)) {
                out.println("МОЖНО");
            } else {
                out.println("УПС низя");
            }
            out.println("Чувачок, если хошь выйти просто нажми ctrl+C . Это работает не только тут");
        }
    }

    native public static boolean check(String s1, String s2);

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
