class Solution {
    public int findLUSlength(String[] strs) {
      int res = -1;
      Arrays.sort(strs);
    //   System.out.println(Arrays.toString(strs));

        for (int i = 0; i < strs.length; i++) {
          boolean valid = true;
          for (int j = 0; j < strs.length; j++) {
            if (j != i && isSub(strs[i], strs[j])) valid = false;
          }
          if (valid) res = Math.max(strs[i].length(), res);
        }

        return res;
    }

    public boolean isSub(String a, String b) {
      int i = 0, j = 0;
      while (i < a.length() && j < b.length()) {
        if (a.charAt(i) == b.charAt(j++)) i++;
      }
      return i == a.length();
    }
}