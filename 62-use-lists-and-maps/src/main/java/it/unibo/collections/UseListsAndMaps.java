package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

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
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var arrayListCompetitor = new ArrayList<Integer>(); 

        for(int i = 1000; i<2000; i ++){
            arrayListCompetitor.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        var linkedListCompetitor = new ArrayList<Integer>(arrayListCompetitor); 

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        var swap = arrayListCompetitor.get(arrayListCompetitor.size()-1);
        arrayListCompetitor.set(arrayListCompetitor.size()-1,arrayListCompetitor.get(0));
        arrayListCompetitor.set(0, swap);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer element : arrayListCompetitor) {
            System.out.println(element);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for(int i = 0; i < 100_000; i ++){
            arrayListCompetitor.add(i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Arraylist: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );


        time = System.nanoTime();

        for(int i = 0; i < 100_000; i ++){
            linkedListCompetitor.add(i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Linkedlist: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();

        for(int i = 0; i < 100_000; i ++){
            arrayListCompetitor.get((int)arrayListCompetitor.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "ArrayList: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();

        for(int i = 0; i < 100_000; i ++){
            linkedListCompetitor.get((int)arrayListCompetitor.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Linkedlist: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

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

        final var worldPopulationMap = new HashMap<String,Long>(Map.of("Africa",1_110_635_000L,"Americas",972_005_000L,"Antarctica",0L,"Asia",4_298_723_000L,"Europe",742_452_000L,"Oceania",38_304_000L));
        /*
         * 8) Compute the population of the world
         */
        
        long worldPopulation = 0;
        final var populationCollection = worldPopulationMap.values();
        for (long value : populationCollection) {
            worldPopulation +=value;
        }

        System.out.println(worldPopulation);
    }
}
