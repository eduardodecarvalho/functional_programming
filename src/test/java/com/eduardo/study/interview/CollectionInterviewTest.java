package com.eduardo.study.interview;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionInterviewTest {
    public static final String GEEKS = "Geeks";
    public static final String FOR = "For";
    public static final String IS = "Is";
    public static final String VERY_HELPFUL = "Very helpful";

    /*
    Any group of individual objects that are represented as a single unit is known as a Java Collection of Objects.
    In Java, a separate framework named the “Collection Framework” has been defined in JDK 1.2 which holds all the Java Collection Classes and Interface in it.
    In Java, the Collection interface (java.util.Collection) and Map interface (java.util.Map) are the two main “root” interfaces of Java collection classes.
     */

    @Test
    void beforeCollectionInterface() {

    /*
        Before the Collection Framework(or before JDK 1.2) was introduced, the standard methods for grouping Java objects (or collections) were Arrays or Vectors, or Hashtables.
        All of these collections had no common interface. Therefore, though the main aim of all the collections is the same,
        the implementation of all these collections was defined independently and had no correlation among them.
        And also, it is very difficult for the users to remember all the different methods, syntax, and constructors present in every collection class.

        Creating instances of the array,
        vector and hashtable
     */
        int[] arr = new int[]{1, 2, 3, 4};
        Vector<Integer> v = new Vector<>();
        Hashtable<Integer, String> h = new Hashtable<>();

        /*
        Adding the elements into the
        vector
         */
        v.addElement(1);
        v.addElement(2);
        /*
        Adding the element into the
        hashtable
         */
        h.put(1, GEEKS);
        h.put(2, FOR);

        /*
        Array instance creation requires [],
        while Vector and hastable require ()
        Vector element insertion requires addElement(),
        but hashtable element insertion requires put()

        Accessing the first element of the
        array, vector and hashtable
         */
        // Array elements are accessed using [],
        assertEquals(1, arr[0]);
        // vector elements using elementAt()
        assertEquals(2, v.elementAt(1));
        // and hashtable elements using get()
        assertEquals(GEEKS, h.get(1));
        /*
        As we can observe, none of these collections(Array, Vector, or Hashtable) implements a standard member access interface,
        it was very difficult for programmers to write algorithms that can work for all kinds of Collections.
        Another drawback is that most of the ‘Vector’ methods are final, meaning we cannot extend the ’Vector’ class to implement a similar kind of Collection.
        Therefore, Java developers decided to come up with a common interface to deal with the above-mentioned problems and introduced the Collection Framework in JDK 1.2 post which both,
        legacy Vectors and Hashtables were modified to conform to the Collection Framework.
         */
    }

/*
    Advantages of the Java Collection Framework
      Since the lack of a collection framework gave rise to the above set of disadvantages, the following are the advantages of the collection framework.
       1) Consistent API: The API has a basic set of interfaces like Collection, Set, List, or Map, all the classes (ArrayList, LinkedList, Vector, etc) that implement these interfaces have some common set of methods.
       2) Reduces programming effort: A programmer doesn’t have to worry about the design of the Collection but rather he can focus on its best use in his program.
          Therefore, the basic concept of Object-oriented programming (i.e.) abstraction has been successfully implemented.
       3) Increases program speed and quality: Increases performance by providing high-performance implementations of useful data structures and algorithms because in this case,
          the programmer need not think of the best implementation of a specific data structure. He can simply use the best implementation to drastically boost the performance of his algorithm/program.
 */


    @Test
    void listInterface() {
        /*
        This is a child interface of the collection interface. This interface is dedicated to the data of the list type in which we can store all the ordered collections of the objects.
        This also allows duplicate data to be present in it. This list interface is implemented by various classes like ArrayList, Vector, Stack, etc.
        Since all the subclasses implement the list, we can instantiate a list object with any of these classes.
        ArrayList provides us with dynamic arrays in Java. Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.
         */
        List<Integer> al = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            al.add(i);
        assertEquals(5, al.size());
        assertEquals(4, al.get(3));
        /*
        The LinkedList class is an implementation of the LinkedList data structure which is a linear data structure where the elements are not stored in contiguous locations
        and every element is a separate object with a data part and address part. The elements are linked using pointers and addresses. Each element is known as a node.
        */
        List<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        assertEquals(5, ll.size());
        assertEquals(4, ll.get(3));

        /*
        A vector provides us with dynamic arrays in Java. Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.
        This is identical to ArrayList in terms of implementation. However, the primary difference between a vector and an ArrayList is that a Vector is synchronized and an ArrayList is non-synchronized.
         */
        List<Integer> v = new Vector<>();
        for (int i = 1; i <= 5; i++)
            v.add(i);
        assertEquals(5, v.size());
        assertEquals(4, v.get(3));
    }

    @Test
    void setInterface() {
        /*
      A set is an unordered collection of objects in which duplicate values cannot be stored.
      This collection is used when we wish to avoid the duplication of the objects and wish to store only the unique objects.
      This set interface is implemented by various classes like HashSet, TreeSet, LinkedHashSet, etc. Since all the subclasses implement the set, we can instantiate a set object with any of these classes.


        The HashSet class is an inherent implementation of the hash table data structure.
        The objects that we insert into the HashSet do not guarantee to be inserted in the same order.
        The objects are inserted based on their hashcode. This class also allows the insertion of NULL elements. Let’s understand HashSet with an example:
         */
        Set<String> hs = new HashSet<>();

        hs.add(GEEKS);
        hs.add(FOR);
        hs.add(GEEKS);
        hs.add(IS);
        hs.add(VERY_HELPFUL);

        List<String> itr = new ArrayList<>(hs);
        assertEquals(VERY_HELPFUL, itr.get(0));
        assertEquals(GEEKS, itr.get(1));
        assertEquals(FOR, itr.get(2));
        assertEquals(IS, itr.get(3));
        itr.clear();

//      A LinkedHashSet is very similar to a HashSet. The difference is that this uses a doubly linked list to store the data and retains the ordering of the elements.
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add(GEEKS);
        lhs.add(FOR);
        lhs.add(GEEKS);
        lhs.add(IS);
        lhs.add(VERY_HELPFUL);
        itr.addAll(lhs);

        assertEquals(GEEKS, itr.get(0));
        assertEquals(FOR, itr.get(1));
        assertEquals(IS, itr.get(2));
        assertEquals(VERY_HELPFUL, itr.get(3));
        itr.clear();

        /*
        The TreeSet class uses a Tree for storage.
        The ordering of the elements is maintained by a set using their natural ordering whether or not an explicit comparator is provided.
        This must be consistent with equals if it is to correctly implement the Set interface.
        It can also be ordered by a Comparator provided at a set creation time, depending on which constructor is used.
        */

        Set<String> ts = new TreeSet<>(lhs);
        itr.addAll(ts);
        assertEquals(FOR, itr.get(0));
        assertEquals(GEEKS, itr.get(1));
        assertEquals(IS, itr.get(2));
        assertEquals(VERY_HELPFUL, itr.get(3));
        itr.clear();
    }

    @Test
    void mapInterface() {
        /*
        A map is a data structure that supports the key-value pair for mapping the data.
        This interface doesn’t support duplicate keys because the same key cannot have multiple mappings, however, it allows duplicate values in different keys.
        A map is useful if there is data and we wish to perform operations on the basis of the key. This map interface is implemented by various classes like HashMap, TreeMap, etc.
        Since all the subclasses implement the map, we can instantiate a map object with any of these classes.

        HashMap provides the basic implementation of the Map interface of Java.
        It stores the data in (Key, Value) pairs. To access a value in a HashMap, we must know its key.
        HashMap uses a technique called Hashing. Hashing is a technique of converting a large String to a small String that represents the same String so that the indexing and search operations are faster.
        HashSet also uses HashMap internally.
         */
        Map<Integer, String> hm = new HashMap<>();
        hm.put(3, GEEKS);
        hm.put(2, FOR);
        hm.put(1, GEEKS);

        containsInAnyOrder(1, 2, 3);

        Map<Integer, String> tm = new TreeMap<>(hm);

        assertAll(() -> assertEquals(GEEKS, tm.get(1)),
                () -> assertEquals(FOR, tm.get(2)),
                () -> assertEquals(GEEKS, tm.get(3)));
    }
}
