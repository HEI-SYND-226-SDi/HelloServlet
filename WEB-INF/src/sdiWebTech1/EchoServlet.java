package sdiWebTech1;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class EchoServlet extends HttpServlet {
 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html; charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<title>Echo Servlet</title></head>");
         out.println("<body><br><h1>You are</h1><br><hr>");
 
         // Retrieve the value of the query parameter "firstname" 
         String firstname = request.getParameter("firstname");
         out.println("<p>Name: " + firstname + "</p>");
         // Retrieve the value of the query parameter "lastname" 
         String lastname = request.getParameter("lastname");
         out.println("<p>Lastname: " + lastname + "</p><hr><br>"); 
         // Hyperlink "BACK" to input page
         out.println("<a href='inputform.html'>BACK</a>");
         out.println("</body></html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
   // Redirect POST request to GET request.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      doGet(request, response);
   }
 }
 
 