/*Given a string s, return the lexicographically smallest subsequence of s that contains all the
 distinct characters of s exactly once.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.*/
package dailyleetcode;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.*;

public class SmallestSubsequenceOfDistinctCharacters {
    // This algorithm didn't work - because this approach is greedy and doesn't take into account that there are
    // other options that could lead to more efficient results
    // this is because we build the unique string by taking unique elements ONCE we find it
    // but there could be other alternatives that could be "cheaper"
    // so another approach I'm going to try and chatGPT suggested this, is to use a monotonic stack
    // for me to do this, I believe I need to keep track of how many duplicates there are in the string and the index of them
    // so if a duplicate exists, we can skip that letter and try picking it up later basically.

//    public static String smallestSubsequence(String s) {
//        int[] occurenceList = new int[26];
//        int tracker = 0;
//        for (int i = 0; i<s.length();i++) {
//            char character = s.charAt(i);
//            int index = character - 'a';
//            occurenceList[index] += 1;
//            if (occurenceList[index] == 1) {
//                tracker++;
//            }
//        }
//        Map<Integer, Integer> foundItems;
//        StringBuilder w = new StringBuilder();
//        StringBuilder prevString = new StringBuilder();
//        int startIdx = 0;
//        int prevIdx = 0;
//        while (startIdx+tracker <= s.length()) { // b c a b c
//            if (s.charAt(startIdx) > s.charAt(prevIdx)) {
//                startIdx++;
//                continue;
//            }
//            w.setLength(0);
//            foundItems = new HashMap<>();
//            for (int i = startIdx; i < s.length(); i++) { // c b a c d c b c
//                char character = s.charAt(i);
//                int index = character - 'a';
//                Integer itemInMap = foundItems.get(index);
//                if (itemInMap != null && itemInMap >= 1) {
//                    continue;
//                }
//                foundItems.put(index,1);
//
//                w.append(character);
//            }
//            if (w.length() == tracker) { // this solution was wrong and we should do something about it
//
//                prevIdx = startIdx;
//                prevString.setLength(0);
//                prevString.append(w);
//            }
//            startIdx++;
//        }
//
//        return prevString.toString();
//    }

    /*While the last character in my answer is larger than the current character...
AND I can still encounter that larger character later...
remove it.*/
    public static String smallestSubsequence(String s) {
        Map<Character, List<Integer>> indexTracker = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexTracker.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        } // b c a b c
        char[] myMonotonicStack = new char[13];
        int[] charactersSeen = new int[6];
        int topCounter = -1;
        for (int i = 0; i < s.length(); i++ ) {  // b c a b c
            char character = s.charAt(i);
//            System.out.printf("What we've seen we're looking at %c: ", character);
//            System.out.println(Arrays.toString(charactersSeen));
            int alphabeticalIndex = character - 'a';
//            System.out.printf("Top counter = %d Character looking at %c%n",topCounter,character);
//            System.out.println(Arrays.toString(myMonotonicStack));
            if (topCounter == -1) { // c b a c d c b c
                topCounter++;
                myMonotonicStack[topCounter] = character;
                charactersSeen[alphabeticalIndex] = 1;
            }
            // compare with top
            char topCharacter = myMonotonicStack[topCounter]; // b c a b c
            if (topCharacter < character) {
                if (charactersSeen[alphabeticalIndex] == 0) {
                    topCounter++;
                    myMonotonicStack[topCounter] = character;
                    charactersSeen[alphabeticalIndex] = 1;
                }
            }
            else {
                if (charactersSeen[alphabeticalIndex] == 1) {
                    continue;
                }

                while (character<myMonotonicStack[topCounter]) {
                    List<Integer> characterIndexes = indexTracker.get(myMonotonicStack[topCounter]); // to confirm if one exists in front
                    int indexOfTop = myMonotonicStack[topCounter] - 'a';
                    if (i < characterIndexes.getLast()) { // if we can still see that larger number again...
                        topCounter--; // remove that number from the stack.
                        charactersSeen[indexOfTop]= 0;
                    } else {
                        topCounter++;
                        myMonotonicStack[topCounter] = character;
                        charactersSeen[alphabeticalIndex]= 1;
                    }
                    if (topCounter == -1 || myMonotonicStack[topCounter] < character) { // break - we're done here I guess
                        topCounter++;
                        myMonotonicStack[topCounter] = character;
                        charactersSeen[alphabeticalIndex]= 1;
                        break;
                    }
                }
            }
        }
        return String.valueOf(myMonotonicStack,0,topCounter+1);
    }
    public static void main(String[] args) {
        String s = "bcabc";
        String s2 = "cbacdcbc";
        String s3 = "cdadabcc"; // expected output: "a d b c"
        String s4 = "ecbacba"; // expected output: e a c b
        String s5 = "cbaacabcaaccaacababa";
        System.out.println(smallestSubsequence(s3));
        System.out.println(smallestSubsequence(s2));
        System.out.println(smallestSubsequence(s));
        System.out.println(smallestSubsequence(s4));
        System.out.println(smallestSubsequence(s5));


    }
}
