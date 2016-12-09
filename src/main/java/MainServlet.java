import managerDB.DBFridgeParameterManager;
import util.Forward;
import util.Password;
import managerDB.DBFridgeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setIntHeader("Refresh", 400);

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if (login != null && password != null) {
            session.setAttribute("login", login);
            session.setAttribute("password", password);
        }

        session.setMaxInactiveInterval(500);

        DBFridgeParameterManager dbFridgeParameterManager = new DBFridgeParameterManager();
        DBFridgeManager dbFridgeManager = new DBFridgeManager();
        Forward forward = new Forward();

        dbFridgeManager.getAllList();

        if (dbFridgeManager.existLogin(login)) {
            if (Password.encodePassword(password).equals(dbFridgeManager.getLogin(login).getPassword())) {
                session.setAttribute("fullName", dbFridgeManager.fullName(login));
                session.setAttribute("email", dbFridgeManager.getEmail(login));

                System.out.println(dbFridgeManager.getList());
                System.out.println("User: " + dbFridgeManager.fullName(login));

                session.setAttribute("getList", dbFridgeManager.getAllList());
                session.setAttribute("fridgeID", dbFridgeManager.fridgeID(login));

                dbFridgeParameterManager.getAllParameters();
                if (!dbFridgeParameterManager.existFridgeID(dbFridgeManager.fridgeID(login))) {
                    dbFridgeParameterManager.add(dbFridgeManager.fridgeID(login), 10, 5, 0, 1);
                }

                dbFridgeParameterManager.getAllParameters();
                session.setAttribute("tFridge", dbFridgeParameterManager.tFridge(dbFridgeManager.fridgeID(login)));
                session.setAttribute("tFreezer", dbFridgeParameterManager.tFreezer(dbFridgeManager.fridgeID(login)));
                dbFridgeParameterManager.getAllParameters();

                forward.forward("cabinet.jsp", req, resp);
            } else {
                forward.forward("index.jsp", req, resp);
                System.out.println(System.lineSeparator() + "login or password is wrong");
            }
        } else {
            forward.forward("index.jsp", req, resp);
            System.out.println(System.lineSeparator() + "account is not exist");
        }
    }
}