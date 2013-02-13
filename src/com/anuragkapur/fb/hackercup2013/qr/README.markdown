FB Hacker Cup 2013 QR Problems
==============================

Refer: [FB Hackercup 2013 QR](https://www.facebook.com/hackercup/problems.php?round=185564241586420)

Problem 1: Beautiful Strings
----------------------------
When John was a little kid he didn't have much to do. There was no internet, no Facebook, and no programs to hack on. So he did the only thing he could... he evaluated the beauty of strings in a quest to discover the most beautiful string in the world.
Given a string s, little Johnny defined the beauty of the string as the sum of the beauty of the letters in it. The beauty of each letter is an integer between 1 and 26, inclusive, and no two letters have the same beauty. Johnny doesn't care about whether letters are uppercase or lowercase, so that doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as beautiful as lowercase 'f', for example.) You're a student writing a report on the youth of this famous hacker. You found the string that Johnny considered most beautiful. What is the maximum possible beauty of this string?

Input
The input file consists of a single integer m followed by m lines.

Output
Your output should consist of, for each test case, a line containing the string "Case #x: y" where x is the case number (with 1 being the first case in the input file, 2 being the second, etc.) and y is the maximum beauty for that test case.

Constraints
5 ² m ² 50
2 ² length of s ² 500

<pre>
Sample Input
5
ABbCcc
Good luck in the Facebook Hacker Cup this year!
Ignore punctuation, please :)
Sometimes test cases are hard to make up.
So I just go consult Professor Dalves

Sample Output
Case #1: 152
Case #2: 754
Case #3: 491
Case #4: 729
Case #5: 646
</pre>

Problem 2: Balanced Smileys
---------------------------
Your friend John uses a lot of emoticons when you talk to him on Messenger. In addition to being a person who likes to express himself through emoticons, he hates unbalanced parenthesis so much that it makes him go :(

Sometimes he puts emoticons within parentheses, and you find it hard to tell if a parenthesis really is a parenthesis or part of an emoticon.

A message has balanced parentheses if it consists of one of the following:

- An empty string ""
- One or more of the following characters: 'a' to 'z', ' ' (a space) or ':' (a colon)
- An open parenthesis '(', followed by a message with balanced parentheses, followed by a close parenthesis ')'.
- A message with balanced parentheses followed by another message with balanced parentheses.
- A smiley face ":)" or a frowny face ":("   
Write a program that determines if there is a way to interpret his message while leaving the parentheses balanced.

Input
The first line of the input contains a number T (1 <= T <= 50), the number of test cases. 
The following T lines each contain a message of length s that you got from John.

Output
For each of the test cases numbered in order from 1 to T, output "Case #i: " followed by a string stating whether or not it is possible that the message had balanced parentheses. If it is, the string should be "YES", else it should be "NO" (all quotes for clarity only)

Constraints
1 <= length of s <= 100

<pre>
Sample Input
5
:((
i am sick today (:()
(:)
hacker cup: started :):)
)(

Sample Output
Case #1: NO
Case #2: YES
Case #3: YES
Case #4: YES
Case #5: NO
</pre>

Problem 3: Find The Min
-----------------------
After sending smileys, John decided to play with arrays. Did you know that hackers enjoy playing with arrays? John has a zero-based index array, m, which contains n non-negative integers. However, only the first k values of the array are known to him, and he wants to figure out the rest.

John knows the following: for each index i, where k <= i < n, m[i] is the minimum non-negative integer which is *not* contained in the previous *k* values of m.

For example, if k = 3, n = 4 and the known values of m are [2, 3, 0], he can figure out that m[3] = 1.

John is very busy making the world more open and connected, as such, he doesn't have time to figure out the rest of the array. It is your task to help him.

Given the first k values of m, calculate the nth value of this array. (i.e. m[n - 1]).

Because the values of n and k can be very large, we use a pseudo-random number generator to calculate the first k values of m. Given non-negative integers a, b, c and positive integer r, the known values of m can be calculated as follows:

m[0] = a
m[i] = (b * m[i - 1] + c) % r, 0 < i < k

Input
The first line contains an integer T (T <= 20), the number of test cases.
This is followed by T test cases, consisting of 2 lines each.
The first line of each test case contains 2 space separated integers, n, k (1 <= k <= 10^5, k < n <= 10^9).
The second line of each test case contains 4 space separated integers a, b, c, r (0 <= a, b, c <= 10^9, 1 <= r <= 10^9).

Output
For each test case, output a single line containing the case number and the nth element of m.

<pre>
Sample Input
5
97 39
34 37 656 97
186 75
68 16 539 186
137 49
48 17 461 137
98 59
6 30 524 98
46 18
7 11 9 46

Sample Output
Case #1: 8
Case #2: 38
Case #3: 41
Case #4: 40
Case #5: 12
</pre>