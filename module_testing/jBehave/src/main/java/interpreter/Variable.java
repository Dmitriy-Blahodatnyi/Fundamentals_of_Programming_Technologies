package interpreter;

public class Variable<T> {
    private T value;

    Variable(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    Class getType() {
        return this.value.getClass();
    }
}