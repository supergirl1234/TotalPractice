package comm;


import javax.lang.model.element.NestingKind;
import java.util.*;

/*
* 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 都按先录入排列在前的规则处理。

 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
* */

class Student {

    String name;
    Integer grade;

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }


}

/*升序*/
class ASC implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.grade - o2.grade;
    }
}

/*降序*/
class DESC implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o2.grade - o1.grade;
    }
}

public class Test17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();/*要排序的人的个数*/
        int way = scanner.nextInt();/*排序的方法，1升序，0降序*/
        /*输入名字和成绩*/
        Set<Student> list = null;
        if (way == 1) {
            list = new TreeSet<>(new ASC());
        }
        if (way == 0) {

            list = new TreeSet<>(new DESC());
        }

        for (int i = 0; i < num; i++) {

            list.add(new Student(scanner.next(), scanner.nextInt()));

        }


        for(Student item:list){

            System.out.print(item.name+" ");
            System.out.println(item.grade);
        }


    }
}
