package commm;


import java.util.ArrayList;

/*
* 题目：
* 给出一个索引k，返回杨辉三角的第k行
例如，k=3，
返回[1,3,3,1].
备注：
你能将你的算法优化到只使用O(k)的额外空间吗?
*
* */
public class Solution28 {

    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> list=new ArrayList<>();
        if(rowIndex==0){

            list.add(1);
            return  list;
        }
        if(rowIndex==1){

            list.add(1);
            list.add(1);
            return  list;
        }

        ArrayList<Integer> PreList=getRow(rowIndex-1);
        list.add(1);
        for(int i=1;i<rowIndex;i++){

            list.add(PreList.get(i-1)+PreList.get(i));

        }
        list.add(1);

        return  list;


    }
}
