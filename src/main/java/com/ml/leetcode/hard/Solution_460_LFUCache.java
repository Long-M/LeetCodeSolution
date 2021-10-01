package com.ml.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Mr.ml
 * @date 2021/9/15
 *
 * 请你为最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现LFUCache类：
 * LFUCache(int capacity) - 用数据结构的容量capacity初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回-1
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最近最久未使用的键
 *
 * 注意「项的使用次数」就是自插入该项以来对其调用get和put函数的次数之和。使用次数会在对应项被移除后置为0。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个使用计数器。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为1(由于put操作)。对缓存中的键执行get或put操作，使用计数器的值将会递增。
 */
public class Solution_460_LFUCache {
    int minFrequency, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, LinkedList<Node>> frequencyTable;

    public Solution_460_LFUCache(int capacity) {
        this.minFrequency = 0;
        this.capacity = capacity;
        keyTable = new HashMap<Integer, Node>();
        frequencyTable = new HashMap<Integer, LinkedList<Node>>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyTable.containsKey(key)) {
            return -1;
        }
        Node node = keyTable.get(key);
        int value = node.val, frequency = node.frequency;
        frequencyTable.get(frequency).remove(node);
        // 如果当前链表为空，我们需要在哈希表中删除，且更新minFrequency
        if (frequencyTable.get(frequency).size() == 0) {
            frequencyTable.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency += 1;
            }
        }
        // 插入到frequency+1中
        LinkedList<Node> list = frequencyTable.getOrDefault(frequency + 1, new LinkedList<Node>());
        list.offerFirst(new Node(key, value, frequency + 1));
        frequencyTable.put(frequency + 1, list);
        keyTable.put(key, frequencyTable.get(frequency + 1).peekFirst());
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyTable.containsKey(key)) {
            // 缓存已满，需要进行删除操作
            if (keyTable.size() == capacity) {
                // 通过minFrequency拿到frequencyTable[minFrequency]链表的末尾节点
                Node node = frequencyTable.get(minFrequency).peekLast();
                keyTable.remove(node.key);
                frequencyTable.get(minFrequency).pollLast();
                if (frequencyTable.get(minFrequency).size() == 0) {
                    frequencyTable.remove(minFrequency);
                }
            }
            LinkedList<Node> list = frequencyTable.getOrDefault(1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, 1));
            frequencyTable.put(1, list);
            keyTable.put(key, frequencyTable.get(1).peekFirst());
            minFrequency = 1;
        } else {
            // 与get操作基本一致，除了需要更新缓存的值
            Node node = keyTable.get(key);
            int frequency = node.frequency;
            frequencyTable.get(frequency).remove(node);
            if (frequencyTable.get(frequency).size() == 0) {
                frequencyTable.remove(frequency);
                if (minFrequency == frequency) {
                    minFrequency += 1;
                }
            }
            LinkedList<Node> list = frequencyTable.getOrDefault(frequency + 1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, frequency + 1));
            frequencyTable.put(frequency + 1, list);
            keyTable.put(key, frequencyTable.get(frequency + 1).peekFirst());
        }
    }
}

class Node {
    int key, val, frequency;

    Node(int key, int val, int frequency) {
        this.key = key;
        this.val = val;
        this.frequency = frequency;
    }
}