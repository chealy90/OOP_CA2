package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name: Christopher Healy
 *  Class Group: D00270638
 */
public class Question5 {    //Java Identifier Count (Map)

    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("src/main/java/org/example/Question1.java"));
        //using a tree map means the identifiers will automatically be stored in alphabetical order via String's natural ordering
        Map<String, Integer> identifierCountMap = new TreeMap<>();
        Map<String, HashMap<Integer, String>> identifierLineMap = new TreeMap<>();
        int lineNumber = 1;
        //parse each line
        while (fileInput.hasNextLine()){
            String nextLine = fileInput.nextLine();
            String[] nextWords = nextLine.split("[^A-Za-z0-9_/,]");
            if (nextWords.length == 1){
                continue;
            }

            //parse each word
            for (String word: nextWords){
                //ignore whitespace words
                if (word.length()==0){
                    continue;
                }
                //update identifier count array
                if (identifierCountMap.get(word)==null){
                    identifierCountMap.put(word, 1);
                } else {
                    identifierCountMap.put(word, identifierCountMap.get(word)+1);
                }

                //update line counter array
                if (identifierLineMap.get(word)==null){
                    identifierLineMap.put(word, new HashMap<>());
                    HashMap<Integer, String> lineMap = identifierLineMap.get(word);
                    lineMap.put(lineNumber, nextLine);
                    identifierLineMap.put(word, lineMap);
                } else {
                    HashMap<Integer, String> lineMap = identifierLineMap.get(word);
                    lineMap.put(lineNumber, nextLine);
                    identifierLineMap.put(word, lineMap);
                }
            }
            lineNumber++;
        }

        //print out maps
        Set<String> identifierKeys = identifierLineMap.keySet();
        for (String identifier: identifierKeys){
            //print count
            System.out.println("\nIdentifier \"" + identifier + "\" appears " + identifierCountMap.get(identifier) + " times:");

            //print each line
            Set<Map.Entry<Integer, String>> lineMap = identifierLineMap.get(identifier).entrySet();
            for (Map.Entry<Integer, String> entry: lineMap){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/Question2.java");
    }
}
