import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    private HashMap<String, String> accounts = new HashMap<>();
    {
        accounts.put("admin", "admin");
        accounts.put("user", "user");
        accounts.put("sobolev", "vasia");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("wrong_data", "right");
        for (String s : accounts.keySet()) {
            if (req.getParameter("name").equals(s)&&req.getParameter("pass").equals(accounts.get(s))) {
                getServletContext().getRequestDispatcher("/chooser.jsp").forward(req, resp);
            }
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);





    }




}
