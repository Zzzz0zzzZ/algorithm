package com.array;

public class TwoPointer {
    public static void main(String[] args) {
        int []nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(solution1(nums, val) == 5);
        System.out.println(solution2(nums, val) == 5);
        System.out.println(solution3(nums, val) == 5);
    }

    /*
    去除数组目标元素，最终顺序可变，O(1)额外空间完成
    1. 暴力： O(n)
    2. 快慢指针
        快指针：寻找 !=val 的元素
        慢指针：新数组下标
    3. 相向指针
        从右边找不为val的数，替换左边为val的数，直到 left > right 为止
     */

    // 暴力
    public static int solution1(int []nums, int val){
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] == val){
                for(int j = i + 1; j < nums.length; j++){
                    nums[j-1] = nums[j];
                }
                i --;
                size--;
            }
        }
        return size;
    }

    // 快慢指针
    public static int solution2(int []nums, int val){
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    // 相向指针
    public static int solution3(int []nums, int val){
        int left = 0, right = nums.length - 1;
        while (right >= 0 && nums[right] == val)    right --;
        while (left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left ++;
            while (right >= 0 && nums[right] == val)    right --;
        }

        return left;
    }

}
