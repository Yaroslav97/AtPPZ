import managerDB.DBFridgeManager;
import util.SendEmail;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/restore")
public class RestoreAccess extends HttpServlet {

    //private final String password = SendEmail.generatePassword();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("rLogin");
        String email = req.getParameter("rEmail");

        DBFridgeManager dbFridgeManager = new DBFridgeManager();
        dbFridgeManager.getAllList();

        if (login != null && email != null && dbFridgeManager.existLogin(login) && dbFridgeManager.getEmail(login).equals(email)) {

            String password = SendEmail.generatePassword();

            dbFridgeManager.editPassword(password, login, email);

            System.out.println("Sending email to" + login);

            System.out.println(password);
            dbFridgeManager.getAllList();

            try {
                SendEmail.send(dbFridgeManager.fullName(login), email, password);
            } catch (MessagingException e) {
                System.out.println(e);
            }

            System.out.println(password);

            System.out.println("email send");

            resp.sendRedirect("index.jsp");
        } else {
            System.out.println("can't send email");
            resp.sendRedirect("restoring.jsp");
        }
    }
}