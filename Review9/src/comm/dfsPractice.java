package comm;


import java.util.*;

/*
 * 广度优先
 *
 * 给定两个单词（beginWord和endWord）和一个字典，找到从beginWord到endWord的最短转换序列的长度，转换需要遵循如下规则：
 * 每次转换只能改变一个字母，转换过程中的中间单词必须是字典中的单词
 * beginWord="hit"
 * endWord="cog"
 * wordList=["hot","dot","dog","lot","cog"]
 * 转换过程："hit"->"hot"->"dot"->"dog"->"cog"
 *
 * */
public class dfsPractice {

    public  static int minNeed(String beginWord,String endWord,Set<String> wordList){

        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        Set<String> set=new HashSet<>();
        int minNum=0;

        while(!queue.isEmpty()){


            //换一个字符的所有可能性
            int size=queue.size();
            while(size--!=0) {
                String str=queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j < 'z'; j++) {
                        chars[i] = j;
                        String newStr=new String(chars);
                        if (wordList.contains(newStr)&&!set.contains(newStr)) {
                            queue.add(newStr);
                            if(str.equals(endWord)){
                                return  minNum+1;
                            }else{
                                queue.add(newStr);
                                set.add(newStr);
                            }
                        }
                    }


                }
            }
            minNum++;
        }
        return  0;

    }
    public static void main(String[] args) {
        String beginWord="hit";
        String endWord= "cog";
        Set<String> wordList=new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("cog");
        int result=dfsPractice.minNeed(beginWord,endWord,wordList);
        System.out.println(result);


    }
}
