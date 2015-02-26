##AllPaths2Points2DMatrix
Given the dimensions of a 2D matrix and an ending point, find all possible paths to the ending point form the origin. Movement allowed is only downwards or to the right. Origin is assumed to be the top left corner.

##CountInversions
###Problem Statement:   
Count number of pairs of elements in an array such that:   
for array indices (i,j) where i < j   
A[i] > A[j]   

###Info:   
Solution is based on a the divide and conquer paradigm and extends the logic of merge sort.

###Running Time:   
O(nlogn) [same as merge sort]

##MaxSubarrayProblem
###Problem Statement:    
Given an array of real numbers (problem is interesting only when there is a combination of positive and negative real numbers), compute the subarray (consectutive elements in array) with the maximum sum.

###Info:   
The solution is based on the divide and conquer paradigm.

###Running Time:   
<pre>
The running time calculation is based on the following recursion equation
T(n) = T(n/2) + Θ(n) for n > 1
and  = Θ(1) for n = 1

=> Running time = Θ(n * log n) 
</pre>

##MaxSumNonConsec
Given an array of positive numbers, find the maximum sum of elements such that no two adjacent elements are picked

##StringPermute
Print all permutations of characters in a given string

##ComputeCombinationsRecursive
Compute all combinations of the characters in the given string

##StringSubString
Compute if given string is a substring of a another string

##StringReverse
Reverse chars of a string

##ComputeNthFibonacci

##NumberSumCombinations
Given a number, print all ways of getting the number as a sum of other numbers.
Example, for n=5

    1 + 1 + 1 + 1 + 1
    1 + 4
    2 + 3
    1 + 1 + 1 + 2
    1 + 1 + 3
    5
    ...etc
    
##MergeKArrays
Given K sorted arrays, merge them

##Rod Cutting Problem
### Problem Statement
Given a rod of length n inches and a table of prices pi for i = 1,2,...,n, determine the maximum revenue rn obtainable
by cutting up the rod and selling the pieces. Note that if the price pn for a rod of length n is large enough, an
optimal solution may require no cutting at all.
