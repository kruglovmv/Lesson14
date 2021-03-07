import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainTest {


    @ParameterizedTest
    @MethodSource("dataForArray")
    void testArrayAfterLastFour(Integer [] a, Integer [] result) {
       Assertions.assertArrayEquals(result, Main.arrayAfterLastFour(a));
    }
    private static Stream<Arguments> dataForArray() {
        List<Arguments> out = new ArrayList<>();
        Integer [] array = {1,2,3,4,5,6,4,2,5,8,4,0};
        Integer [] result = {0};
        out.add(Arguments.arguments(array, result));
        array = new Integer[]{1,2,3,4,5,6,4,2,5,8,2,0};
        result = new Integer[]{2,5,8,2,0};
        out.add(Arguments.arguments(array, result));
        array = new Integer[]{1,2,3,4,5,6,0,2,5,8,2,0};
        result = new Integer[]{5,6,0,2,5,8,2,0};
        out.add(Arguments.arguments(array, result));
        array = new Integer[]{4,2,3,0,5,6,0,2,5,8,2,0};
        result = new Integer[]{5,6,0,2,5,8,2,0};
        out.add(Arguments.arguments(array, result));
        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("dataForCheckArray")
    void testCheckArray(Integer [] a) {

        Assertions.assertTrue(Main.checkArray(a));
    }
    private static Stream<Arguments> dataForCheckArray() {
       List<Arguments> out = new ArrayList<>();
        Integer [] array = {1,1,1,4,4,1,4,4};
        out.add(Arguments.arguments((Object)array));
       array = new Integer[]{1,1,1,1,1,1};
       out.add(Arguments.arguments((Object)array));
       array = new Integer[]{4,4,4,4};
       out.add(Arguments.arguments((Object)array));
        array = new Integer[]{1,4,4,1,1,4,3};
        out.add(Arguments.arguments((Object)array));
        return out.stream();
    }
}