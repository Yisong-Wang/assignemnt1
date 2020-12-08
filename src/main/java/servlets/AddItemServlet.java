package servlets;

import models.HomeItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username == null){
            request.getRequestDispatcher("/login").forward(request, response);
            return;
        }
        String category = request.getParameter("category");
        String itemName = request.getParameter("itemName");
        String price = request.getParameter("price");
        request.setAttribute("username", username);

        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        HomeItem homeItem = new HomeItem();
        homeItem.Set(username, category, itemName, price);
        boolean flag = homeItem.Write(path);
        if(flag){
            request.setAttribute("addMessage", "</br><p>The item was successfully added to your inventory</p>");
            request.getRequestDispatcher("/inventory").forward(request, response);
        }
        else{
            request.setAttribute("addMessage", "Invalid. Please re-enter");
            request.getRequestDispatcher("/inventory").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
