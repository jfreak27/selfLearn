import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

//https://neetcode.io/problems/anagram-groups
public class AnagramGroups {

    public static void main(String[] args) {

        AnagramGroups groups = new AnagramGroups();
        System.out.println(groups.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
//        System.out.println(groups.groupAnagrams(new String[]{"pots", "tops","stop"}));
//                                                              i                       j
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toLowerCase().toCharArray()){
                count[c - 'a'] = count[c - 'a'] + 1;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
