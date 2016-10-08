public interface Queue<T> {

    void enqueue(T a) throws InvalidOperationException;  //добавляет элемент в конец очереди
    T peek() throws InvalidOperationException; //позволяет получить значение элемента, находящегося в начале очереди
    T dequeue()  throws InvalidOperationException; //удаляет элемент, находящийся в начале очереди (int для того чтоб дальше работать с ним)
    int getSize(); // возвращает количество элементов, находящихся в очереди
    boolean isEmpty(); //возвращает true, если в очереди нет ни одного элемента
    boolean isFull(); //возвращает true, если в очереди находится максимально возможное количество элементов

}
