class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while(columnNumber>0){
        columnNumber--;
        int n =(columnNumber%26)+ 'A';
        char ch=(char)n;
        str.append(ch);
        columnNumber/=26;
        }
        return str.reverse()+"";
    }
}