
public class t {
    public static class A {

        public void sayHello() {
            System.out.println("Hello from A");
        }

    }

    public static class B {

        public void sayHello() {
            System.out.println("Hello from B");
        }

    }

    public static void main (String... args) {
        String[]strArr = {"A", "B", "C", "D"};
        for (final String s : strArr) {
            System.out.println(s);
        }
    }
    }

