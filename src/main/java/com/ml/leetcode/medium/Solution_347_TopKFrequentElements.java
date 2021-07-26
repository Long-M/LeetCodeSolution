package com.ml.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Mr.ml
 * @date 2021/7/26
 *
 * 给你一个整数数组nums和一个整数k，请你返回其中出现频率前k高的元素。你可以按任意顺序返回答案。
 */
public class Solution_347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
        counter.forEach((key, value) -> {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (counter.get(pq.peek()) < value) {
                pq.poll();
                pq.offer(key);
            }
        });
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
