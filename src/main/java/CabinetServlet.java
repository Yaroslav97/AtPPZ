import fridge.Smart;
import managerDB.DBFridgeParameterManager;
import util.Forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cabinetServlet")
public class CabinetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String power = req.getParameter("power");
        String defrost = req.getParameter("defrost");
        Integer tFridge = Integer.valueOf(req.getParameter("tFridge"));
        Integer tFreezer = Integer.valueOf(req.getParameter("tFreezer"));

        HttpSession session = req.getSession();

        session.removeAttribute("tFridge");
        session.removeAttribute("tFreezer");

        DBFridgeParameterManager dbFridgeParameterManager = new DBFridgeParameterManager();

        int fridgeID = (int) session.getAttribute("fridgeID");

        System.out.println("fridgeID:" + fridgeID);

        if (power == null) {
            power = "off";
        }

        if (defrost == null) {
            defrost = "off";
        }

        if (!power.equals("off") && tFridge != null && tFreezer != null) {

            Smart smart = new Smart(session.getAttribute("fridgeID").toString(), power, defrost, tFridge.toString(), tFreezer.toString());
            System.out.println(smart);

            session.setAttribute("print", smart);

            if (power.equals("on")){
                power = String.valueOf(1);
            }else {
                power = String.valueOf(0);
            }

            if (defrost.equals("on")){
                defrost = String.valueOf(1);
            }else {
                defrost = String.valueOf(0);
            }

            dbFridgeParameterManager.edit(fridgeID, tFridge, tFreezer, Integer.parseInt(defrost), Integer.parseInt(power));

            dbFridgeParameterManager.getAllParameters();

            session.setAttribute("tFridge", dbFridgeParameterManager.tFridge(fridgeID));
            session.setAttribute("tFreezer", dbFridgeParameterManager.tFreezer(fridgeID));

            Forward.forward("cabinet.jsp", req, resp);
        } else {
            session.setAttribute("print", "Fridge off");
            Forward.forward("cabinet.jsp", req, resp);
        }
    }
}