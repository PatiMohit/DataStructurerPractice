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

    static int addNumbers(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = addNumbers(a, b);
        */
        int[][] parentChildPairs1 = new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},{4, 8}, {4, 9},
                {9, 11}, {14, 4}, {13, 12}, {12, 9}};

        //System.out.println("hasCommonAncestor(parentChildPairs1, 3, 8) => "+ hasCommonAncestor(parentChildPairs1, 3, 8));
        System.out.println("hasCommonAncestor(parentChildPairs1, 6, 8) => "+ hasCommonAncestor(parentChildPairs1, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));
        //System.out.println("hasCommonAncestor(parentChildPairs1, 3, 8) => "+ hasCommonAncestor(parentChildPairs1, 3, 8));
        //System.out.println("hasCommonAncestor(parentChildPairs1, 3, 8) => "+ hasCommonAncestor(parentChildPairs1, 3, 8));
        //hasCommonAncestor(parentChildPairs1, 6, 8) => true

    }
    private static boolean hasCommonAncestor(int [][] parentChildPairs1,int child1, int child2) {
        boolean hasCommonAncestor=false;
        Set<Integer> parentSet= new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, List<Integer>> childParent= new HashMap<>();
        for(int[] arr:parentChildPairs1){
            if(childParent.containsKey(arr[1])){
                List<Integer> list= childParent.get(arr[1]);
                list.add(arr[0]);
            }
            else{
                List<Integer> list=new ArrayList<Integer>();
                list.add(arr[0]);
                childParent.put(arr[1],list);
            }
        }
        //System.out.println(childParent);

        for(int[] arr:parentChildPairs1){
            //System.out.println("( " + arr[0]+ ", "+arr[1]+ " )"  );
            if(arr[1]==child1){
                //System.out.println("matched arr[1]= "+arr[1]  );
                queue.add(arr[0]);
                while(!queue.isEmpty()){
                    //System.out.println("queue before " + queue );
                    parentSet.add(queue.peek());
                    //System.out.println("childParent.get(queue.poll())=>" +childParent.get(queue.poll()));
                    if(childParent.get(queue.peek())==null){
                        queue.poll();
                        continue;
                    }
                    childParent.get(queue.poll()).stream().forEach(i->queue.add(i));
                    //System.out.println("queue after " + queue );
                }

            }
        }
        //System.out.println("parentSet "+parentSet);

        for(int[] arr:parentChildPairs1){
            //System.out.println("Second loop"  );
            //System.out.println("( " + arr[0]+ ", "+arr[1]+ " )"  );
            if(arr[1]==child2){
                queue.add(arr[0]);
                while(!queue.isEmpty()){
                    if(parentSet.contains(queue.peek())){
                        return true;
                    }
                    //System.out.println("queue before " + queue );
                    if(childParent.get(queue.peek())==null){
                        queue.poll();
                        continue;
                    }

                    childParent.get(queue.poll()).stream().forEach(i->queue.add(i));
                    //System.out.println("queue after " + queue );
                }
            }
        }

           /*
           if(arr[1]==child1){
           queue.add(arr[0]);
           while(queue.isEmpty()){
               parentSet.add(queue.peek());
               queue.add(childParent.get(queue.poll()));
           }
           break;
       }
       */

        return hasCommonAncestor;

    }
}
