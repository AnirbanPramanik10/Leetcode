class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
	    min1 = min2 = inf
	    for n in nums:
		    if n <= min1: min1 = n
		    elif n <= min2: min2 = n
		    else: return True
	    return False