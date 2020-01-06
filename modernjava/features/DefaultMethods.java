public class DefaultMethods {

    public interface Rotatable {
        void setRotationAngle(int angleInDegrees);
        int getRotationAngle();
        default void rotateBy(int angleInDegrees){                            1
            setRotationAngle((getRotationAngle () + angleInDegrees) % 360);
        }
    }

    public interface Moveable {
        int getX();
        int getY();
        void setX(int x);
        void setY(int y);
        default void moveHorizontally(int distance){
            setX(getX() + distance);
        }
        default void moveVertically(int distance){
            setY(getY() + distance);
        }
    }

    public interface Resizable {
        int getWidth();
        int getHeight();
        void setWidth(int width);
        void setHeight(int height);
        void setAbsoluteSize(int width, int height);
        default void setRelativeSize(int wFactor, int hFactor){
            setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
        }
    }

    public class Monster implements Rotatable, Moveable, Resizable {
        @Override
        public void setRotationAngle(int angleInDegrees) {

        }

        @Override
        public int getRotationAngle() {
            return 0;
        }

        @Override
        public int getX() {
            return 0;
        }

        @Override
        public int getY() {
            return 0;
        }

        @Override
        public void setX(int x) {

        }

        @Override
        public void setY(int y) {

        }

        @Override
        public int getWidth() {
            return 0;
        }

        @Override
        public int getHeight() {
            return 0;
        }

        @Override
        public void setWidth(int width) {

        }

        @Override
        public void setHeight(int height) {

        }

        @Override
        public void setAbsoluteSize(int width, int height) {

        }
    }

    public interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }
    public interface B {
        default void hello() {
            System.out.println("Hello from B");
        }
    }
    public class C implements B, A {
        void hello(){
            B.super.hello();
        }
    }
//    multiple inheritance resolution rules

//    First, an explicit method declaration in the class or a superclass takes priority over any default method declaration.
//    Otherwise, the method with the same signature in the most specific default-providing interface is selected.
//    Finally, if there’s still a conflict, you have to explicitly override the default methods and choose which one your class should use.
}
