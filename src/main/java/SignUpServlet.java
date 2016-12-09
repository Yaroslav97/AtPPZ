import managerDB.DBFridgeManager;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String fridge = req.getParameter("fridgeID");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        HttpSession session = req.getSession();

        if (fullName != null && fridge != null && login != null && email != null && pass != null &
                fullName.length() >= 4 && fridge.length() == 4 && login.length() >= 4 && email.length() >= 6 && pass.length() >= 4) {

            session.setAttribute("fullName", fullName);
            session.setAttribute("fridgeID", fridge);
            session.setAttribute("login", login);
            session.setAttribute("email", email);

            DBFridgeManager dbFridgeManager = new DBFridgeManager();
            dbFridgeManager.add(Integer.parseInt(fridge), fullName, login, email, Password.encodePassword(pass));

            resp.sendRedirect("cabinet.jsp");
        } else {
            resp.sendRedirect("signup.jsp");
        }
    }
}