package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
        };

        try {
            System.out.println("Сумма элементов в массиве = " + sumOfArray(arr));
            System.out.println(arr[100][500]);
        } catch (MyArraySizeException | MyArrayDataException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Исключение: " + e.getMessage());
        }
    }

    private static int sumOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Задан неверный размер массива");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: \"" + array[i][j] + "\"");
                }
            }
        }

        return sum;
    }
}