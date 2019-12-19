package comm;


/*
* 题目：
* 有N个小朋友站在一排，每个小朋友都有一个评分
你现在要按以下的规则给孩子们分糖果：
每个小朋友至少要分得一颗糖果
分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
你最少要分发多少颗糖果？
*
* */
public class Solution12 {

    public int candy(int[] ratings) {

        int[] candy=new int[ratings.length];

          /*初始化，每个孩子都有一个糖果*/
        for(int i=0;i<candy.length;i++){
            candy[i]=0;

        }

        /*从左到右，遍历一次，使分数高的比分数低的多糖果*/
        //从左向右扫描，保证一个方向上分数更大的糖果更多
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;

            }

        }

        /*从右到左，遍历一次*/
        //从右向左扫描，保证另一个方向上分数更大的糖果更多
        for(int i=ratings.length-2;i>=0;i--){

            if(ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]){
                candy[i]=candy[i+1]+1;

            }
        }
        int sum=0;
        for(int i=0;i<candy.length;i++){
            sum+=candy[i];

        }
        return  sum;
    }
}
