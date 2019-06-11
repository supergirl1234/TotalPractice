package comTwo;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/11 0011
 *
 * 读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 *
 * 测试输入包含若干测试用例，每个测试用例的格式为
 *
 *
 * 第1行：N
 * 第2行：N名学生的成绩，相邻两数字用一个空格间隔。
 * 第3行：给定分数
 *
 * 当读到N=0时输入结束。其中N不超过1000，成绩分数为（包含）0到100之间的一个整数。
 *
 *
 * 例如：
 * 输入：
 * 3
 * 80 60 90
 * 60
 * 2
 * 85 66
 * 0
 * 5
 * 60 75 90 55 75
 * 75
 * 0
 *
 * 输出
 * 1
 * 0
 * 2
 */
public class StatisticStudentGrade {


    public  static void GradeNumOfStudent(int[] array,int grade){


        int count=0;
        for(int i=0;i<array.length;i++){

            if(array[i]==grade){
                count++;
            }
        }
        System.out.println(count);

    }

    public static void main(String[] args) {

        System.out.println("输入同学个数、每位同学的成绩、和给定的分数：");
        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            int N=in.nextInt();
            if(N==0){
                return;

            }
            int[] grade=new int[N];
            for(int i=0;i<N;i++){
                grade[i]=in.nextInt();

            }

            int setGrade=in.nextInt();
            //GradeNumOfStudent(grade,setGrade);
            int count=0;
            for(int i=0;i<grade.length;i++){

                if(grade[i]==setGrade){
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
