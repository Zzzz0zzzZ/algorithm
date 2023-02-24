package com.array;

public class BinarySearch {
    /*
    二分查找
    两种情形，左闭右闭，左闭右开，注意边界条件
     */
    public static void main(String[] args) {
        int []nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(bsearch_1(nums, target) == 4);
        System.out.println(bsearch_2(nums, target) == 4);
    }


    /*
    * 第一种 左闭右闭，left <= right, 每次搜索范围都是闭区间
    * 因此下一次搜索区间是 right = mid - 1
    */
    public static int bsearch_1(int []nums, int target){
        // 1. 特判
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        // 2. 初始化 left, right
        int left = 0, right = nums.length - 1;
        // 3. 循环找结果
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    /*
    * 左闭右开，left < right, 搜索区间不包含右端点，因此更新右边不能减1
    *
    */
    public static int bsearch_2(int []nums, int target){
            if(target < nums[0] || target > nums[nums.length - 1]){
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left < right){
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target){
                    return mid;
                }
                if (nums[mid] > target){
                    right = mid;
                }
                if(nums[mid] < target){
                    left = mid + 1;
                }
            }

        return -1;
    }
}
