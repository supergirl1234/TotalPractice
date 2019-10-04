package comm;

/*
 * 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
 * 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。
 * 接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。
 * 接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
 * 在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
 * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 * */
/*
 * 输入：第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
 * */

//思路：通过观察规律可得:下标小于等于n的，其新的下标为：2*原下标
//                        下标大于等于n的，其新的下标为：2*（原下标-n）+1

import java.util.Scanner;

public class Test19 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();//总牌数的一半
        int k = scanner.nextInt();//洗牌次数
        int[] nums = new int[2 * n];
        for (int m = 0; m < nums.length; m++) {//所有数据下标

            int temp = m;

            for (int p = 0; p < k; p++) {//洗牌次数

                if (m < n) {
                    temp = temp * 2;

                }

                if (m >= n) {


                    temp = (temp - n) * 2 + 1;


                }

            }
            nums[temp] = scanner.nextInt();
        }

        for (int j = 0; j < nums.length; j++) {

            System.out.print(nums[j] + " ");
        }


    }
}
