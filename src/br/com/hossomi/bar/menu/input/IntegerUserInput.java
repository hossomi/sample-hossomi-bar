package br.com.hossomi.bar.menu.input;

/**
 * Essa classe extende e especializa a classe {@link UserInput}, completando-a com o método
 * {@link #parse(String)} para converter a entrada do usuário em um inteiro.
 *
 * Note que não é possível usar tipos nativos (como int) como parâmetros de tipo em uma classe
 * genérica. Tipos nativos possuem uma classe correspondente. No caso de int, é {@link Integer}
 */
public class IntegerUserInput extends UserInput<Integer> {

    public IntegerUserInput(String prompt) {
        super(prompt);
    }

    @Override
    protected Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
