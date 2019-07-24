import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class DownloadDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        resp.setContentType("text/html;charset=UTF-8");

        //获取资源路径
        String path = this.getServletContext().getRealPath("/download/小红花.png");

        //读取资源
        FileInputStream inputStream = new FileInputStream(path);

        //获取文件名， 路径在电脑是以\\保存的
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        //解决文件名中文乱码
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        //把资源写给浏览器
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();

        while((len = inputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, len);
        }

        outputStream.close();
        inputStream.close();

    }

}
