import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        if(args.length<2) {
            out.println("Мы так не договаривались\nНе хватает аргументов");
            exit(1);
        }

        String delimiterString = "";
        int arrayLength=0,stepLenght=0;
        try {
            arrayLength = Integer.parseInt(args[0]);
            stepLenght = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e)
        {
            out.println("Мы так не договаривались\nЭто не числа");
            exit(1);
        }
        catch (Exception e)
        {
            throw e;
        }

        //про это нет в задаче
        //if (arrayLength>9)
        //    delimiterString = " ";

        int currentPos = 1;
        out.print(currentPos + delimiterString);
        currentPos += stepLenght-1;
        currentPos = currentPos % arrayLength;

        while (currentPos != 1) {
            if(currentPos == 0)
                out.print(arrayLength + delimiterString);
            else
                out.print(currentPos + delimiterString);

            currentPos += stepLenght-1;
            currentPos = currentPos % arrayLength;
        }
    }
}