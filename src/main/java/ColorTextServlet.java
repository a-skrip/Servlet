
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = " ", urlPatterns = "/color")
public class ColorTextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Получаем параметр “text” и “color” из запроса
        String text = request.getParameter("text");
        String color = request.getParameter("color");

        // Печатаем HTML в качестве ответа для браузера
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =  response.getWriter();
        try {
            out.println("<html>");
//            out.println("<head> <title> ColorTextServlet </title> </head>");
            out.println("<body>");
            out.println("<h1 style=\"color: blue\">HELLO_BEAR</h1>");
            out.println("<h2 style=\"color: red\">******</h2>");
            out.println("<a href=\"ByeServlet\">ссылка</a><br>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}