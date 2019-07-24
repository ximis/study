import sun.util.calendar.ZoneInfoFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class MyHttpServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        resp.setContentType("text/html;charset=UTF-8");

        System.out.print("Get servlet services");

        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("servlet init names: " + servletConfig.getInitParameterNames());

        ServletContext context = this.getServletContext();
        context.setAttribute("test", "MyHttpSerlet-Value");

        String value = servletConfig.getInitParameter("test1");
        PrintWriter writer = resp.getWriter();
        writer.write("HI, I response you from the servlet service! \n" + value);

        InputStream stream = context.getResourceAsStream("aaa.png");


        writer.write("\n" + context.getInitParameter("globalName") + "\n");
        writer.write("来试个中文嘛~\r\n\n");
        writer.write(ZoneInfoFile.getVersion());

        writer.write(stream.toString());
    }

}
