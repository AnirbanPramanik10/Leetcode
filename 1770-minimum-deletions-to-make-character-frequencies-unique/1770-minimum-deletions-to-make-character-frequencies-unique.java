class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for( char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        Arrays.sort(freq);
        reverse(freq);
        int prev = freq[0];
        int i = 1, n = s.length(), del = 0;

        // for(int f: freq){
        //     System.out.print(f+" ");
        // }
        // System.out.println();

        while( i < 26 && freq[i]>0){
            while(freq[i]>=prev && freq[i]>0){
                freq[i]--;
                del++;          
            }
            prev = freq[i];
            i++;
        }
        return del;      
    }

    public void reverse(int[] arr){
        int i = 0; 
        int j = arr.length -1;
        while( i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap( int[] arr , int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}