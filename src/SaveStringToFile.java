import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SaveStringToFile {
    public static void main(String[] args) {
        System.out.println("Generate random strings!");
        try {
            System.out.println("Please provide a number between 1-229 \n");
            Scanner scanner = new Scanner(System.in);
            short numberOfStrings= scanner.nextShort();
            if (numberOfStrings > 0 && numberOfStrings < 230) {
                generateRandomeStrings(numberOfStrings);
                System.out.println(numberOfStrings + " random strings are generated");
                System.out.println("The file is saved in output/randomStrings.txt");

            } else {
                System.out.println("Please provide a number between 1-229 !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param numberOfStrings
     * @throws IOException
     * This method generates random strings of length 100 and save the strings into a text file
     */
    private static void generateRandomeStrings(short numberOfStrings) throws IOException {
        StringBuilder builder = new StringBuilder();// holds the whole string
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < numberOfStrings; i++) {
            StringBuilder randomString = new StringBuilder(100);
            while (randomString.length() <= 100) {
                randomString.append(characters.charAt(random.nextInt(characters.length())));
            }
            randomString.append("\n");// append new line after generate each string
            builder.append(randomString);
        }
        File file = new File("output/randomStrings.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }
}
