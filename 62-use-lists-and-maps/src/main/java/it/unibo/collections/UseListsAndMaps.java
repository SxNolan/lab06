package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

        List<Integer> myList = new ArrayList<>();
        final int NUMBER = 2000;
        final int CENTOTHDS = 100000;

        for (int i = 1000; i < NUMBER; i++) {
            myList.add(i);
        }
        
        List<Integer> myLinkedList = new LinkedList<Integer>(myList);

        
        Integer temp;

        temp = myList.get(myList.size() - 1); //preso l'ultimo elemento e messo dentro temp.
        myList.set(myList.size() - 1, myList.size() / myList.size() - 1);
        myList.set(myList.size() / myList.size() - 1, temp);


        for (Integer elem : myList) {
            System.out.println(elem);
        }

        long time = System.nanoTime();
        for (int i = 1000; i < CENTOTHDS; i++) {

            myList.add(0, i);
            
            myLinkedList.add(0, i);
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + myList.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        System.out.println(// NOPMD
            "Converting "
                + myLinkedList.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        Map<String, Long> myMap = new HashMap<>();
        myMap.put("Africa", 1110635000l);
        myMap.put("Americas", 972005000l);
        myMap.put("Antarctica", 0l);
        myMap.put("Asia", 4298723000l);
        myMap.put("Europe", 742452000l);
        myMap.put("Oceania", 38304000l);


        long somma = 0;

        for (Long elem : myMap.values()) {
            somma = somma + elem;
        }

        System.out.println("Popolazione mondiale: " + somma);

    
        /* * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */                         
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}