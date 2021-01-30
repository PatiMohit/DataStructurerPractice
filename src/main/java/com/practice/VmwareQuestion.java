package com.practice;
/*



Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have a common ancestor of 4.

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11
   
parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]
int[][] parentChildPairs1 = new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},{4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}};



Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true
*/


import java.util.*;

public class VmwareQuestion {

    public static void main(String[] args) {

        int[][] parentChildPairs1 = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9},
                {9, 11}, {14, 4}, {13, 12}, {12, 9}};

        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));


    }

    private static boolean hasCommonAncestor(int[][] parentChildPairs1, int child1, int child2) {
        boolean hasCommonAncestor = false;
        Set<Integer> parentSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, List<Integer>> childParent = new HashMap<>();

        for (int[] arr : parentChildPairs1) {
            if (childParent.containsKey(arr[1])) {
                List<Integer> list = childParent.get(arr[1]);
                list.add(arr[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                childParent.put(arr[1], list);
            }
        }

        if (childParent.get(child1) == null) return false;
        childParent.get(child1).forEach(i -> queue.add(i));

        while (!queue.isEmpty()) {
            parentSet.add(queue.peek());
            if (childParent.get(queue.peek()) == null) {
                queue.poll();
                continue;
            }
            childParent.get(queue.poll()).forEach(i -> queue.add(i));
        }

        if (childParent.get(child2) == null) return false;
        childParent.get(child2).forEach(i -> queue.add(i));

        while (!queue.isEmpty()) {
            if (parentSet.contains(queue.peek())) {
                return true;
            }
            if (childParent.get(queue.peek()) == null) {
                queue.poll();
                continue;
            }
            childParent.get(queue.poll()).stream().forEach(i -> queue.add(i));
        }
        return hasCommonAncestor;
    }
}
