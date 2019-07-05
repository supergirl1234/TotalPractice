package com;


import java.util.*;

/*
*  unsigned int AddCandidate(char*p pCandidateName)
*
*  void Vote(char* pCandidateName)
* */
public class Candidate {
    //用一个Map来保存候选人姓名和票数
    static  Map<String,Integer> map=new HashMap<>();
    //总人数
    static int pNum;
    //总票数
    static int pVote=0;
    //无效票数
    private static int invalid=0;


    /*设置候选人姓名
    * 输入值非法返回0，已经添加过则返回0，添加成功返回1
    * */
    public  int AddCandidate( String name){

       if(map.containsKey(name)){
           return 0;

       }else if(map.size()>pNum){
            return  0;

       } else{

            map.put(name,0);
       }
        return 1;
    }
    /*
    * 投票
    * */
    public void Vote(String name){


        if(map.containsKey(name)){

            map.replace(name,map.get(name),map.get(name)+1) ;
        }else{

            invalid++;
        }
    }
    /*
    * 获取候选人的票数。如果传入为空，则返回无效的票数，同时说明本次投票活动结束，释放资源
    * String name：候选人姓名
    * retuen该候选人的票数
    * */
    public int GetVoteResult(String name){

        if(name==""){

            Clear();
            return 0;
        }
        return map.get(name);
    }

    /*
    * 清除投票结果，释放所有资源
    * */
    public void Clear(){

        map.clear();

    }
    public static void main(String[] args) {

        Candidate candidate=new Candidate();
        /*
        * 第一行：输入候选人的人数
        * 第二行：输入候选人的名字
        * 第三行：输入投票人的人数
        * 第四行：输入投票
        * */

        Scanner scanner=new Scanner(System.in);

            pNum = scanner.nextInt();

            for (int i = 0; i < pNum; i++) {
                String name=scanner.next();
                candidate.AddCandidate(name);
            }
            pVote = scanner.nextInt();

            for (int i = 0; i < pVote; i++) {

                 candidate.Vote(scanner.next());

            }

            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> item : set) {
                int result = candidate.GetVoteResult(item.getKey());
                System.out.println(item.getKey() + ":" + result);
            }
            System.out.println("Invalid:" + invalid);



    }
}
