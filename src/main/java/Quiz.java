public class Quiz {
    String id;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    int correct_option;
    public Quiz(String id, String question, String option1, String option2, String option3, String option4, int correct_option) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct_option = correct_option;
    }
}
