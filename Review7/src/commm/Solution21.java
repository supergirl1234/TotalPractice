package commm;

import java.util.*;

/*
* 题目：
* 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
返回所有可能的结果
例如：给定的字符串s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].

返回的结果为["cats and dog", "cat sand dog"].
*
*
* */
public class Solution21{

    Map<String,ArrayList<String>> map=new HashMap<>();/*用来存放已经分割的字符串，以及其分割后的结果*/

    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        if(map.containsKey(s)){
            return  map.get(s);
        }
        ArrayList<String> list=new ArrayList<>();
        if(s.length()==0){

            list.add("");
            map.put(s,list);
            return  list;
        }

        for(String item:dict){

            if(s.startsWith(item)){ //先找到该字符串中首部字符串在dict中的

                ArrayList<String>  listInner=wordBreak(s.substring(item.length()),dict);

                for(String str:listInner){
                    if(str==""){

                        list.add(item+""+str);
                    }else{

                        list.add(item+" "+str);
                    }


                }


                map.put(s,list);


            }
        }

        return  list;

    }


}
