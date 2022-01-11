package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


public class SubjectNotFoundException extends RuntimeException{

    public SubjectNotFoundException(int id){
        super("Nie znaleziono przedmiotu o id " + id);
    }
    public SubjectNotFoundException(int id, int id1){
        super("Nie znaleziono przedmiotu lub studenta!");
    }
}
