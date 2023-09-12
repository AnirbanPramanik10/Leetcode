class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String temp = countAndSay(n-1);
        int cnt=1, j=1;
        StringBuilder sb=new StringBuilder();
        char ch=temp.charAt(0);

        while(j<temp.length()){
            if(temp.charAt(j)==ch){
                cnt++;
                j++;
            }
            else{
                sb.append(cnt);
                sb.append(ch);
                ch=temp.charAt(j);
                j++;
                cnt=1;
            }
        }
        sb.append(cnt);
        sb.append(ch);
        return sb.toString();
    }
}