package com.metacube.shanu;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        // Dictionary<String, String> myDict = new Dictionary<>(new Node<>("Shanu",
        // "Aaryan"));

        Dictionary<String, String> mydict = Dictionary
                .createDictionary(new File("ass4\\src\\main\\java\\com\\metacube\\shanu\\dictionaryprop.json"));

        System.out.println(mydict.get("Shanu"));
        System.out.println(mydict.get("Swayam"));
        System.out.println(mydict.get("Anurag"));

        for (Node<String, String> nod : mydict.sortedList()) {
            System.out.println(nod.key + " : " + nod.value);
        }
    }
}
