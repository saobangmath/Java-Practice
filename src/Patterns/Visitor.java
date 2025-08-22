package Patterns;

/*
 * https://refactoring.guru/design-patterns/visitor
 */
public class Visitor {
    static interface IVisitor{
        void visit(Base base);
        void visit(A a);
        void visit(B b);
    }

    static class Visitor1 implements IVisitor{
        @Override
        public void visit(Base base){
            System.out.println("Visitor1 visit Base");
        }

        @Override
        public void visit(A a){
            System.out.println("Visitor1 visit A");
        }

        @Override
        public void visit(B b){
            System.out.println("Visitor1 visit B");
        }
    }
    static abstract class Base {
        abstract void accept(IVisitor visitor);
    }

    static class A extends Base{
        @Override
        void accept(IVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class B extends Base{
        @Override
        void accept(IVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static void main(String[] args) {
        Base elements[] = {new A(), new B()};

        Visitor1 visitor1 = new Visitor1();
        for (Base element : elements) {
            element.accept(visitor1);
        }
    }
}
