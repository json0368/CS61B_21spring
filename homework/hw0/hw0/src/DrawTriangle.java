import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        PrintTriangle.print_triangle(n);
    }
}
