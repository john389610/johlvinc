


















						John Vincent
						Assignment 4
						Spell Checker
						Due 10/25/2016


























Problem 
	compare the words of given text file to given dictionary words. then output number of words found correct, number of words not found correct, and the average number of comparisons for both proceeding outputs.

Program Design 
	first set up and initialize an array of  myLinkedList. Second add a myLinkedList of each dictionary word given according to first characters ASCII value into one of the array indexes. Third read individual words from given text file , remove non-word characters from the words, and force the words to all lower-case. Finally compare text file words to stored dictionary words with the same starting character in a loop, while keeping a tally number of comparisons, matches between words, and words without matches. 

Observations
	This code mostly works as designed, however not all non-word characters are removed(fixed). The code also takes over a minute to run using “oliver.txt” so it could be made more efficient(worse with fix). 

Output
Found: 803165
Not Found: 172401
Average comparisons for word found: 3525.20
Average comparisons for word not found: 7473.5

1minute 3 sec run time