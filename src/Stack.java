public interface Stack {

    void push(int a) throws InvalidOperationException;//добавляет элемент в вершину стека
    int peek() throws InvalidOperationException;//возвращает элемент, находящийся в вершине стека
    int pop() throws InvalidOperationException;//удаляет элемент, находящийся в вершине стека (int для того чтоб работать дальше с ним)
    int getSize(); //возвращает количество элементов, находящихся в стеке
    boolean isEmpty(); //возвращает true, если в стеке нет ни одного элемента
    boolean isFull(); //возвращает true, если о стеке находится максимально возможное количество элементов
}
