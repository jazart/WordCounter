import java.io.*;
import java.util.*;
/**
 * Created by jazart on 11/16/2016.
 *
 *
 *
 */

public class FileWordCounter {


    public static void main(String[] args) throws Exception{

        try {


            Scanner input = new Scanner(System.in);
            HashMap<String, Integer> myMap = new HashMap<>();
            ArrayList<Word> words = new ArrayList<>();
            int totalNumOfWords = 0;


            System.out.println("Enter the full path of your file name. Note that you need to use two '\\' symbols when entering the file and pathname.");

            String fileName = input.nextLine();
            File file = new File(fileName);


            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                totalNumOfWords++;
                String word1 = scan.next().toLowerCase();
                word1 = word1.replaceAll("[^a-zA\\s]", "").replaceAll("\\s+", " ");
                if (!myMap.containsKey(word1)) {
                    myMap.put(word1, 1);
                } else {
                    myMap.put(word1, myMap.get(word1) + 1);
                }

            }


            //Reading each word with scanner, stripping punctuation etc, then adding to map. If it's in the map then add 1 to the value, if not then put it in the map with value of 1



            myMap.forEach((k,v) -> words.add(new Word(k,v)));

            //for each iterator to read from map, create word object from each key and value, then add to arraylist. Used lambda for more readable code.

            words.sort(Word::compareTo);

            //sorting my arraylist by the comparto method I defined in the word class

            String outputName = fileName + "_" + Calendar.getInstance().getTimeInMillis();
            File outFile = new File(outputName);


            FileWriter writer = new FileWriter(outFile);
            for (Word outPut : words) {
                writer.append("\n" + outPut.getWord() + " : " + outPut.getFrequency() + "\n");
                System.out.println(words.get(words.indexOf(outPut)).getWord() + " : " + words.get(words.indexOf(outPut)).getFrequency());
            }

            //creating a new empty file and iterating through my arraylist and adding each word and frequency value to the file.

            writer.close();
            System.out.println("\nThe word frequency for your input file of " + totalNumOfWords + " words has been generated. Your results are located here: " + outFile.getPath()
                    + "\nNote: Please open the file with a proper text " +
                    "editor(NOT NOTEPAD)to see the results in a proper format");
//
//
        }
        catch(FileNotFoundException e){
            System.err.println("Sorry I can't find your file. Please check and see if you entered the correct pathname." +
                    "\nComfirm your file location and rerun the program with the correct path.");
        }
    }


}