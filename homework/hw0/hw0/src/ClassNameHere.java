public class ClassNameHere {
    /** Uses a while loop to sum a. */
    public static int whileSum(int[] a) {
        int i = 0; //initialization
        int sum = 0;
        while (i < a.length) { //termination
            sum = sum + a[i];
            i = i + 1; //increment
        }
        return sum;
    }
}