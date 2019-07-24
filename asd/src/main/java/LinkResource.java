import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LinkResource extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //        super.doGet(req, resp);

    // 获取网页从哪里来
    String referer = req.getHeader("Referer");

    // 如果不是从我的首页来，或者从地址栏直接访问，跳转到我的首页
    if (referer == null || !referer.contains("/asd/linkDemo.html")) {
      // 重定向到首页
      resp.sendRedirect("/asd/linkDemo.html");
    }

    //get parameter from the URL
    String username = req.getParameter("username");

    resp.setContentType("text/html;charset=UTF-8");
    resp.getWriter().write("XXX的资源包");
    resp.getWriter().write("username From parameter: " + username);
  }
}
