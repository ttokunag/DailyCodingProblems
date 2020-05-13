import java.util.Map;
import java.util.TreeMap;

public class Medium400 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        double[] probs = {.1, .5, .2, .2};
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i = 0; i < 1000000; i++) {
            int ans = NProbabilities(nums, probs);
            if (!count.containsKey(ans)) {
                count.put(ans, 0);
            }
            count.put(ans, count.get(ans) + 1);
        }

        for (int key : count.keySet()) {
            System.out.println(key + ": " + (double) count.get(key) / (double) 1000000);
        }
    }

    static int NProbabilities(int[] nums, double[] probs) {
        double randomProb = Math.random();
        double cumProb = 0;
        for (int i = 0; i < probs.length; i++) {
            cumProb += probs[i];
            if (randomProb <= cumProb) {
                return nums[i];
            }
        }
        // unreachable line
        return 0;
    }
}