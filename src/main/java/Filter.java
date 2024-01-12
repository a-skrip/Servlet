
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "HelloFilter", urlPatterns = "/first")
public class Filter implements jakarta.servlet.Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String header = request.getHeader("Cool-Header");

        if (header.equals("bad-header")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bye");
            requestDispatcher.forward(servletRequest, servletResponse);
        }

        response.setHeader("Cool-Header", "Approved");
        filterChain.doFilter(servletRequest, servletResponse);


    }

}


