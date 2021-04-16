package ru.example.homework;

public class Main {
    public static void main(String[] args) {

    }

    private static void hash(char c) {
        System.out.println((c >> 15) ^ c);
    }

    private static void hash(char c, int f) {
        System.out.println(c % f);
    }
}
