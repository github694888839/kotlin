package org.example.leet;

class _03LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            for (int j = i + 1; j < s.length(); j++) {
                char indexJ = s.charAt(j);
                if (sub.indexOf(indexJ) == -1) {
                    sub = s.substring(i, j + 1);
                    if (sub.length() > maxLen){
                        maxLen = sub.length();
                    }
                    //System.out.println("s = " + sub);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}