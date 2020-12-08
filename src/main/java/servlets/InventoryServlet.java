package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(name = "InventoryServlet")
public class InventoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username == null){
            request.getRequestDispatcher("/login").forward(request, response);
            return;
        }
        String path = request.getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        String line;
        BufferedReader br = new BufferedReader(new FileReader(path));
        int total = 0;
        while ((line = br.readLine()) != null) {
            String[] result = line.split(",");
            if(result[0].equals(username)){
                total +=  Integer.parseInt(result[3]);
            }
        }
        request.setAttribute("priceMessage", "Total value in inventory: $" + String.valueOf(total));
        request.getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }
}
