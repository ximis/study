import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);


        String value = null;

        Cookie[] cookies = req.getCookies();

        for (int i = 0; cookies != null && i < cookies.length; i++) {

            String name = cookies[i].getName();


            //经过URLEncoding就要URLDecoding

            value = URLDecoder.decode(cookies[i].getValue(), "UTF-8");



        }


        //设置response的编码

        resp.setContentType("text/html;charset=UTF-8");


        //创建Cookie对象，指定名称和值
        if(value == null){
            value = "中国";
            Cookie cookie = new Cookie("username", URLEncoder.encode(value, "UTF-8"));
            //让一个cookie可以适合于同样后缀的域
//            cookie.setDomain(".zhongfucheng.com");
            //让cookie只能用于这个路径
            cookie.setPath("/cookieDemo");
            //向浏览器给一个Cookie

            resp.addCookie(cookie);


            resp.getWriter().write("我已经向浏览器发送了一个Cookie");
        }else{
            value =  "中国" +System.currentTimeMillis();
            Cookie cookie = new Cookie("username", URLEncoder.encode(value, "UTF-8"));


            //向浏览器给一个Cookie

            resp.addCookie(cookie);


            resp.getWriter().write("现在的cookie是: " + value);
        }


        //设置Cookie的时间, 为正，会存在cookie文件，为负，只在当前浏览器生效。 为0，删除cookie.
//        cookie.setMaxAge(1000);


    }
}
