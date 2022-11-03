// Problem Link :- https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
// Video Solution Link :- https://www.youtube.com/watch?v=d1ZZziNoS7c

class Solution {
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words) {
            if(map.containsKey(s)) {
                map.put(s,map.get(s)+1);
            } else {
                map.put(s,1);
            }
        }
        
        int ans=0;
        int ct=0;
        for(String word : words) {
            if(!map.containsKey(word)) continue;
            String word1 = word.substring(1)+word.substring(0,1);
            Integer fre = map.get(word1);
            remove(map,word);
            
            if(word.charAt(0)==word.charAt(1)) {
                if(fre!=null) {
                    if(fre>1) {
                        ans+=4;
                        remove(map,word1);
                    } else if(fre==1) {
                        ct++;
                    }
                }
            } else {
                if(fre!=null) {
                    ans+=4;
                    remove(map,word1);
                }
            }
        }
        if(ct>0) ans+=2;
        return ans;
    }
    
    public static void remove(HashMap<String,Integer> map,String s) {
        if(map.get(s)==1) {
            map.remove(s);
        } else {
            map.put(s,map.get(s)-1);
        }
    }
}
