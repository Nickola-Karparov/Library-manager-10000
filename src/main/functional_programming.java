public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // Define a final data structure (immutable list)
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Use a side-effect-free function to square each element
        List<Integer> squaredNumbers = map(numbers, x -> x * x);
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Use a higher-order function to filter even numbers
        List<Integer> evenNumbers = filter(numbers, x -> x % 2 == 0);
        System.out.println("Even Numbers: " + evenNumbers);

        // Use a closure to capture and use an external variable
        int multiplier = 10;
        List<Integer> multipliedNumbers = map(numbers, x -> x * multiplier);
        System.out.println("Multiplied Numbers: " + multipliedNumbers);

        // Use a function as a parameter and return value
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> doubleIncrement = compose(increment, increment);

        int originalNumber = 5;
        int result = doubleIncrement.apply(originalNumber);
        System.out.println("Result of Double Increment: " + result);
    }

    // Side-effect-free map function using higher-order function
    static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    // Side-effect-free filter function using higher-order function
    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Higher-order function to compose two functions
    static <A, B, C> Function<A, C> compose(Function<A, B> f, Function<B, C> g) {
        return x -> g.apply(f.apply(x));
    }
}