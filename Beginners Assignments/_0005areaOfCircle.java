import java.util.*;
public class _0005areaOfCircle {
    public static double getArea(int radius){
        return (Math.PI)*((radius)*(radius));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        sc.close();
        System.out.println(getArea(radius));
    }
}
