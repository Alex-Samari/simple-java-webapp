//using the webapp package(similar to namespace in c++)
package webapp;
//importing the User class in the appLayer package(similar to namespace in c++)
import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // <<printing the username and password posted from the form on the screen>>

        //PrintWriter out = response.getWriter();
        //out.println("doPost-version");
        //out.print("User Name: " + request.getParameter("username") + "\n" + "password: " + request.getParameter("password"));

        // <<loading the welcome.jsp page whenever a user post data in the login.jsp form and showing given data>>

        //creating a new User object
        User userObj = new User();

        //the first username is the attribute in our welcome.jsp page
        //the second username is the parameter passed to the form (using post method) in login.jsp page
        request.setAttribute("username", request.getParameter("username"));

        //the first password is the attribute in our welcome.jsp page
        //the second password is the parameter passed to the form (using post method) in login.jsp page
        request.setAttribute("password", request.getParameter("password"));

        // validating the username and password
        if(userObj.isValidUserCredentials(request.getParameter("username"), request.getParameter("password"))){
            // Redirect to the welcome.jsp page. similar to redirect in Node.js TODO: understand the syntax
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
        // if the user credentials are incorrect:
        else {
            //setting an error message
            request.setAttribute("errMsg", "Invalid username and password! Please try again...");
            //redirecting to the login page
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doGet-version");
        out.print("User Name: " + request.getParameter("username") + "\n" + "password: " + request.getParameter("password"));
    }
}
