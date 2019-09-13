package commmmm;


/*String字符串拼接通过StringBuilder走中间过程，通过append方法实现
* null拼接会变成字符串"null"*/
public class Test1 {


    public static void code1(){
        String str1="hello";
        String str2=" word!";
        String str3="hello word!";
        String str4=str1+"word!";
        System.out.println(str3==str4);//false


        //String的“+”拼接字符串，其真正实现的原理是中间通过建立临时的StringBuilder对象，然后调用append方法实现,
        // 然后StringBuilder对象再调用toString方法转化为String，但toString方法中是新new了一个String对象


    }
    public static void code2(){
        String str3="hello"+" word!";//str3的值hello word!会入池
        String str4="hello word!";
        System.out.println(str3==str4);//true


        StringBuilder sb=new StringBuilder();
    }
    public static void code3(){

        String str3="hello word!";
        String str4="hello"+" word!";
        System.out.println(str3==str4);//true
        StringBuilder sb=new StringBuilder();

    }
    public static void main(String[] args) {
        code3();
        String str1 = null;
        String str2 = "222222";
        String str = str1 + str2;
        System.out.println(str);//null222222
        //因为在源码中：如果str=null,sb.append(str)是这样处理的：
        /* public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }
*/


    }
}
