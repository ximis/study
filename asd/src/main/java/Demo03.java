import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //设置自动刷新
        resp.setHeader("Refresh", "3");

        PrintWriter printWriter = resp.getWriter();

        ServletContext context = this.getServletContext();
        printWriter.write(context.getAttribute("test").toString());
        printWriter.write("\n" + context.getInitParameter("globalName"));
        printWriter.write("\ntime:" + System.currentTimeMillis());


    }

}
