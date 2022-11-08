class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int idx =0;
        while(idx<s.length()) {
            char c = s.charAt(idx++);
            if(stack.size()>0) {
                char p = stack.peek();
                if(isValid(c,p)) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(stack.size()>0) sb.append(Character.toString(stack.pop()));
        return sb.reverse().toString();
    }

    public static boolean isValid(char c,char p) {
        if(c>='A' && c<='Z') {
            if(p>='a' && p<='z' && p-'a'==c-'A') {
                return false;
            }
        } else {
            if(p>='A' && p<='Z' && p-'A'==c-'a') {
                return false;
            }
        }
        return true;
    }
}
