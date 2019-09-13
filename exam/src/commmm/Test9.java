package commmm;

public class Test9 {
    public static void main(String[] args) {
        Integer i01 = 59;  //
        int i02 = 59;//基本数据类型
        Integer i03 = Integer.valueOf(59);//此处就相当于是Integer i03 =59;
        Integer i04 = new Integer(59);

        System.out.println(i01==i02);//true
        System.out.println(i03==i04);//false
        System.out.println(i01==i04);//false 原因：非new生成的Integer变量指向的是静态常量池中cache数组中存储的指向了堆中的Integer对象，而new Integer()生成的变量指向堆中新建的对象，两者在内存中的对象引用（地址）不同
        System.out.println(i02==i04);//true
        System.out.println(i01==i03);//true
        System.out.println(i02==i03);//true

        //当Integer与int进行==比较时，Integer就会拆箱成一个int类型，所以还是相当于两个int类型进行比较，
        // 这里的Integer,不管是直接赋值，还是new创建的对象，只要跟int比较就会拆箱为int类型，所以就是相等的
    }
}
