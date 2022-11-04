// Problem Link :- https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// Video Solution Link :- https://www.youtube.com/watch?v=z5zMFLNvjw0

class Solution {
    public String reverseVowels(String s) {
        char[] vowels = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        ArrayList<Character> list_of_vowels = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            for(char vowel : vowels) {
                if(vowel==s.charAt(i)) {
                    list_of_vowels.add(vowel);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = list_of_vowels.size()-1;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            for(char vowel : vowels) {
                if(vowel==s.charAt(i)) {
                    c=list_of_vowels.get(idx);
                    idx--;
                    break;
                }
            }
            sb.append(Character.toString(c));
        }
        return sb.toString();
    }
}
