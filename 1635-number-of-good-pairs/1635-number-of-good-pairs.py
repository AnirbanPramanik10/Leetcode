class Solution:
    def numIdenticalPairs(self, nums):
        count_map = {}
        good_pairs = 0

        for num in nums:
            good_pairs += count_map.get(num, 0)
            count_map[num] = count_map.get(num, 0) + 1

        return good_pairs
