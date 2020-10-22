import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    public HelloServlet() {
        super();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setText("Hello World!");
        greeting.getTranslations().put("de", "Hallo Welt!");
        greeting.getTranslations().put("fr", "Bonjour Monde!");

        response.setContentType("application/json");
        response.getWriter().print(objectMapper.writeValueAsString(greeting));
    }
}
