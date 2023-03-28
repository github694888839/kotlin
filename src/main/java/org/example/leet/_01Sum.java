package org.example.leet;

public class _01Sum {
    public static void main(String[] args) {
        int[] result = sum(new int[]{2,5,6,7,3,2,6},9);
        System.out.printf(result[0] + ", " + result[1]);
    }

    public static int[] sum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
