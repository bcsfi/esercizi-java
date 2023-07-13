package net.bcsoft.bcvinainorefactor.exception;

public class FormatoSbagliatoEccezione extends RuntimeException {
    public FormatoSbagliatoEccezione(Class<?> tipoInserito, Class<?> tipoAtteso) {
        super(generaMessaggio(tipoInserito, tipoAtteso));
    }

    private static String generaMessaggio(Class<?> tipoInserito, Class<?> tipoAtteso) {
        return "Formato errato. Tipo inserito: " + tipoInserito.getSimpleName() + ". Tipo atteso: " + tipoAtteso.getSimpleName();
    }
}
