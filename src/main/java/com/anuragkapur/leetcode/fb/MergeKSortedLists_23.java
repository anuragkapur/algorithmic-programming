package com.anuragkapur.leetcode.fb;

public class MergeKSortedLists_23 {
    ListNode root = null;
    ListNode current = null;

    /**
     * RTC: O(KN)
     * where,
     *  K = number of sorted lists to merge
     *  N = total elements in all lists combined
     */
    public ListNode mergeKLists(ListNode[] lists) {
        mergeKListsRecursively(lists);
        return root;
    }

    private void mergeKListsRecursively(ListNode[] lists) {
        // base case: all lists are empty
        boolean empty = true;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                empty = false;
                break;
            }
        }
        if (empty) {
            return;
        }

        // recursive case
        int minNodeIndex = findMinIndex(lists);
        if (root == null) {
            root = lists[minNodeIndex];
            current = lists[minNodeIndex];
        } else {
            current.next = lists[minNodeIndex];
            current = current.next;
        }

        lists[minNodeIndex] = lists[minNodeIndex].next;
        mergeKListsRecursively(lists);
    }

    private int findMinIndex(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
