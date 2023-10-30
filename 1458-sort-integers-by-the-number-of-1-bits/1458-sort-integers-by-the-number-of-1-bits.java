import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }

        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int countA = Integer.bitCount(a);
                int countB = Integer.bitCount(b);

                if (countA == countB) {
                    return a - b;
                } else {
                    return countA - countB;
                }
            }
        };

        Arrays.sort(integerArr, customComparator);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }

        return arr;
    }
}
