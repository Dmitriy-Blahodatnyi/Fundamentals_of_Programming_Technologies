import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringReverse {
    static String reverse(String s) {
        if (s == null) throw new NullPointerException("String can not be reversed!!!");
        var tempArray = IntStream.range(0, s.length())
                .mapToObj(i -> s.substring(i, i + 1)).collect(Collectors.toCollection(() -> new ArrayList<>(s.length())));
        return IntStream.iterate(tempArray.size() - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(tempArray::get).collect(Collectors.joining());
    }
}