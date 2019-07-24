import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name", "我是一个session值啊");

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("我是创建seesion的地方");
    }
}
