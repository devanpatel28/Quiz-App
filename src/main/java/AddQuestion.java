import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-question")
public class AddQuestion extends HttpServlet {
    QuizService qs;

    @Override
    public void init() throws ServletException {
        qs = new QuizService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        RequestDispatcher rd = req.getRequestDispatcher("add-question.html");
        rd.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String btn = req.getParameter("add");
        if(btn!=null && btn.equals("add"))
        {
            String question = req.getParameter("question");
            String option1 = req.getParameter("option1");
            String option2 = req.getParameter("option2");
            String option3 = req.getParameter("option3");
            String option4 = req.getParameter("option4");
            int corOpt = Integer.parseInt(req.getParameter("correct_answer"));
            qs.addQuestion(question,option1,option2,option3,option4,corOpt);
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.print("<table>");
            out.print("<tr><th>ID</th><th>Question</th><th>Option1</th><th>Option2</th><th>Option3</th><th>Option4</th><th>Correct</th></tr>");
            for (Object quiz: qs.getAllQuestion())
            {
                Quiz q = (Quiz)quiz;
                out.print("<tr><td>"+q.id+"</td><td>"+q.question+"</td><td>"+q.option1+"</td><td>"+q.option2+"</td><td>"+q.option3+"</td><td>"+q.option4+"</td><td>"+q.correct_option+"</td></tr>");
            }
            out.print("</table>");
        }
    }

}
