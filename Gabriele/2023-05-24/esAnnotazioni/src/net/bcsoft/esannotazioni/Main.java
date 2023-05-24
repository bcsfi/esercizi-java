package net.bcsoft.esannotazioni;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        String nome = "Gabriele";
        Incasso incasso = new Incasso(nome);
        Class incassoClass = incasso.getClass();
        Method[] incassoMethods = incassoClass.getMethods();

        for (Method method : incassoMethods) {
            if (method.isAnnotationPresent(Special.class)) {
                System.out.println("Il metodo "+ method.getName() + " è annotato con @Special");
            }

        }
    }
}