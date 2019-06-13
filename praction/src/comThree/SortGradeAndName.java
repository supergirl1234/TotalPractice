package comThree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/13 0013
 *
 * 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 *  都按先录入排列在前的规则处理。
 *
 *
 *  输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 */
public class SortGradeAndName {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();//个数
            int option=scanner.nextInt();//排序选择
            List<Student> stuList=new LinkedList<>();//存放学生对象
            for(int i=0;i<num;i++){
                stuList.add(new Student(scanner.next(),scanner.nextInt()));

            }
            //如果是降序
            if(option==0){
                stuList.sort((o1,o2)->o2.grade-o1.grade);

            }else if(option==1){//升序

                stuList.sort((o1,o2)->o1.grade-o2.grade);
            }
            for(Student student:stuList){
                System.out.println(student.name+"  "+student.grade);

            }

        }


    }
}

class Student{

    public String name;
    public int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}



