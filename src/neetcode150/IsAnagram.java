package neetcode150;//https://neetcode.io/problems/is-anagram


import java.util.Arrays;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;

            int[] count = new int[26];
            Arrays.fill(count, 0);
            for(char c : s.toLowerCase().toCharArray()){
                count[c - 97] = count[c- 97] + 1;
            }

        for(char c : t.toLowerCase().toCharArray()){
            count[c - 97] = count[c- 97] - 1;
        }

        for(int i: count){
            if(i > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "jar";
        String t = "jam";

        System.out.println(isAnagram(s, t));





    }
}
