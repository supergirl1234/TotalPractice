package commm;


import java.util.ArrayList;

/*
* 给出一个值numRows，生成杨辉三角的前numRows行
例如，给出 numRows = 5,
返回
[↵     [1],↵    [1,1],↵   [1,2,1],↵  [1,3,3,1],↵ [1,4,6,4,1]↵]
*
*
* */
public class Solution29 {
    ArrayList<ArrayList<Integer>>  List=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> generate(int numRows) {

     for(int i=0;i<numRows;i++){


         ArrayList<Integer> list=getRow(i);
         List.add(list);

     }
        return  List;

    }

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

    public ArrayList<ArrayList<Integer>> generate2(int numRows) {


        ArrayList<ArrayList<Integer>>  ListOuter=new ArrayList<>();

        if(numRows<=0){

            return  ListOuter;
        }
        ArrayList<Integer> list1=new ArrayList<>();
            list1.add(1);
            ListOuter.add(list1);
            if(numRows==1) {

                return ListOuter;
            }


        for(int i=1;i<numRows;i++){

            ArrayList<Integer> listInner=new ArrayList<>();
            listInner.add(1);//每一行的第一个数据

            ArrayList<Integer> preList=ListOuter.get(i-1);//获取上一行的数据

            for(int j=1;j<i;j++){
                listInner.add(preList.get(j-1)+ preList.get(j));
            }
            listInner.add(1);//每一行的最后一个数据
            ListOuter.add(listInner);
        }

        return  ListOuter;
    }


}
