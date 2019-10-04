package comm;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
*
* 某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。

 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
 全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
* */
public class Test26 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String shop=scanner.nextLine();
        String customer=scanner.nextLine();
        Map<Character,Integer> shopMap=new HashMap<>();
        Map<Character,Integer> customerMap=new HashMap<>();
        for(int i=0;i<shop.length();i++){
            if(shopMap.containsKey(shop.charAt(i))){
                shopMap.put(shop.charAt(i),shopMap.get(shop.charAt(i))+1);
            }else{
                shopMap.put(shop.charAt(i),1);
            }
        }
        for(int i=0;i<customer.length();i++){
            if(customerMap.containsKey(shop.charAt(i))){
                customerMap.put(customer.charAt(i),customerMap.get(customer.charAt(i))+1);
            }else{
                customerMap.put(customer.charAt(i),1);

            }
        }

        Set<Map.Entry<Character,Integer>> set=customerMap.entrySet();

        int  more=0;
        int lack=0;
        boolean isEngouh=true;
        for(Map.Entry<Character,Integer> item:set){

            Character str=item.getKey();
            int value=item.getValue();
            if(shopMap.containsKey(str) && shopMap.get(str)>value){

                more+=shopMap.get(str)-value;

            }else if(shopMap.containsKey(str) && shopMap.get(str)<value){
                isEngouh=false;
                lack+=value-shopMap.get(str);
            }else if(!shopMap.containsKey(str)){
                isEngouh=false;
                lack+=value;

            }

        }
        if(!isEngouh){
            System.out.println("NO "+lack);
        }else{

            System.out.println("YES "+more);
        }
    }
}
