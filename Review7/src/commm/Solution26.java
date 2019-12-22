package commm;

/*
* 题目：
* 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
例如，给出的三角形如下：
[↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
注意：
如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。
*
* */

import java.util.ArrayList;


public class Solution26 {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        if (triangle == null) {

            return -1;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(triangle.get(0).get(0));
        result.add(list1);

        int listSize = triangle.size();
        for (int i = 1; i < listSize; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(triangle.get(i).get(0) + result.get(i - 1).get(0));

            result.add(list);

        }

        for (int i = 1; i < listSize; i++) {

            ArrayList<Integer> list = triangle.get(i);
            ArrayList<Integer> preResultInner = result.get(i - 1);
            ArrayList<Integer> resultInner = result.get(i);
            int size = list.size();
            for (int j = 1; j < size; j++) {

                if (j >= preResultInner.size()) {
                    resultInner.add(list.get(j) + preResultInner.get(j - 1));

                }
                 else {


                    resultInner.add(list.get(j) + Math.min(preResultInner.get(j - 1), preResultInner.get(j)));
                }
            }

        }

        ArrayList<Integer> FinalR = result.get(result.size() - 1);

        int min = Integer.MAX_VALUE;
        for (Integer item : FinalR) {

            if (item < min) {
                min = item;

            }
        }

        return min;


    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        list2.add(-3);
        triangle.add(list1);
        triangle.add(list2);

        Solution26 solution26 = new Solution26();
        int result = solution26.minimumTotal(triangle);
        System.out.println(result);
    }
}
