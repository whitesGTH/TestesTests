import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        float circleCenterX = 0;
        float circleCenterY = 0;
        float circleRadius = 0;

        float dotX = 0;
        float dotY = 0;

        //creating file objects from arguments

        File circleData = new File(args[0]);
        File dotData = new File(args[1]);

        //reading circle parameters
        try {
            Scanner scanner = new Scanner(new File(circleData.toURI()));
            while (scanner.hasNextFloat()) {
                circleCenterX = scanner.nextFloat();
                circleCenterY = scanner.nextFloat();
                circleRadius = scanner.nextFloat();
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        float distanceToCenter = 0;
        int relativePosition = 0;

        //reading dot coordinates while comparing them to circle
        //this will also process an unlimited number of dots given for input, not hardcapped at 100

        try {
            Scanner scanner = new Scanner(new File(dotData.toURI()));
            while (scanner.hasNextFloat()) {
                dotX = scanner.nextFloat();
                dotY = scanner.nextFloat();
                distanceToCenter = Main.calculateDistance(circleCenterX, circleCenterY, dotX, dotY);
                if (distanceToCenter == circleRadius) {
                    relativePosition = 0;
                } else if (distanceToCenter < circleRadius) {
                    relativePosition = 1;
                } else if (distanceToCenter > circleRadius) {
                    relativePosition = 2;
                }
                System.out.println(relativePosition);

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //could also avoid using expensive sqrt operation by comparing distance to center against radius squared, with minimal loss of precision in edge cases
    public static float calculateDistance(float circleCenterX, float circleCenterY, float dotX, float dotY) {
        return (float) Math.sqrt(Math.pow((circleCenterX - dotX), 2) + Math.pow((circleCenterY - dotY), 2));
    }
}