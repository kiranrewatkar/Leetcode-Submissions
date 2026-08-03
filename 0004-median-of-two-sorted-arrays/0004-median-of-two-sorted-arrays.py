class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        array=nums1+nums2
        for i in range(len(array)-1):
            for j in range(len(array)-i-1):
                if(array[j]>array[j+1]):
                    array[j],array[j+1]=array[j+1],array[j]
        mid=len(array)//2
        if len(array)%2==0:
            return (array[mid-1]+array[mid])/2.0
        return float(array[mid])