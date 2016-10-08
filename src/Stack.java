

public interface Stack<T> {
    void push(T value) throws InvalidOperationException;//добавляет элемент в вершину стека
    T peek() throws InvalidOperationException;//возвращает элемент, находящийся в вершине стека
    T pop() throws InvalidOperationException;//удаляет элемент, находящийся в вершине стека (int для того чтоб работать дальше с ним)
    int getSize(); //возвращает количество элементов, находящихся в стеке
    boolean isEmpty(); //возвращает true, если в стеке нет ни одного элемента
    boolean isFull(); //возвращает true, если о стеке находится максимально возможное количество элементов
}
