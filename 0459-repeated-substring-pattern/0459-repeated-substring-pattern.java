class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<s.length()/2;i++){
            sb.append(s.charAt(i));
            if(s.endsWith(sb.toString())) if(s.split(sb.toString()).length ==0) return true;
        }

        return false;
    }
}