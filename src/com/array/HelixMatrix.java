package com.array;

import java.util.Arrays;

public class HelixMatrix {
    public static void main(String[] args) {
        int n = 5;
        int [][]nums = new int[n][n];
        int cnt = 1;
        int i, j;
        int loop = 0;
        int start = 0;

        while (loop ++ < n / 2){
            // 上-左到右
            for(j = start; j < n - loop; j ++){
                nums[start][j] = cnt ++;
            }
            // 右-上到下
            for (i = start; i < n - loop; i ++){
                nums[i][j] = cnt ++;
            }
            // 下-从右到左
            for(; j >= loop; j --){
                nums[i][j] = cnt ++;
            }
            // 左-从下到上
            for (; i >= loop; i --){
                nums[i][j] = cnt ++;
            }
            start ++;
        }

        // 特判中心点
        if (n % 2 != 0){
            nums[start][start] = cnt;
        }

        System.out.println(Arrays.deepToString(nums));

    }
}

