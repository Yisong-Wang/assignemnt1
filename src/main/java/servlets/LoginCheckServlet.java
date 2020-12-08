package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username == null){
            request.getRequestDispatcher("/login").forward(request, response);
            return;
        }
        String password = request.getParameter("password");

        // load users and passwords
        String path = getServletContext().getRealPath("/WEB-INF/users.txt");
        HashMap<String, String> dict = new HashMap<String, String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        boolean flag = false;
        while ((line = br.readLine()) != null) {
            String[] result = line.split(",");
            if(result[0].equals(username) && result[1].equals(password)){
                flag = true;
                break;
            }
        }
        br.close();

        if(flag){
            request.setAttribute("username", username);
            if ("admin".equals(username)) {
                request.getRequestDispatcher("/admin").forward(request, response);
            } else {
                request.getRequestDispatcher("/inventory").forward(request, response);
            }
        }
        else{
            request.setAttribute("message", "Invalid login.");
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}
