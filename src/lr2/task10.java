package lr2;

public class task10 {
    public static void main(String[] args) {

        Dog dog = new Dog("Б", 3, "Овчарка");
        Animal cat = new Cat("М", 2, "Рыба");
        Bird bird = new Bird("К", 1, true);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();

        System.out.println();

        dog.fetch();
        bird.fly();
    }

    public static class Animal {
        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void makeSound() {
            System.out.println("Животное издает звук");
        }

        public void info() {
            System.out.println("Имя: " + name + ", Возраст: " + age);
        }
    }

    public static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        @Override
        public void makeSound() {
            System.out.println("Собака лает: Гав-гав");
        }

        public void fetch() {
            System.out.println(name + " приносит мяч");
        }
    }

    public static class Cat extends Animal {
        private String foodType;

        public Cat(String name, int age, String foodType) {
            super(name, age);
            this.foodType = foodType;
        }

        @Override
        public void makeSound() {
            System.out.println("Кошка мяукает: Мяу");
        }
    }

    public static class Bird extends Animal {
        private boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }

        @Override
        public void makeSound() {
            System.out.println("Птица чирикает");
        }

        public void fly() {
            if (canFly) {
                System.out.println(name + " летает");
            } else {
                System.out.println(name + " не умеет летать");
            }
        }
    }

}
