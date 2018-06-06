package no.real.reason;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Why {

    public static void main(String[] args) {

        Set<Problem> problems = Stream
                .concat(Stream.generate(Problem::new).limit(99), Stream.of(new Java()))
                .filter(problem -> !Java.class.isInstance(problem))
                .collect(Collectors.toSet());

        System.out.println(String.format(
                "I got %d instances of %s, but %s ain't one...",
                problems.size(),
                Problem.class.getSimpleName(),
                Java.class.getSimpleName()
        ));

    }

    private static class Problem {

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }

    }

    private static class Java extends Problem {
    }

}
