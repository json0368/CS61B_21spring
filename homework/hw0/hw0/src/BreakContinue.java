public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        for(int i = 0; i < a.length; i ++) {
            if(a[i] < 0) continue;
            int sum = 0;
            for (int j = i; j < a.length && j <= i + n; j++) {
                sum += b[j];
            }
            a[i] = sum;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}