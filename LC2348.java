public class LC2348 {
    public static long bruteForcen3(int[] nums){
        long count=0;
        for(int i=0;i<nums.length;i++){
            boolean areAllZeroes=true;
            for(int j=i;j<nums.length;j++){
                for(int k=i;k<=j;k++){
                    if(nums[k]!=0){
                        areAllZeroes=false;
                        break;
                    }
                }
                if(areAllZeroes){
                    count++;
                }
            }

        }
        return count;
    }
    public static long bruteForcen2(int[] nums){
        long count=0;
        for(int i=0;i<nums.length;i++){
            boolean areAllZeroes=true;
            for(int j=i;j<nums.length;j++){
                    if(nums[j]!=0) {
                        areAllZeroes = false;
                    }
                if(areAllZeroes){
                    count++;
                }
            }
        }
        return count;
    }
    public long optimisedSolution(int[] nums) {
        long res = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                j = i + 1;
            res += i - j + 1;
        }
        return res;
    }
}
