package comm;


/*
* 、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）

2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）

3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（

* */

import java.util.Scanner;

//输入一个double数
//输出人民币格式
public class Test28 {


    static String[] map = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void test(String str) {

        String[] strings = str.split("\\.");
        /*整数部分*/
        int number = Integer.valueOf(strings[0]);

        StringBuffer res = new StringBuffer("人民币");
        int yi = (int) (number / 100000000);
        if (yi != 0) {
            res.append(resolveQian(yi)).append("亿");
            number = number - yi * 100000000;

        }
        int wan = (int) (number / 10000);
        if (wan != 0) {
            res.append(resolveQian(wan)).append("万");
            number = number - wan * 10000;
        }
        String beforePointString = resolveQian(number);
        if (beforePointString.length() > 1) {
            res.append(beforePointString).append("元");

        }
        /*处理小数点之后的数*/
        if (strings.length > 1) {
            String afterPointStr = strings[1];
            res.append(handleNumberAfterPoint(afterPointStr));
        }

        String resString=res.toString();
        if(resString.length()>4&&resString.charAt(3)=='零'&&resString.charAt(4)!='元'){

            resString=resString.substring(0,3)+resString.substring(4);

        }
        System.out.println(resString);
    }


    private static String resolveQian(double num) {

        StringBuffer sb = new StringBuffer();
        /*千位*/
        int qian = (int) (num / 1000);
        if (qian != 0) {
            sb.append(map[qian - 1]).append("仟");
            num = num - qian * 1000;

        }
        /*百位*/
        int bai = (int) (num / 100);
        if (bai != 0) {
            sb.append(map[bai - 1]).append("佰");
            num = num - bai * 100;

        }
        /*
         * 零只会添加到百位和十位
         * */

        if (qian == 0 && bai == 0) {
            sb.append("零");
        }
        /*十位*/
        int shi = (int) (num / 10);
        if (shi != 0) {
            if (shi != 1) {

                sb.append(map[shi - 1]);
            }
            sb.append("拾");
            num = num - shi * 10;

        }
        if(bai!=0&&shi==0){
            sb.append("零");

        }
        /*个位*/
        int ge=(int)(num%10);
        if(ge!=0){
            if(qian==0&&bai==0&&shi==0){

                sb.append("零");

            }
            sb.append(map[ge-1]);

        }

        return  sb.toString();
    }

    private static String handleNumberAfterPoint(String str) {
        String res = "";
        if (str.equals("00") || str.equals("0")) {

            res = "整";
        } else {

            if (str.charAt(0) != '0') {
                res += map[Integer.parseInt(str.charAt(0) + "") - 1] + "角";

            }
            if (str.length() > 1 && str.charAt(1) != '0') {

                res += map[Integer.parseInt(str.charAt(1) + "") - 1] + "分";
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        test(num);

    }
}
