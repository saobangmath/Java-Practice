public class test {
    protected String s;
    public test(){
        this.s = "";
    }
    public static class A{
        public void fun(double d){
            System.out.println("AD");
        }
        void fun(String s){
            System.out.println("AS");
        }
    }
    public static class B extends A{
        void fun(Object o){
            System.out.println("BO'");
        }
        void fun(String o){
            System.out.println("BO");
        }
    }
    public static class D extends A{
        void fun(Object o){
            System.out.println("DO");
        }
        void fun(String s){
            System.out.println("DO");
        }
    }

    public static void main(String[] args) {
        A b = new B(); // upcasting
        B c = (B)b; // downcase
        b.fun("dksdjd");
        c.fun(new Object());
    }
}
