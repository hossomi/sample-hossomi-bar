package br.com.hossomi.bar.menu.input;

import java.util.Scanner;

/**
 * Uma classe abstrata significa que ela não é completa. Isto é, algum de seus métodos é abstrato e
 * deve ser implementado por uma subclasse. Por serem incompletas, classes abstratas não podem ser
 * instanciadas.
 *
 * Uma classe genérica (que possui um parâmetro de tipo entre <>) significa que ela pode ser
 * especializada para um tipo.
 *
 * Nesse caso, UserInput não especifica que tipo de entrada essa classe obtém do usuário. Ela é
 * genérica: obtém um tipo T de entrada. Ela é abstrata porque ela não implementa a forma que a
 * entrada do usuário, que é sempre uma String, é convertida para o tipo T.
 */
public abstract class UserInput<T> {

    private String prompt;

    public UserInput(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Converte a entrada do usuário, em forma de String, para o tipo T.
     */
    protected abstract T parse(String input);

    /**
     * Lê uma entrada do usuário e converte para o tipo T.
     */
    public T get() {
        System.out.print(prompt + ": ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return parse(input);
    }
}
