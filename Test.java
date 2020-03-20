输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int len=arr.length;
        if(len==0) return new int[0];
        int[] res=new int[k];
        PriorityQueue<Integer> queue=new PriorityQueue<>(len);
        for(int i:arr){
            queue.offer(i);
        }
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }
        return res;
    }
}

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}

给定一个二进制数组， 计算其中最大连续1的个数。
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int maxlen=0;
        for(int right=0;right<nums.length;right++){
            while(right<nums.length&&nums[right]==1){
                right++;
            }
            maxlen=Math.max(maxlen,right-left);
            while(right<nums.length&&nums[right]==0){
                right++;
            }
            left=right;
            right--;
        }
        return maxlen;
    }
}

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0;
        int minlen=nums.length+1;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum-nums[left]>=s){
                sum-=nums[left++];
            }
            if(sum>=s){
                minlen=Math.min(minlen,right-left+1);
            }
        }
        return minlen==nums.length+1?0:minlen;
    }
}

