import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RefreshDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        resp.setContentType("text/html;charset=UTF-8");
        //设置自动刷新
        resp.setHeader("Refresh", "3;url=/asd/MyHttpServlet");

        PrintWriter printWriter = resp.getWriter();

        printWriter.write("\n三秒后跳转页面……");

        printWriter.flush();
    }

}
