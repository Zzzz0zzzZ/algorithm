package com.array;

import java.util.Map;

public class SlideWindow {
    /*
    最小长度子数组
     */
    public static void main(String[] args) {
//        int s = 7;
//        int []nums = {2,3,1,2,4,3};
        int s = 11;
        int []nums = {1,1,1,1,1,1,1,1};
        System.out.println(solution1(s, nums) == 0);
    }

    public static int solution1(int target, int []nums){
        int sum = 0;
        int slow = 0;
        int size = nums.length;
        boolean flag = false;
        for(int fast = 0; fast < nums.length; fast ++){
            sum += nums[fast];
            while (sum >= target){
                size = Math.min(size, fast - slow + 1);
                sum -= nums[slow ++];
                flag = true;
            }
        }
        return flag ? size : 0;
    }
}
