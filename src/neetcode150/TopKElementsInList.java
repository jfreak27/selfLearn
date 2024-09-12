import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKElementsInList {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> keyToOccurencesMap = new HashMap<>();
        Map<Integer, List<Integer>> occurencesToKeyMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i : nums) {
            if (keyToOccurencesMap.containsKey(i)) {
                keyToOccurencesMap.put(i, keyToOccurencesMap.get(i) + 1);
            } else {
                keyToOccurencesMap.put(i, 1);
            }
        }

        System.out.println(keyToOccurencesMap);

        for (Map.Entry<Integer, Integer> entry : keyToOccurencesMap.entrySet()) {
            if (occurencesToKeyMap.containsKey(entry.getValue())) {
                occurencesToKeyMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                occurencesToKeyMap.put(entry.getValue(), list);
            }

        }

        System.out.println(occurencesToKeyMap);

        List<Integer> res = new ArrayList<>();
        int n = k;
        for (Map.Entry<Integer, List<Integer>> map : occurencesToKeyMap.entrySet()) {
            if(n > 0) {
                for (int v : map.getValue()) {
                    res.add(v);
                    n--;
                    if(n == 0) break;
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TopKElementsInList topKElementsInList = new TopKElementsInList();
        System.out.println(Arrays.toString(topKElementsInList.topKFrequent(new int[]{1, 2}, 2)));
    }
}
