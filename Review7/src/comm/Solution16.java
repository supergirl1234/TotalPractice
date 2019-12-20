package comm;

/*
 * 题目：
 * 给定一个字符串，找出最长的不具有重复字符的子串的长度。
 * 例如，“abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。
 * 对于“bbbbb”，最长的不具有重复字符的子串是“b”，长度为1。
 *
 * */


import java.util.HashMap;
import java.util.Map;

public class Solution16 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int leftIndex = 0;//左边界值
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int left = map.get(c)+1;//下一次的左边界值
                leftIndex = Math.max(leftIndex, left);
                max = Math.max(max, i - leftIndex+1);
                map.put(c, i);

            } else {

                max = Math.max(max, i - leftIndex+1);
                map.put(c, i);//里面存储的是每个字符的下标
            }

        }

        return max;
    }


}
