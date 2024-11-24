package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question3  {   //Nested HTML (Stack)

    /*
filename: name of the file to test.
*/
    public static boolean validate(String filename) throws FileNotFoundException
    {
        Scanner inputFile = new Scanner(new File(filename));
        Deque<String> tagStack = new ArrayDeque<>();
        while (inputFile.hasNext()){
            String tag = inputFile.next();
            if (tag.equals("<br>")){
                continue;
            }

            //opening tag found
            else if (!tag.contains("/")){
                tagStack.push(tag);
            }

            //closing tag found
            else {
                if (tagStack.isEmpty()){
                    return false; //nb: must check if stack empty before peeking in case of NullPointerException
                }

                if (tag.substring(2).equals(tagStack.peek().substring(1))){
                    tagStack.pop();
                } else {
                    return false;
                }
            }
        }

        //empty stack means all tags have been closed
        inputFile.close();
        return tagStack.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt", "tags_valid2.txt", "tags_invalid2.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }



}


