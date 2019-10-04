package comm;


import java.util.Scanner;

/*
* 实现两个数的相加求和，实现过程中不能用+运算符号
*
* 思路：位的异或运算跟求'和'的结果一致：
 *      异 或 1^1=0 1^0=1 0^0=0 求 和 1+1=0 1+0=1 0+0=0
*       位的与运算跟求'进位‘的结果一致：
*       位 与 1&1=1 1&0=0 0&0=0 进 位 1+1=1 1+0=0 0+0=0
*
*       所以将两个数进行异或运算，可以得到不进位的值A，
*       然后再将两个数进行与运算，得到进位B，
*       然后将B左移一位(因为进位是往左边进的)，再与A相加，就得到这两个数真正的和了
* */
public class Test14 {

    public static int test(int num1,int num2){

        if(num2==0){
            return  num1; //如果进位为0，那就说明计算结束了

        }
        int k=num1^num2;
        int m=num1&num2;
        return test(k,m<<1);

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        int result=test(num1,num2);
        System.out.println(result);
    }
}
