class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0; i< Math.max(v1.length, v2.length); i++){
//            System.out.println(v1[i]);
//            System.out.println(v2[i]);
            int vint1 = (i < v1.length)? Integer.valueOf(v1[i]) : 0;
            int vint2 = (i < v2.length)? Integer.valueOf(v2[i]) : 0;
            if(vint1 < vint2){
                return -1;
            }
            else if(vint1 > vint2){
                return 1;
            }
        }
        return 0;
    }
}