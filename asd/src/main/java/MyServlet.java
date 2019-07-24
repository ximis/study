

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class MyServlet implements Servlet, ServletConfig{
    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static ResourceBundle lStrings =
            ResourceBundle.getBundle(LSTRING_FILE);

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.print("The servlet Init success");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.print("Get servlet services");

        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("servlet init names: " + servletConfig.getInitParameterNames());

        String value = servletConfig.getInitParameter("test1");

        res.getWriter().write("HI, I response you from the servlet service! \n" + value);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getServletName() {
        return null;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public String getInitParameter(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return null;
    }
}
