import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDispatcherDemo2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);


        resp.setContentType("text/html;charset=UTF-8");
        //我在试用两个include时，第一个调用完了，第二个就不好使了。不知道为啥
        //原因，是因为我在其他的servlet中把response writer 给flush并关闭了。。
        req.getRequestDispatcher("/demo03").include(req,resp);

        resp.getWriter().write("\n这是我的dispatcher include测试啊\n");
        req.getRequestDispatcher("/MyHttpServlet").include(req,resp);

    }

}
