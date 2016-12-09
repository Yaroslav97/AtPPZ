import managerDB.DBFridgeManager;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("eFullName");
        String email = req.getParameter("eEmail");
        String password = req.getParameter("ePassword");

        HttpSession session = req.getSession();

        DBFridgeManager dbFridgeManager = new DBFridgeManager();
        dbFridgeManager.getAllList();

        if (fullName != null && email != null && password != null &&
                fullName.length() >= 4 && email.length() >= 4 & password.length() >= 4) {

            System.out.println(session.getAttribute("login"));
            System.out.println(session.getAttribute("fullName"));
            System.out.println(session.getAttribute("email"));

            dbFridgeManager.editProfile(session.getAttribute("login").toString(), fullName, email, password);

            System.out.println("Profile for "+ session.getAttribute("login") + " is updated");

            dbFridgeManager.getAllList();

            session.setAttribute("fullName", dbFridgeManager.fullName(session.getAttribute("login").toString()));

            resp.sendRedirect("cabinet.jsp");
        } else {
            resp.sendRedirect("edit.jsp");
        }
    }
}