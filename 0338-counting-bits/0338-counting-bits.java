class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i=0;i<=n;i++){
            String bin = Integer.toBinaryString(i);
            long t = Long.parseLong(bin);
            int count = 0;

            while(t > 0){
                long rem = t % 10;
                if(rem == 1)count++;
                t = t / 10;
            }
            arr[i] = count;
        }
        return arr;
    }
}