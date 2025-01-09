import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("number");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Validate data (you can add more validation if needed)

        // Write data to a text file
        writeToFile(name, phone, email, message);

        // Send a response back to the client
        PrintWriter out = response.getWriter();
        out.println("<html><body><p>Thank you for sharing your review with us!</p></body></html>");
    }

    private void writeToFile(String name, String phone, String email, String message) {
        // Specify the path to your text file
        String filePath = "C:\Users\user\Downloads\data review.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            // Append data to the file
            writer.println("Name: " + name);
            writer.println("Phone: " + phone);
            writer.println("Email: " + email);
            writer.println("Message: " + message);
            writer.println("----------");  // Separator between entries
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
