import java.lang.reflect.Method;

public class Annotazioni {

    public static void main(String[] args) throws Exception {

        Incasso incasso = new Incasso();

        Class incassoClass = incasso.getClass();

        Method[] incassoMethods = incassoClass.getMethods();


        for (Method method : incassoMethods) {

            if (method.isAnnotationPresent(Special.class)) {

                System.out.println("Il metodo " + method.getName() + " è annotato con @Special");

            }

        }

    }

}