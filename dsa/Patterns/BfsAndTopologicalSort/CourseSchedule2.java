package dsa.Patterns.BfsAndTopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 
Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct. */
public class CourseSchedule2 {
    public int[] finalOrder(int numCourses, int[][] prerequisites) {
        // Store the courses that become available after completing each prerequisite
        // course
        List<List<Integer>> graph = new ArrayList<>();
        // Create an empty neighbor list for every course
        for (int course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
        }
        // Get the indegree : Track how many prerequisites each course is still waiting
        // for
        int[] indegree = new int[numCourses];
        // Build the directed graph and count the prerequisites of each course
        for (int[] prerequisite : prerequisites) {
            // Extract the course that must be completed later
            int course = prerequisite[0];
            // Extract the prerequisite course that must be completed first
            int prerequisiteCourse = prerequisite[1];
            // Store the directed connection from prerequisite course to dependent course
            graph.get(prerequisiteCourse).add(course);
            // Increase the number of prerequisites required by the dependent course
            indegree[course]++;
        }
        // Store the final valid course completion order
        int[] order = new int[numCourses];
        // Track the next position in the result and the number of processed courses
        int index = 0;
        // Store all courses that are currently ready to be completed
        Queue<Integer> queue = new LinkedList<>();
        // Add every course with no remaining prerequisites to the queue
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }
        // BFS starts
        // Process all ready courses using BFS
        while (!queue.isEmpty()) {
            // Remove the next course with no remaining prerequisites
            int currentCourse = queue.poll();
            // Add the completed course to the final topological order
            order[index] = currentCourse;
            // Move to the next result position and count the processed course
            index++;
            // Check every course that depends on the completed course
            for (int neighbor : graph.get(currentCourse)) {

                // Mark one prerequisite of the dependent course as completed
                indegree[neighbor]--;
                // Add the dependent course when all of its prerequisites are completed
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // Return the valid order only if every course was successfully processed
        if (index == numCourses) {
            return order;
        }

        // Return an empty array when a cycle prevents all courses from being completed
        return new int[] {};
    }

    public static void main(String[] args) {
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        // Test a simple prerequisite relationship
        int[] result1 = courseSchedule2.finalOrder(2, new int[][] { { 1, 0 } });
        System.out.println(Arrays.toString(result1));
        // Test multiple prerequisite relationships
        int[] result2 = courseSchedule2.finalOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        System.out.println(Arrays.toString(result2));
        // Test a single course with no prerequisites
        int[] result3 = courseSchedule2.finalOrder(1, new int[][] {});
        System.out.println(Arrays.toString(result3));
    }
}
