package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords(); // 1
        checkSumSign(); // 2
        printColor(); // 3
        compareNumbers(); // 4
        System.out.println(checkIfSumIs10to20(9, 7)); // 5
        checkIntSignPrint(0); // 6
        System.out.println(checkIntSignBoolean(-1)); // 7
        printText("hello", 4); // 8
        System.out.println(checkLeapYear(2000)); // 9

        // 10
        int[] array1 = {0, 0, 1, 1, 0, 1};
        invertArray(array1);
        System.out.println(Arrays.toString(array1));

        // 11
        int[] array2 = new int[100];
        fillArray(array2);
        System.out.println(Arrays.toString(array2));

        // 12
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleElementsLessThanSix(array3);
        System.out.println(Arrays.toString(array3));

        // 13
        int[][] array4 = new int[5][5];
        fillArrayDiagonals(array4);
        for (int[] row : array4)
            System.out.println(Arrays.toString(row));

        // 14
        int[] array5 = createArray(6, 18);
        System.out.println(Arrays.toString(array5));
    }

    private static void printThreeWords() {
        System.out.printf("%n1. printThreeWords()%n");

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        System.out.printf("%n2. checkSumSign()%n");

        int a = 2, b = -2;
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    private static void printColor() {
        System.out.printf("%n3. printColor()%n");

        int value = 50;
        if (value <= 0)
            System.out.println("Красный");
        else if (value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    private static void compareNumbers() {
        System.out.printf("%n4. compareNumbers()%n");

        int a = 1234234, b = 5421342;
        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    private static boolean checkIfSumIs10to20(int a, int b) {
        System.out.printf("%n5. checkIfSumIs10to20(%d, %d)%n", a, b);

        int sum = a + b;
        return 10 <= sum && sum <= 20;
    }

    private static void checkIntSignPrint(int value) {
        System.out.printf("%n6. checkIntSignPrint(%d)%n", value);

        if (value >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    private static boolean checkIntSignBoolean(int value) {
        System.out.printf("%n7. checkIntSignBoolean(%d)%n", value);

        return value < 0;
    }

    private static void printText(String text, int times) {
        System.out.printf("%n8. printText(%s, %d)%n", text, times);

        for (int i = 0; i < times; i++)
            System.out.println(text);

        //System.out.println();
    }

    private static boolean checkLeapYear(int year) {
        System.out.printf("%n9. checkLeapYear(%d)%n", year);
        if (year % 4 == 0 && year > 0) {
            if (year % 100 == 0) return year % 400 == 0;
            return true;
        }
        return false;
    }

    private static int[] invertArray(int[] array) {
        System.out.printf("%n10. invertArray(%s)%n", Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }

        return array;
    }

    private static int[] fillArray(int[] array) {
        System.out.printf("%n11. fillArray(%s)%n", Arrays.toString(array));

        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;

        return array;
    }

    private static int[] doubleElementsLessThanSix(int[] array) {
        System.out.printf("%n12. doubleElementsLessThanSix(%s)%n", Arrays.toString(array));

        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;

        return array;
    }

    private static int[][] fillArrayDiagonals (int[][] array) {
        System.out.printf("%n13. fillArrayDiagonals(%s)%n", Arrays.deepToString(array));

        int difference = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                if (i == j || j - i == difference)
                    array[i][j] = 1;
            difference -= 2;
        }

        return array;
    }

    private static int[] createArray (int len, int initialValue) {
        System.out.printf("%n14. createArray(%d, %d)%n", len, initialValue);

        int[] array = new int[len];
        Arrays.fill(array, initialValue);

        return array;
    }
}