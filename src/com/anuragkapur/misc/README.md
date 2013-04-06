AllPaths2Points2DMatrix
-----------------------
Given the dimensions of a 2D matrix and an ending point, find all possible paths to the ending point form the origin. Movement allowed is only downwards or to the right. Origin is assumed to be the top left corner.

CountInversions
---------------
####Problem Statement:   
Count number of pairs of elements in an array such that:   
for array indices (i,j) where i < j   
A[i] > A[j]   

####Info:   
Solution is based on a the divide and conquer paradiigm and extends the logic of merge sort.

####Running Time:   
O(nlogn) [same as merge sort]

MaxSubarrayProblem
------------------
####Problem Statement:    
Given an array of real numbers (problem is interesting only when there is a combination of positive and negative real numbers), compute the subarray (consectutive elements in array) with the maximum sum.

####Info:   
The solution is based on the divide and conquer paradigm.

####Running Time:   
<pre>
The running time calculation is based on the following recursion equation
T(n) = T(n/2) + Θ(n) for n > 1
and  = Θ(1) for n = 1

=> Running time = Θ(n * log n) 
</pre>

MaxSumNonConsec
---------------
Given an array of positive numbers, find the maximum sum of elements such that no two adjacent elements are picked

StringPermute
-------------
Print all permutations of characters in a given string

ComputeCombinationsRecursive
----------------------------
Compute all combinations of the characters in the given string