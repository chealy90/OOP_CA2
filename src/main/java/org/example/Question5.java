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
        Map<String, Integer> identifierCountMap = new HashMap<>();
        Map<String, HashMap<Integer, String>> identifierLineMap = new HashMap<>();
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
        Set<String> identifiers = identifierLineMap.keySet();
        for (String identifier: identifiers){
            //print count
            System.out.println("\nIdentifier \"" + identifier + "\" appears " + identifierCountMap.get(identifier) + " times:");

            //print each line
            HashMap<Integer, String> lineMap = identifierLineMap.get(identifier);
            Set<Integer> lineNumbers = lineMap.keySet();
            for (int line: lineNumbers){
                System.out.println(line + ": " + lineMap.get(line));
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/Question2.java");
    }
}
