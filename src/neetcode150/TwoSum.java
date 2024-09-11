package neetcode150;

import javax.net.ssl.HostnameVerifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://neetcode.io/problems/two-integer-sum
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            int required = target - i;
            if(map.containsKey(required)){
                int idxI = 0;
                for(int j = 0; j < nums.length ; j++){
                    if(nums[j] == i){
                        idxI = j;
                        break;
                    }
                }
                int idxJ = 0;
                for(int j = 0; j < nums.length ; j++){
                    if(nums[j] == required && j != idxI){
                        idxJ = j;
                        break;
                    }
                }
                if(idxI < idxJ){
                    return new int[]{idxI, idxJ};
                }else return new int[]{idxJ, idxI};

            }
            map.put(i, target - i);
        }

        return new int[]{-1};

    }
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{5,5}, 10)));
    }
}
