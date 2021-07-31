package kaluzny.example.jee.uuid;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/", value = "jee-uuid")
public class UuidServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(UuidServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Generate UUID.");
        UuidGenerator generator = (UuidGenerator) request.getServletContext()
                .getAttribute(UuidGenerator.class.getName());
        Objects.requireNonNull(generator);

        OutputStream responseContent = response.getOutputStream();
        responseContent.write(generator.generate().getBytes());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello World!");
    }
}
