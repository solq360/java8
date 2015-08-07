package test.java8.example.newcharacter.model;
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}