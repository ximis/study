import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestPostData extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //        super.doPost(req, resp);

    // 设置request字符编码的格式

    req.setCharacterEncoding("UTF-8");

    // 通过html的name属性，获取到值

    String username = req.getParameter("username");

    String password = req.getParameter("password");

    String gender = req.getParameter("gender");

    // 复选框和下拉框有多个值，获取到多个值

    String[] hobbies = req.getParameterValues("hobbies");

    String[] address = req.getParameterValues("address");

    // 获取到文本域的值

    String description = req.getParameter("textarea");

    // 得到隐藏域的值

    String hiddenValue = req.getParameter("aaa");

    System.out.println("username: " + username);

    resp.setContentType("text/html;charset=UTF-8");
    resp.getWriter().write("username: " + username);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.doGet(req, resp);
    String username = req.getParameter("username");

    resp.setContentType("text/html;charset=UTF-8");
    resp.getWriter().write("username: " + username);
  }
}
