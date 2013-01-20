FB Hacker Cup 2012 QR Problems
==============================

Refer: [FB Hackercup 2012 QR](https://www.facebook.com/hackercup/problems.php?round=146094915502528, "FB Hackercup 2012 QR Problems")

Problem 1: Alphabet Soup
------------------------
Alfredo Spaghetti really likes soup, especially when it contains alphabet pasta. Every day he constructs a sentence from letters, places the letters into a bowl of broth and enjoys delicious alphabet soup.

Today, after constructing the sentence, Alfredo remembered that the Facebook Hacker Cup starts today! Thus, he decided to construct the phrase "HACKERCUP". As he already added the letters to the broth, he is stuck with the letters he originally selected. Help Alfredo determine how many times he can place the word "HACKERCUP" side-by-side using the letters in his soup.

Input
The first line of the input file contains a single integer T: the number of test cases. T lines follow, each representing a single test case with a sequence of upper-case letters and spaces: the original sentence Alfredo constructed.

Output
Output T lines, one for each test case. For each case, output "Case #t: n", where t is the test case number (starting from 1) and n is the number of times the word "HACKERCUP" can be placed side-by-side using the letters from the sentence.

Constraints
1 < T � 20
Sentences contain only the upper-case letters A-Z and the space character
Each sentence contains at least one letter, and contains at most 1000 characters, including spaces

Example Input
5
WELCOME TO FACEBOOK HACKERCUP
CUP WITH LABEL HACKERCUP BELONGS TO HACKER
QUICK CUTE BROWN FOX JUMPS OVER THE LAZY DOG
MOVE FAST BE BOLD
HACK THE HACKERCUP

Example Output
Case #1: 1
Case #2: 2
Case #3: 1
Case #4: 0
Case #5: 1