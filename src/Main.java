import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();

        try {
            Method[] methods = container.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {

                    Saver saver = method.getAnnotation(Saver.class);
                    if ("Save".equals(method.getName())) {
                        method.invoke(container);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
