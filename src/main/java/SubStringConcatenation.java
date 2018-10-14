/*

You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any
intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).

 */

package main.java;

import java.util.*;

public class SubStringConcatenation {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        ArrayList<Integer> indices = findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list);
        for(int index : indices)
            System.out.print(index+", ");
    }

    public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (B.isEmpty())
            return result;

        int wordLen = B.get(0).length();

        Map<String, List<Integer>> map = new HashMap<>();

        int m = 0;
        for (int i=wordLen; i<=A.length(); i++){
            String word = A.substring(m,i);
            List<Integer> indexList = map.get(word);
            if (indexList == null){
                indexList = new ArrayList<>();
            }
            indexList.add(m);
            map.put(word, indexList);
            ++m;
        }

        Set<Integer> allIndicesSet = new TreeSet<>();
        for (String word : B){
            List<Integer> indexListForWord = map.get(word);
            if (indexListForWord == null)
                return result;

            allIndicesSet.addAll(indexListForWord);
        }

        List<Integer> allIndices = new ArrayList<>(allIndicesSet);

        boolean notFound;
        for (int i=0; i<allIndices.size(); i++) {
            int index = allIndices.get(i);
            notFound = false;
            int j = 0;
            while (j<B.size()) {
                if (!allIndices.contains(index)) {
                    notFound = true;
                    break;
                }
                index += wordLen;
                j++;
            }
            if (!notFound)
                result.add(allIndices.get(i));
        }

        return result;
    }
}
