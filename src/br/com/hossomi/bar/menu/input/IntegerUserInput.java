package br.com.hossomi.bar.menu.input;

public class IntegerUserInput extends UserInput<Integer> {

    public IntegerUserInput(String prompt) {
        super(prompt);
    }

    @Override
    protected Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
