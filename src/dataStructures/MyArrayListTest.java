package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest
{
    public static void main(String[] args)
    {
        MyArrayList<Integer> listAdd = new MyArrayList<>();
        MyArrayList<Integer> intList = fillList();
        MyArrayList<Integer> listGrow = new MyArrayList<>();
        MyArrayList<Integer> emptyList = new MyArrayList<>();
        MyArrayList<Integer> fullList = fillList();
        MyArrayList<String> stringList = fillStringList();

        System.out.println("*** Testing listAdd.add(Object element) ***");
        System.out.println("List prior to listAdd.add: " + listAdd.toString());
        System.out.println(listAdd.add(1));
        System.out.println(listAdd.add(2));
        System.out.println(listAdd.add(3));
        System.out.println(listAdd.add(4));
        System.out.println("Expected result: [1, 2, 3, 4]");
        System.out.println("Received result: " + listAdd.toString());
        System.out.println();

        System.out.println("*** Testing list.add(int index, E element) ***");
        System.out.println(intList.toString());
        System.out.println("intList.add(10, 11):");
        intList.add(10, 11);
        System.out.println("Expected result: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
        System.out.println("Received result: " + intList.toString());
        System.out.println("intList.add(5, 100):");
        intList.add(5, 100);
        System.out.println("Expected result: [1, 2, 3, 4, 5, 100, 6, 7, 8, 9, 10, 11]");
        System.out.println("Received result: " + intList.toString());
        System.out.println("intList.add(0, 0):");
        intList.add(0, 0);
        System.out.println("Expected result: [0, 1, 2, 3, 4, 5, 100, 6, 7, 8, 9, 10, 11]");
        System.out.println("Received result: " + intList.toString());
        System.out.println("*** Index out of range test: intList.add(100, 250) ***");
        System.out.println("Expected result: IndexOutOfBoundsException");
        System.out.println("Received result: " + indexOutOfBoundsTest(100, 250, intList));
        System.out.println("*** Index out of range test: intList.add(-100, 250) ***");
        System.out.println("Expected result: IndexOutOfBoundsException");
        System.out.println("Received result: " + indexOutOfBoundsTest(-100, 250, intList));
        System.out.println();

        System.out.println("*** Testing listAdd.contains(1) ***");
        System.out.println("listAdd: " + listAdd.toString());
        System.out.println("Expected result: true");
        System.out.println("Received result: " + listAdd.contains(1));
        System.out.println("*** Testing listAdd.contains(8) ***");
        System.out.println("listAdd: " + listAdd.toString());
        System.out.println("Expected result: false");
        System.out.println("Received result: " + listAdd.contains(8));
        System.out.println();

        System.out.println("*** Testing listAdd.clear() ***");
        System.out.println("listAdd prior to clear: " + listAdd.toString());
        listAdd.clear();
        System.out.println("Expected result: []");
        System.out.println("Received result: " + listAdd.toString());
        System.out.println();

        listAdd.add(1);
        listAdd.add(2);
        listAdd.add(3);
        System.out.println("*** Testing listAdd.get(int index) -> list.get(1) ***");
        System.out.println(listAdd.toString());
        System.out.println("Expected result: 2");
        System.out.println("Received result: " + listAdd.get(1));
        System.out.println();

        System.out.println("*** Testing listGrow.growIfNecessary through listGrow.add ***");
        System.out.println("Default Capacity = 10");
        for (int i = 1; i < 12; i++) {
            listGrow.add(i);
            System.out.println(listGrow.toString() + " : Size = " + listGrow.size());
        }
        System.out.println();

        System.out.println("*** Testing listGrow.size() ***");
        System.out.println("listGrow: " + listGrow.toString());
        System.out.println("Expected result: 11");
        System.out.println("Received result: " + listGrow.size());
        System.out.println();

        System.out.println("*** Testing listAdd.isEmpty() on listAdd ***");
        System.out.println("listAdd: " + listAdd.toString());
        System.out.println("Expected result: false");
        System.out.println("Received result: " + listAdd.isEmpty());
        System.out.println("*** Testing emptyList.isEmpty() on emptyList ***");
        System.out.println("emptyList: " + emptyList.toString());
        System.out.println("Expected result: true");
        System.out.println("Received result: " + emptyList.isEmpty());
        System.out.println();

        System.out.println("*** Testing fullList.remove(int index) -> fullList.remove(4)");
        System.out.println("fullList prior to fullList.remove(4): \n" + fullList.toString());
        System.out.println("Expected result: 5");
        System.out.println("Received result: " + fullList.remove(4));
        System.out.println("fullList post fullList.remove(4): \n" + fullList.toString());
        System.out.println();

        System.out.println("*** Testing fullList.set(int index, Object o) -> fullList.set(2, 100) ***");
        System.out.println("fullList prior to fullList.set(2, 100): \n" + fullList.toString());
        System.out.println("Expected result: \n[1, 2, 100, 4, 6, 7, 8, 9, 10]");
        System.out.println("Element replaced: " + fullList.set(2, 100));
        System.out.println("Received result: \n" + fullList.toString());
        System.out.println();

        System.out.println();
        System.out.println("*** Testing fullList.remove(Object o) -> stringList.remove('R') ***");
        System.out.println("stringList prior to stringList.remove('R'): \n" + stringList.toString());
        System.out.println("Expected result: true");
        System.out.println("Received result: " + stringList.remove("R"));
        System.out.println("stringList post stringList.remove('R'): \n" + stringList.toString());
        System.out.println();

        System.out.println("*** Testing stringList.checkBounds through stringList.set(50, 'Hej') ***");
        System.out.println("Expected result: IndexOutOfBoundsException");
        System.out.print("Received result: ");
        try
        {
            stringList.set(50, "Hej");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println();
    }

    private static MyArrayList<Integer> fillList()
    {
        MyArrayList<Integer> returnList = new MyArrayList<>();

        for (int i = 1; i < 11; i++)
        {
            returnList.add(i);
        }
        return returnList;
    }

    private static MyArrayList<String> fillStringList()
    {
        MyArrayList<String> returnList = new MyArrayList<>();

        String[] myName = {"B", "E", "R", "A", "N", "T", "Z", "I", "N", "O"};

        for (int i = 0; i < 10; i++)
        {
            returnList.add(myName[i]);
        }
        return returnList;
    }

    private static String indexOutOfBoundsTest(int index, int value, MyArrayList<Integer> list)
    {
        String returnString = null;
        try
        {
            list.add(index, value);
        }
        catch (IndexOutOfBoundsException e)
        {
            returnString = e.toString();
        }
        return returnString;
    }
}
