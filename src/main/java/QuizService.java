import java.util.Date;
import java.util.ArrayList;
public class QuizService {
    ArrayList<Quiz> list;
    QuizService(){
        list = new ArrayList<>();
    }
    public void addQuestion(String ques,String opt1,String opt2,String opt3,String opt4,int curOpt){
        list.add(new Quiz(new Date().toString(),ques,opt1,opt2,opt3,opt4,curOpt));
    }
    public void getAllQuestion()
    {

    }
}
