package com.ml.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.ml
 * @date 2021/6/18
 *
 * 运用你所掌握的数据结构，设计和实现一个LRU（最近最少使用）缓存机制。
 * 实现LRUCache类：
 * LRUCache(int capacity) 以正整数作为容量capacity初始化LRU缓存。
 * int get(int key) 如果关键字key存在于缓存中，则返回关键字的值，否则返回-1。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class Solution_146_LRUCache {

    class Node {
        private Integer key;
        private Integer value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer size;
    private Integer capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head, tail;

    public Solution_146_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            if (++size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
            addToHead(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private Node removeTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

}
