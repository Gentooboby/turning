package com.apple.thinking.annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class UseCaseTracker {

    public static void trackUseCase(List<Integer> useCases, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("Found use case " + useCase.id() + "\n" + useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }

        useCases.forEach(i -> System.out.println("Missing use case " + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 51)
                .boxed().collect(Collectors.toList());
        trackUseCase(useCases, PasswordUtils.class);
    }
}
