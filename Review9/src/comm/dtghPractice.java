package comm;



/*
 * 给定一个字符串s和一个词典dict，确定s是否可以根据词典中的词分成一个或多个单词
 * 比如：给定s="leetcode"  dict=["leet","code"],返回true
 *
 * */

/*
 * 动态规划，首先要想到的是定义状态
 *
 * 状态F(i):s的前i个字符是否可以被分割
 * F(i)=F(i-n)&&n-i个字符是否可以被分割,也可以写为：F(i)=F(j)&&s(j+1到i的字符)
 *
 * */
import java.util.Set;
import java.util.TreeSet;

public class dtghPractice {


    public  static  boolean isFen(String s, Set<String> dict){
        if(s==null||dict.isEmpty()){

            return  false;
        }

        boolean[] booleanS=new boolean[s.length()+1];
        booleanS[0]=true;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<=i;j++) {
                String str=s.substring(j,i+1);
                booleanS[i + 1] = booleanS[j]&&dict.contains(str);
                if(booleanS[i + 1]){
                    break;
                }
            }
        }
        return booleanS[booleanS.length-1];

    }
    public static void main(String[] args) {

        String s="leetcode";
        Set<String> set=new TreeSet<>();
        set.add("leet");
        set.add("code");
        boolean result=isFen(s,set);
        System.out.println(result);
    }
}
