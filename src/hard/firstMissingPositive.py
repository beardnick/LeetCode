# -*- coding: utf-8 -*- 

def firstMissingPositive(nums) -> int:
        i = 0
        while i < len(nums):
            if nums[i] != i + 1 and nums[i] > 0 and nums[i] <= len(nums) and nums[nums[i] - 1] != nums[i]:
                t = nums[i]
                nums[i] = nums[t - 1]
                nums[t - 1] = t
                continue
            i += 1
        for j in range(len(nums)):
            if nums[j] != j + 1:
                return j + 1
        return len(nums) + 1

print(firstMissingPositive([1,2,0]))
print(firstMissingPositive([3,4,-1,1]))
print(firstMissingPositive([7,8,9,11,12]))
print(firstMissingPositive([1,1]))
print(firstMissingPositive([]))