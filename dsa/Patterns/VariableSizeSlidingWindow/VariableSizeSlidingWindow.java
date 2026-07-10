package dsa.Patterns.VariableSizeSlidingWindow;

import java.util.HashSet;
import java.util.Set;

/*Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3

Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */
public class VariableSizeSlidingWindow {
    public int lengthOfLongestSubStrwithoutDubChar(String s) {
        // Store the maximum length of substring found.
        int maxLength = 0;
        // Store unique characters in the current sliding window.
        Set<Character> window = new HashSet<>();
        // Left pointer of the sliding window.
        int left = 0;
        // Move the right pointer through each character.
        for (int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            while (window.contains(currentCharacter)) {
                // Shrink the window until the duplicate character is removed.
                window.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the window.
            window.add(currentCharacter);
            // Calculate the current window length.
            int currentLength = right - left + 1;
            // Update the maximum length found.
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        VariableSizeSlidingWindow variableSizeSlidingWindow = new VariableSizeSlidingWindow();
        int result1 = variableSizeSlidingWindow.lengthOfLongestSubStrwithoutDubChar("abcabcbb");
        System.out.println(result1);
        int result2 = variableSizeSlidingWindow.lengthOfLongestSubStrwithoutDubChar("bbbbb");
        System.out.println(result2);
        int result3 = variableSizeSlidingWindow.lengthOfLongestSubStrwithoutDubChar("pwwkew");
        System.out.println(result3);
    }
}
