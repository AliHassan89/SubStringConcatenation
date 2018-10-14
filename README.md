# SubStringConcatenation
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any
intervening characters.
```
Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
```
You should return the indices: [0,9].
(order does not matter).

#Solution:
1. Traverse the string S and keep taking words of length of L from the string S and populate a hashMap where key is substring of length L from string S and value is a list of indices where key was found in sting S.
e.g: if we have
```
S = "foobarabcfoo"
L = {"foo", "bar"}
```
then the map will look like
```
map("foo", {0, 9})
map("oob", {1})
map("oba", {2})
map("bar", {3})
map("ara", {4})
map("rab", {5})
map("abc", {6})
map("bcf", {7})
map("cfo", {8})
```

2. In the next step traverse over the list of words in L, look for each word in the map and add the indices from the map in the TreeSet. The reason to use TreeSet instead of a list of a simple set is because there can be repeating indicices coming from the hashMap. The idea is to have a sorted list of only unique indices. For that reason a treeSet is used which results in sorted set and later gets converted to a arrayList.

3. Traverse over the list generated in step 2. Take the index from arrayList and add to it length of word in L since the length of all words will be same adding the wordLen to ith index will give us a number. Check if the number exist in the arrayList. if it does look for next index.

The time complexity is O(n^2)
