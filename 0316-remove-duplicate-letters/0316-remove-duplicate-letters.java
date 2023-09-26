class Solution {
    public String removeDuplicateLetters(String s) {
          Stack<Character> stack = new Stack<>();
          int freq[] = new int[26]; // Help in mapping i.e a->0, b->1....
          boolean exist[] = new boolean[26];

          for(int i=0;i<s.length();i++){
              char ch = s.charAt(i);
              freq[ch - 'a']++;
          }

          for(int i=0;i<s.length();i++){
              char ch = s.charAt(i);
              freq[ch-'a']--;
              if(exist[ch-'a'])continue;

              while(stack.size() > 0 && stack.peek() > ch && freq[stack.peek() - 'a']>0){
                  char rem = stack.pop();
                  exist[rem-'a'] = false;
              }
              stack.push(ch);
              exist[ch-'a'] = true;
          }
          char ans[] = new char[stack.size()];
          int i = ans.length-1;
          while(i>=0)ans[i--] = stack.pop();

          return new String(ans);
    }
}