import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        if(args.length<2)
            exit(1);

        int arrayLenth,stepLenght;
        arrayLenth = Integer.parseInt(args[0]);
        stepLenght = Integer.parseInt(args[1]);

        int currentPos = 1;
        out.print(currentPos);
        currentPos += stepLenght-1;
        while (currentPos != 1) {
            if(currentPos == 0)
                out.print(arrayLenth);
            else
                out.print(currentPos);

            currentPos += stepLenght-1;
            if (currentPos >= arrayLenth)
                currentPos -= arrayLenth;
        }
    }
}