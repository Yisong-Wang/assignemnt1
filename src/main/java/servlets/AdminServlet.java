package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AdminServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
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
        int total = 0, maxValue = -1;
        String maxUser = "", maxItem = "";
        while ((line = br.readLine()) != null) {
            String[] result = line.split(",");
            int acc = Integer.parseInt(result[3]);
            total +=  acc;

            if (acc >= maxValue){
                maxValue = acc;
                maxUser = result[0];
                maxItem = result[2];
            }
        }
        request.setAttribute("priceMessage",
                "Total value for all users: $" + String.valueOf(total)
                        + ". Most expensive item is " + maxItem + " at $"
                        + String.valueOf(maxValue) + " owned by " + maxUser + ".");
        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
}
