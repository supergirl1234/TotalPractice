package commm;


import java.util.ArrayList;

/*
* Combination
*
* 给出两个整数n和k，返回从1到n中取k个数字的所有可能的组合
例如：
如果n=4，k=2，结果为
[↵  [2,4],↵  [3,4],↵  [2,3],↵  [1,2],↵  [1,3],↵  [1,4],↵]
*
* */
public class Solution40 {


    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        ArrayList<Integer> list=new ArrayList<>();
        getAll(n,1,k,list);


        return  result;
    }

    private void getAll(int n, int start,int k, ArrayList<Integer> list) {

        if(k<0){

            return;
        }else if(k==0){
            result.add(new ArrayList<>(list));


        }else {

            for (int i = start; i <= n; i++) {

                list.add(i);
                getAll(n, i + 1, k - 1, list);

                list.remove(list.size()-1);
            }
        }


    }

    public static void main(String[] args) {
        Solution40 solution40=new Solution40();
        ArrayList<ArrayList<Integer>> result=solution40.combine(4,2);
        System.out.println(result);

    }
}
