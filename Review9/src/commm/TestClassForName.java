package commm;

public class TestClassForName {

    public static void main(String[] args) {
        try {
            System.out.println("Class.forName的加载：");
            Class.forName("commm.StaticClass");
            System.out.println();

            System.out.println("ClassLoader的加载：");
            ClassLoader.getSystemClassLoader().loadClass("commm.StaticClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
