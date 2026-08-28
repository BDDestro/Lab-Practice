import org.owasp.validator.html.*;
import MyCommentDAO;



public class AntiSamyController {
    public void saveNewComment(int threadID, int userID, String newComment) {
         {
            // Load the policy file
            Policy p = Policy.getInstance("antisamy-slashdot.xml");

            // Create an instance of AntiSamy
            AntiSamy as = new AntiSamy();

            // Scan the input comment against the policy
            CleanResults clean = as.scan(newComment, p);

           

            // Save the sanitized comment to the database
            MyCommentDAO.addComment(threadID, userID, clean.getCleanHTML());

  
        }
    }
}



