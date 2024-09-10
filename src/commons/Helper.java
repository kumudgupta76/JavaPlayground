package commons;

public class Helper {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public static void main(String[] args) {
        Helper helper = new Helper();

        System.out.println(helper.gcd(6, 18));

        System.out.println(helper.gcd(21, 18));

        System.out.println(helper.gcd(9, 18));
    }
}
