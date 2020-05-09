import java.util.HashMap;
import java.util.Map;

/**
 * @author Hanz
 * @date 2020/4/9
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map temp = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(temp.get(nums[i])!= null){
                return new int[]{i,Integer.parseInt(temp.get(nums[i]).toString())};
            }else {
                temp.put(target-nums[i],i);
            }
        }
        return new int[] {};
    }
}
