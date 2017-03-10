package br.com.hossomi.bar.menu.option;

/**
 * Uma interface define apenas um "contrato" de como utilizar alguma funcionalidade, sem especificar
 * sua implementaçÃo.
 *
 * Quando for utilizar uma Option, tenha em mente apenas que ela possui uma label e que pode ser
 * selecionada, mas não se preocupe muito com o que uma Option faz por trás dos panos -- se isso for
 * realmente importante no contexto onde a interface está sendo usada, ela perdeu o seu sentido.
 */
public interface Option {

    String getLabel();

    /**
     * Seleciona essa opção, executando sua ação.
     */
    void select();
}
