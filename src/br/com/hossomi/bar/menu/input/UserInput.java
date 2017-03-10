package br.com.hossomi.bar.menu.input;

import java.util.Scanner;
import java.util.function.Supplier;

public abstract class UserInput<T> implements Supplier<T> {

    private String prompt;

    public UserInput(String prompt) {
        this.prompt = prompt;
    }

    protected abstract T parse(String input);

    @Override
    public T get() {
        System.out.print(prompt + ": ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return parse(input);
    }
}
