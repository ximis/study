import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompressDemo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        resp.setContentType("text/html;charset=UTF-8");
        //告诉浏览器这是gzip压缩的数据
        resp.setHeader("Content-Encoding","gzip");

        String ss = "fsdfhsdfhuisdhfusdhfuids" +
                "fsdfdsfsdfsdfdsfdafdsfhsdjfhsdjkfhkjds" +
                "fdsfjdslkfjsldkfjsdlkfjsdkfsdjkff" +
                "fsjdfjdsklfjdsklfjkldsfjlksdjflksdjflkds" +
                "dsjfklsdjflsdjfkldsfkjsdkfjsldkfjsdlfk" +
                "fdsjlkfjdslkfjsdlkfjlkasjflk";

        //创建GZIPOutputStream对象，给予它ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);

        //GZIP对数据压缩，GZIP写入的数据是保存在byteArrayOutputStream上的
        gzipOutputStream.write(ss.getBytes());
        String data = "原始长度：" + ss.length() +"\n " + "压缩后长度：" + byteArrayOutputStream.size();
        gzipOutputStream.write(data.getBytes());

        //gzipOutputStream有缓冲，把缓冲清了，并顺便关闭流
        gzipOutputStream.close();

        //将压缩的数据取出来
        byte[] bytes = byteArrayOutputStream.toByteArray();

        //将压缩的数据写给浏览器
        resp.getOutputStream().write(bytes);

        resp.getOutputStream().flush();
    }
}
