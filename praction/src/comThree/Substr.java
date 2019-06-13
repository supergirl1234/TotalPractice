package comThree;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/13 0013
 *
 *
 * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
 *
 * 测试样例：
 * ["a","b","c","d"],4,"abc"
 * 返回：[true,true,true,false]
 */
public class Substr {

    public static boolean[] checkSubStr(String[] str,int n,String s){

        //创建一个存储结果的数组
        boolean[] result=new boolean[str.length];
        for(int i=0;i<str.length;i++){

            result[i]=s.contains(str[i]);
        }
        return  result;


    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组的大小n和string数组p，和一个字符串s");

        Scanner in=new Scanner(System.in);
        while(in.hasNext()){

            int num=in.nextInt();
            String[] str=new String[num];
            for(int i=0;i<num;i++){

                str[i]=in.next();
            }
            String s=in.nextLine();
            boolean[] result=checkSubStr(str,num,s);


            System.out.println(Arrays.toString(result));
        }

    }
}
