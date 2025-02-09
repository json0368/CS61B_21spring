public class PrintTriangle {
    public static void print_triangle(int n) {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print('*');
            }
            System.out.print('\n');
        }
    }
}