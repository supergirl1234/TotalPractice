package comm;

import java.util.*;

public class Test172 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();/*要排序的人的个数*/
        int way = scanner.nextInt();/*排序的方法，1升序，0降序*/
        /*输入名字和成绩*/
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            list.add(new Student(scanner.next(), scanner.nextInt()));

        }

        /*升序*/
        if(way==1){
           list.sort(new Comparator<Student>() {
               @Override
               public int compare(Student o1, Student o2) {
                   return o1.grade-o2.grade;
               }
           });

        }
        /*降序*/
        if(way==0){
            list.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o2.grade-o1.grade;
                }
            });

        }

        for(Student item:list){

            System.out.print(item.name+" ");
            System.out.println(item.grade);
        }

    }
}
