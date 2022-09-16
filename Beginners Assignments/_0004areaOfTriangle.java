import java.util.*;
/*
 Area of triangle = 1/2|x1(y2-y3)-x2(y1-y3)+x3(y1-y2)|
                  = 1/2|x1(y2-y3)+x2(y3-y1)+x3(y1-y2)|
 */
public class _0004areaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();
        sc.close();
        System.out.println((Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))) / 2.0);
    }
}
