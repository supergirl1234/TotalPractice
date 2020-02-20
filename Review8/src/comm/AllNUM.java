package comm;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
* 你有一套活字字模tiles，其中每个字模上都刻有一个字母tiles[i],返回你可以印出的非空字母序列的数目
*
* 例如：
* 输入“AAB”
* 输出8
* 解释：可能的序列：“A”,"B","AA","AB","BA","AAB","ABA","BAA"
* */
public class AllNUM {


    static void dfs(String tiles, Set<String> set, String curStr, ArrayList<Integer> book){

        /*当前拼接的字符串不为空，保存*/
        if(curStr!=null){

            set.add(curStr);
        }
        /*用当前字符串拼接每一个没有使用的字符*/
        for(int i=0;i<tiles.length();i++){
            if(book.get(i)==0){
                book.set(i,1);
                dfs(tiles,set,curStr+tiles.charAt(i),book);
                /*回退*/
                book.set(i,0);
            }

        }
    }
    public static int numTilePossibilities( String tiles){

        if(tiles==null){

            return  0;
        }
        Set<String> set=new HashSet<>();//用来保存结果集
        ArrayList<Integer> book=new ArrayList<>();//用来保存字符是否被使用过
        for(int i=0;i<tiles.length();i++){

            book.set(i,0);
        }
       dfs(tiles,set,"",book);
        return  set.size();

    }

    public static void main(String[] args) {

    }
}


