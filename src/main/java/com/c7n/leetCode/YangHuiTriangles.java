package com.c7n.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class YangHuiTriangles {

    public static void main(String[] args) {
        generate(0);
        long time = System.currentTimeMillis();
        generate(30);
        System.out.println("执行时间: " + (System.currentTimeMillis() - time) + " ms");
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        Integer[][] cache = new Integer[numRows][numRows];

        for (int line = 0; line < numRows; line++) {
            List<Integer> rowResult = new ArrayList<>(line + 1);
            for (int j = 0; j <= line; j++) {
                if (cache[line][j] == null) {
                    cache[line][j] = f(line, j, cache);
                }
                rowResult.add(cache[line][j]);
            }
            result.add(rowResult);
        }
        return result;
    }

    /**
     * i 行, j 列
     * @param i
     * @param j
     * @return
     */
    public static int f(int i, int j, Integer[][] cache) {
        if (j < 0 || j > i) {
            return 0;
        } else if (i == 0 || i == 1) {
            return 1;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        return f(i - 1, j - 1, cache) + f(i - 1, j, cache);
    }
}
