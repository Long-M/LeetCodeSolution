package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/7/29
 *
 * 假设有打乱顺序的一群人站成一个队列，数组people表示队列中一些人的属性（不一定按顺序）。
 * 每个people[i]=[hi, ki]表示第i个人的身高为hi，前面正好有ki个身高大于或等于hi的人。
 * 请你重新构造并返回输入数组people所表示的队列。
 * 返回的队列应该格式化为数组queue，其中queue[j]=[hj,kj]是队列中第j个人的属性（queue[0]是排在队列前面的人）。
 */
public class Solution_406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
