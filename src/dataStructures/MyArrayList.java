// Test Git
package dataStructures;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E>
{
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;

    public MyArrayList()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        currentSize = 0;
    }

    @Override
    public boolean add(E element) // ***TESTED***
    {
        growIfNecessary();
        currentSize++;

        elements[currentSize - 1] = element;
        return true;
    }

    @Override
    public void add(int index, E element) // ***TESTED***
    {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }

        if (index == size())
        {
            add(element);
        }
        else
        {
            growIfNecessary();
            for (int i = size(); i > index; i--)
            {
                elements[i] = elements[i - 1];
            }
            currentSize++;
            set(index, element);
        }
    }

    @Override
    public void clear() // ***TESTED***
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        currentSize = 0;
    }

    @Override
    public boolean contains(Object o) // ***TESTED***
    {
        for (int i = 0; i < currentSize; i++)
        {
            if (elements[i].equals(o))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) // ***TESTED***
    {
        checkBounds(index);
        return elements[index];
    }

    @Override
    public boolean isEmpty() // ***TESTED***
    {
        return currentSize == 0;
    }

    @Override
    public E remove(int index) // ***TESTED***
    {
        checkBounds(index);
        shrinkIfNecessary();

        E removed = elements[index];

        for (int i = index + 1; i < currentSize; i++)
        {
            elements[i - 1] = elements[i];
        }
        currentSize--;
        return removed;
    }

    @Override
    public boolean remove(Object o) // ***TESTED***
    {
        boolean removed = false;

        shrinkIfNecessary();

        for (int i = 0; i < currentSize; i++)
        {
            if (elements[i].equals(o))
            {
                remove(i);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public E set(int index, E element) // ***TESTED***
    {
        checkBounds(index);
        E returnElements = elements[index];
        elements[index] = element;

        return returnElements;
    }

    @Override
    public int size() // ***TESTED***
    {
        return currentSize;
    }

    private void growIfNecessary() // ***TESTED***
    {
        if (currentSize == elements.length)
        {
            E[] newElements = (E[]) new Object[2 * elements.length];

            for (int i = 0; i < elements.length; i++)
            {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    private void shrinkIfNecessary()
    {
        if (currentSize < elements.length * 0.25)
        {
            E[] newElements = (E[]) new Object[elements.length / 2];

            for (int i = 0; i < elements.length; i++)
            {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    private void checkBounds(int index)  // ***TESTED***
    {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() // ***TESTED***
    {
        Object[] array = new Object[currentSize];

        if (currentSize > 0)
        {
            for (int i = 0; i < currentSize; i++)
            {
                array[i] = elements[i];
            }
        }

        return Arrays.toString(array);
    }
}
