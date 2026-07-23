package dsa.Patterns.WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique. */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list into a HashSet for O(1) lookup and removal.
        HashSet<String> dictionary = new HashSet<>(wordList);
        // If the target word doesn't exist, transformation is impossible.
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        // Queue for BFS traversal.
        Queue<String> queue = new LinkedList<>();
        // Start BFS from the begin word.
        queue.offer(beginWord);
        // Level represents the current transformation sequence length.
        int level = 1;
        while (!queue.isEmpty()) {
            // Process one BFS level at a time.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // Current word being explored.
                String word = queue.poll();
                // Convert String to char array so characters can be modified.
                char[] chars = word.toCharArray();
                // Try changing every character.
                for (int pos = 0; pos < chars.length; pos++) {
                    // Save the original character.
                    char original = chars[pos];
                    // Replace it with every letter from a-z.
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[pos] = ch;
                        // Form the new transformed word.
                        String newWord = new String(chars);
                        // If we've reached the destination, return the answer.
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        // If it's a valid dictionary word, explore it.
                        if (dictionary.contains(newWord)) {
                            queue.offer(newWord);
                            // Remove immediately to mark it as visited.
                            dictionary.remove(newWord);
                        }
                    }
                    // Restore the original character before moving to the next position.
                    chars[pos] = original;
                }
            }
            // Finished one BFS level.
            level++;
        }
        // No transformation sequence exists.
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        // =========================
        // Example 1
        // =========================
        System.out.println("Example 1");
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Begin Word : " + beginWord);
        System.out.println("End Word   : " + endWord);
        System.out.println("Word List  : " + wordList);
        int result1 = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("Output     : " + result1);

        // =========================
        // Example 2
        // =========================
        System.out.println("\nExample 2");
        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Begin Word : " + beginWord);
        System.out.println("End Word   : " + endWord);
        System.out.println("Word List  : " + wordList);
        int result2 = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("Output     : " + result2);
    }
}
