package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mr.ml
 * @date 2021/7/18
 *
 * 你这个学期必须选修numCourses门课程，记为0到numCourses-1。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组prerequisites给出，
 * 其中prerequisites[i]=[ai,bi]，表示如果要学习课程ai则必须先学习课程bi。
 * 例如，先修课程对[0,1]表示：想要学习课程0，你需要先完成课程1。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回true；否则，返回false。
 */
public class Solution_207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList());
        }
        for (int cp[] : prerequisites) {
            // 构建入度表
            indegrees[cp[0]]++;
            // 构建邻接表
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                // 将所有入度为0的节点入队
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            // 当queue非空时，依次将队首节点出队
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                // 当入度减1后邻接节点cur的入度为0
                if (--indegrees[cur] == 0) {
                    // 说明cur所有的前驱节点已经被删除，此时将cur入队
                    queue.add(cur);
                }
            }
        }
        // 拓扑排序出队次数等于课程个数，返回numCourses==0判断课程是否可以成功安排
        return numCourses == 0;
    }

}
