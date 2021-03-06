package comm;


/*
*
* 请实现接口：

unsigned int  AddCandidate (char* pCandidateName);
功能：设置候选人姓名
输入： char* pCandidateName 候选人姓名
输出：无
返回：输入值非法返回0，已经添加过返回0 ，添加成功返回1



Void Vote(char* pCandidateName);
功能：投票
输入： char* pCandidateName 候选人姓名
输出：无
返回：无


unsigned int  GetVoteResult (char* pCandidateName);

功能：获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
输入： char* pCandidateName 候选人姓名。当输入一个空指针时，返回无效的票数

输出：无
返回：该候选人获取的票数



void Clear()

// 功能：清除投票结果，释放所有资源
// 输入：
// 输出：无
// 返回

* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*
* 输入：输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票
* 输出：每行输出候选人的名字和得票数量。
* */
public class Test27 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<num;i++){

            map.put(scanner.next(),0);

        }
        int valid=0;//无效票数
        int count=scanner.nextInt();
        for(int i=0;i<count;i++){

            String s=scanner.next();
            if(map.containsKey(s)){


                map.put(s,map.get(s)+1);
            }else{

                valid++;
            }

        }

        for(Map.Entry<String,Integer> item:map.entrySet()){

            System.out.println(item.getKey()+":"+item.getValue());
        }
        System.out.println("valid:"+valid);

    }
}
