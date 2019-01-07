package dataStructures;

public interface MyList<E>
{
    boolean add(E element);

    void add(int index, E element);

    void clear();

    boolean contains(Object o);

    E get(int index);

    boolean isEmpty();

    E remove(int index);

    boolean remove(Object o);

    E set(int index, E element);

    int size();
}

