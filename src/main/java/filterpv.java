
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class filterpv implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse rep=(HttpServletResponse)response;
        
        HttpSession session=req.getSession(false); //this is used to get the current session and if it does not exsits it will create a new session if true but not for false
        if(session==null||session.getAttribute("usern")==null)
        {
            rep.sendRedirect("index.html");
        }
        else
        {
            rep.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            rep.setHeader("Pragma", "no-cache");
            rep.setHeader("Expires", "0");
            chain.doFilter(request, response);
        }
    }
}