class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}