package com.atguigu.recursion;

import java.util.Arrays;

public class MiGong2 {
    /**
     * 1 墙
     * 2 通路
     * 3 不通
     *
     * @param args
     */
    public static void main(String[] args) {
        int length = 8;

        int[][] mg = buildMG(length);

        mg[1][3] = 1;
        mg[2][3] = 1;
        mg[2][2] = 1;
        Arrays.fill(mg[4], 1);
        mg[4][mg.length - 2] = 0;
        mg[2][mg.length - 3] = 1;
        mg[3][mg.length - 3] = 1;
        pintMG(mg);

        findPath(mg, 1, 1);
        System.out.println("---------------------");
        pintMG(mg);
    }

    static boolean findPath(int[][] mg, int i, int j) {
        if (mg[mg.length - 2][mg.length - 2] == 2) {
            return true;
        }
        if (mg[i][j] == 0) {
            // 右，下，左，上
            mg[i][j] = 2;
            if (findPath(mg, i, j + 1) ||
                    findPath(mg, i + 1, j) ||
                    findPath(mg, i, j - 1) ||
                    findPath(mg, i - 1, j)) {
                return true;
            } else {
                mg[i][j] = 3;
                return false;
            }
        }
        return false;
    }

    private static int[][] buildMG(int length) {
        int[][] mg = new int[length][];
        for (int i = 0; i < mg.length; i++) {
            mg[i] = new int[mg.length];
        }
        Arrays.fill(mg[0], 1);
        Arrays.fill(mg[mg.length - 1], 1);
        for (int[] ints : mg) {
            ints[0] = ints[ints.length - 1] = 1;
        }
        return mg;
    }

    private static void pintMG(int[][] mg) {
        for (int[] ints : mg) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
