package comm;


class   Father{

     public String name;
     public  String addr;

    public Father(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
}
class   Childern{

   public int age;

    public Childern(int age) {
      super();//必须放在首行
        this.age = age;


    }
}
public class ThisSuperTest {

    public static void main(String[] args) {

        Childern childern=new Childern(12);
    }
}
