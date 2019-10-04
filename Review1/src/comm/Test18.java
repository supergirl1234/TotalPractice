package comm;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
* 从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 例如:s = AGGTCTA
序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
* */

//思路：
// 每种长度n都会有4^n种可能。例如长度为1时就有（A，C，G，T）这四种。n=2时就16种。
//
//接下来，寻找输入串中，长度为n的子串有多少种，如果数量不足2^n个，则输出n即可
// 第一步：从长度为1到长度为n分别进行讨论，将长度为i的子串加入到set容器中去
// ，set容器会自动除去重复 的元素，这样set容器的大小size()就 表示长度为i的种类数量了。
// 第二步：长度为i的序列总共有4的i次方个（排列组合：每个位置都有四种选择），
// 然后将set容器的size()与 4的i次方进行比较，如果小于4的i次方，那肯定存在不包含的序列。
public class Test18 {


    public static  int test(String str){


        for(int i=0;i<str.length();i++){
            Set<String> set=new HashSet<>();
            for(int j=0;j<str.length()-i;j++){

                set.add(str.substring(j,j+i));
            }
            if(set.size()<Math.pow(4,i)){
                return  i;

            }

        }
        return  -1;

    }
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int result=test(str);
        System.out.println(result);
    }
}
