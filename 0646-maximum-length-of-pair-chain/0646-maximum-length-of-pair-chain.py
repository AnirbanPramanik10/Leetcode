class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        pairs.sort(key=lambda x: x[1])
        count=1
        i=0
        j=1
        print(pairs)
        while(j<len(pairs)):
            if pairs[i][1]<pairs[j][0]:
                count+=1
                i=j
            else:
                j+=1
        return count