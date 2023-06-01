import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        if(args.length<2) {
            out.println("Мы так не договаривались\nНе хватает аргументов");
            exit(1);
        }

        int arrayLength,stepLenght;
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
        finally {
            arrayLength = 0; stepLenght = 0;
            out.println("Что-то пошло не так");
            exit(1);
        }

        int currentPos = 1;
        out.print(currentPos);
        currentPos += stepLenght-1;
        while (currentPos != 1) {
            if(currentPos == 0)
                out.print(arrayLength);
            else
                out.print(currentPos);

            currentPos += stepLenght-1;
            if (currentPos >= arrayLength)
                currentPos -= arrayLength;
        }
    }
}