import java.util.Scanner;

public class Area {
    private enum UserInput { CIRCLE, SEMICIRCLE, SQUARE, TRIANGLE, RECTANGLE, PARALLELOGRAM, TRAPEZOID, QUIT, INVALID }
    private static UserInput[] userInputs = UserInput.values();

    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showUserOptions();

            UserInput userInput = getUserInputFromInt(inputScanner.nextInt());
            actOnUserInput(userInput);
        }
    }

    private static void showUserOptions() {
        System.out.println("What would you like to do? Type the number of your desired function.");

        System.out.println(UserInput.CIRCLE.ordinal() + ". Area of a Circle");
        System.out.println(UserInput.SEMICIRCLE.ordinal() + ". Area of a Semicircle");
        System.out.println(UserInput.SQUARE.ordinal() + ". Area of a Square");
        System.out.println(UserInput.TRIANGLE.ordinal() + ". Area of a Triangle");
        System.out.println(UserInput.RECTANGLE.ordinal() + ". Area of a Rectangle");
        System.out.println(UserInput.PARALLELOGRAM.ordinal() + ". Area of a Parallelogram");
        System.out.println(UserInput.TRAPEZOID.ordinal() + ". Area of a Trapezoid");
        System.out.println(UserInput.QUIT.ordinal() + ". Quit");
    }

    private static UserInput getUserInputFromInt(int userInput) {
        if (userInput >= 0 && userInput < userInputs.length) {
            return userInputs[userInput];
        }

        return UserInput.INVALID;
    }

    private static void actOnUserInput(UserInput userInput) {
        switch (userInput) {
            case CIRCLE:
            case SEMICIRCLE:
            case SQUARE:
            case TRIANGLE:
            case RECTANGLE:
            case PARALLELOGRAM:
            case TRAPEZOID:

                Shape shape = createShapeFromUserInput(userInput);

                if (shape != null) {
                    System.out.println("The area is equal to: " + String.valueOf(shape.getArea()));
                }
                break;
            case QUIT:
                quit();
                break;
            case INVALID:
                System.out.println("I'm sorry, you didn't select a function.");
                System.out.println("Please choose again");
                break;
        }
    }

    private static Shape createShapeFromUserInput(UserInput userInput) {
        switch (userInput) {
            case CIRCLE:
                double radius = askUserForValue("radius", userInput);

                return new Circle(radius);

            case SEMICIRCLE:
                double semiradius = askUserForValue("radius", userInput);

                return new Semicircle(semiradius);

            case SQUARE:
                double sideLength = askUserForValue("side length", userInput);

                return new Square(sideLength);

            case TRIANGLE:
                double height = askUserForValue("height", userInput);
                double base = askUserForValue("base", userInput);

                return new Triangle(height, base);

            case RECTANGLE:
                double length = askUserForValue("length", userInput);
                double width = askUserForValue("width", userInput);

                return new Rectangle(length, width);

            case PARALLELOGRAM:
                double parallelogram_length = askUserForValue("length", userInput);
                double parallelogram_width = askUserForValue("width", userInput);

                return new Parallelogram(parallelogram_length, parallelogram_width);

            case TRAPEZOID:
                double trapheight = askUserForValue("height", userInput);
                double base1 = askUserForValue("first base", userInput);
                double base2 = askUserForValue("second base", userInput);

                return new Trapezoid(trapheight, base1, base2);
        }

        return null;
    }

    private static double askUserForValue(String valueName, UserInput userInput) {
        System.out.println(String.format("Please enter the %s of your %s.", valueName, userInput.toString().toLowerCase()));

        return inputScanner.nextDouble();
    }

    private static void quit() {
        System.out.println("Quiting....");

        System.exit(0);

    }

    private interface Shape {
        double getArea();
    }

    private static class Circle implements Shape {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * this.radius * this.radius;
        }
    }

    private static class Semicircle implements Shape {
        double semiradius;

        public Semicircle(double semiradius){
            this.semiradius = semiradius;
        }

        @Override
        public double getArea() {
            return Math.PI * this.semiradius * this.semiradius;
        }
    }

    private static class Parallelogram implements Shape {
        double parallelogram_length;
        double parallelogram_width;

        public Parallelogram(double parallelogram_length, double parallelogram_width) {
            this.parallelogram_length = parallelogram_length;
            this. parallelogram_width = parallelogram_width;
        }

        @Override
        public double getArea() {
            return this.parallelogram_length * this.parallelogram_width;
        }
    }

    private static class Trapezoid implements Shape {
        double trapheight;
        double base1;
        double base2;

        public Trapezoid(double trapheight, double base1, double base2) {
            this.trapheight = trapheight;
            this.base1 = base1;
            this.base2 = base2;
        }

        @Override
        public double getArea() {
            return 0.5 * (this.base1 + this.base2) * trapheight;
        }
    }

    private static class Triangle implements Shape {
        double height;
        double base;

        public Triangle(double height, double base) {
            this.height = height;
            this.base = base;
        }

        @Override
        public double getArea() {
            return 0.5 * this.height * this.base;
        }
    }

    private static class Rectangle implements Shape {
        double length;
        double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return this.length * this.width;
        }
    }
    private static class Square extends Rectangle {
        public Square(double sideLength) {
            super(sideLength, sideLength);
        }
    }
}
