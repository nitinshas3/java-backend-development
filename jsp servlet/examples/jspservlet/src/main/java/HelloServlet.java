import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet('/firstservlet')
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().println("Hello from Servlet!");
    }
}