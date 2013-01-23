MaxSubarrayProblem
------------------
Problem Statement: 
Given an array of real numbers (problem is interesting only when there is a combination of positive and negative real numbers), compute the subarray (consectutive elements in array) with the maximum sum.

Info:
The solution is based on the divide and conquer paradigm.

Running Time:
The running time calculation is based on the recursion
T(n) = T(n/2) + Θ(n) for n > 1
and  = Θ(1) for n = 1

=> Running time = Θ(n * log n) 

MaxSumNonConsec
---------------
Given an array of positive numbers, find the maximum sum of elements such that no two adjacent elements are picked

StringPermute
-------------
Print all permutations of characters in a given string