package com.lei.com;

/*
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */

import java.util.Arrays;

public class Solution23 {


    /*
     * 只需要不断地确定出左子树区间和右子树区间，
     * 并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可
     * */
    public boolean VerifySquenceOfBST(int[] sequence) {

        if(sequence.length==0){

            return  false;
        }

        return  createTreeNode(sequence);
    }

    private boolean createTreeNode(int[] sequence) {

        int length = sequence.length;
        if (length == 0) {
            return true;

        }

        int headValue = sequence[length - 1];//根结点
        int i = 0;

        /*分别在数组中找出前半部分都小于根结点的，和后半部分都大于根结点的*/
        for (; i < length; ) {
            if (sequence[i] < headValue) {
                i++;
            } else {
                break;
            }

        }
        for (int j = i; j < length - 1; j++) {
            if (sequence[j] < headValue) {

                return false;
            }

        }

        return createTreeNode(Arrays.copyOfRange(sequence, 0, i))&&createTreeNode(Arrays.copyOfRange(sequence, i, length-1));

    }


    public static void main(String[] args) {
        int[] array = new int[]{4,8,6,12,16,14,10};
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.VerifySquenceOfBST(array));
    }
}
