package lr2;

public class task7 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);

        System.out.println("Длина: " + rect.getLength());
        System.out.println("Ширина: " + rect.getWidth());
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }

    public static class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        public double getArea() {
            return length * width;
        }

        public double getPerimeter() {
            return 2 * (length + width);
        }
    }
}
