package org.example;

public class Main {
    public static void main(String[] args) {
        PrintArrayAndResult(new int[]{1, 5, 7, 9, -5, 7, -6, 0, 0, 0, -7, 6, 5, 4});
        PrintArrayAndResult(new int[]{7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        PrintArrayAndResult(new int[]{3, -3, 8, -1, 4, -2, 1, 2, -4, 8, 0, 1, -1});
        PrintArrayAndResult(new int[]{20, -20, 88, -10, 10, 40, 50, 60});
        PrintArrayAndResult(new int[]{-8, -7, -6, -5, -4, -3, -2, -1, 0});
        PrintArrayAndResult(new int[]{5, 6, -3, -4, 7, -1, -2, 1, 2});
        PrintArrayAndResult(new int[]{100, 200, -300, -50, 400, -500, 100, 12487, 700, -700, 0});
        PrintArrayAndResult(new int[]{-5, 0, 5, 10, 15, -10, 20, 25});
        PrintArrayAndResult(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        PrintArrayAndResult(new int[]{-1, -1, -1, -1, -1, -1, -1});
    }

    public static void PrintArrayAndResult(int[] array) {
        PrintArray(array);
        PrintArray(MaxPosledovatelnost(array));
        System.out.println();
    }

    public static void PrintArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] MaxPosledovatelnost(int[] array) {
        int len = array.length;

        int pos = -1;
        int maxLen = 0;

        for (int i = 0; i < len; i++) { // перебор всех элементов
            int sumOfCepochka = 0;

            boolean secondPosledovatelnost = false;

            for (int j = i; j < len; j++) { //ищем сумму равную 0
                sumOfCepochka += array[j];

                int lenOfPosledovatelnost = j - i + 1;
                if (sumOfCepochka == 0) {
                    if ((lenOfPosledovatelnost == maxLen) && !secondPosledovatelnost) {
                        pos = lenOfPosledovatelnost + 1;
                        secondPosledovatelnost = true;
                    } else if (lenOfPosledovatelnost > maxLen) {
                        pos = i;
                        maxLen = lenOfPosledovatelnost;
                        secondPosledovatelnost = false;
                    }
                }
            }
        }
        return new int[]{pos, maxLen};
    }
}