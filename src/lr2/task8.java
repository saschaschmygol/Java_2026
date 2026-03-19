package lr2;

public class task8 {
    public static void main(String[] args) {

        Figure circle = new Circle(5);
        Figure rectangle = new Rectangle(4, 6);

        System.out.println("Круг:");
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Периметр: " + circle.getPerimeter());

        System.out.println("\nПрямоугольник:");
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());

    }

    public interface Figure {
        double getArea();
        double getPerimeter();
    }

    public static class Circle implements Figure {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static class Rectangle implements Figure {
        private final double length;
        private final double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getArea() {
            return length * width;
        }

        public double getPerimeter() {
            return 2 * (length + width);
        }
    }
}
