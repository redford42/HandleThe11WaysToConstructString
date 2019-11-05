/**
 * Author: HANZ
 * Date: 2019/3/13
 * Time: 21:34
 */
public class tim {
    public static void main(String args[]) {
        int[] result = new int[100];
        for (int l = 1; l <= 100; l++) {
            int f = 0;
            for (int x = 1; x <= (int) Math.sqrt(l); x++) {
                for (int y = 1; y <= (int) Math.sqrt(l); y++) {
                    for (int z = 1; z <= (int) Math.sqrt(l); z++) {
                        if (x * x + y * y + z * z == l) {
                            f++;
                        }
                    }
                }
            }
            result[l-1] = f;
        }
        for (int r = 0; r < result.length; r++) {
            System.out.println("第" + (r+1) + "个:" + result[r]);
        }
    }
}
