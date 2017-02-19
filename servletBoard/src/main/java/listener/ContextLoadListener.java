package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ContextLoadListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String className = servletContextEvent.getServletContext().getInitParameter("boardManager");
        System.out.println("ContextLoadListener : " + className);

        Object obj = null;
        Constructor<?> constructor = null;

        try {
            constructor = Class.forName(className).getConstructor();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            obj = constructor.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        servletContextEvent.getServletContext().setAttribute("boardManager", obj);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
