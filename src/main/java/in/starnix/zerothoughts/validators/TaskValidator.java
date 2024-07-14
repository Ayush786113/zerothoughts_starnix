package in.starnix.zerothoughts.validators;

import org.springframework.stereotype.Component;

@Component
public class TaskValidator {

    public boolean taskPresent(String task){
        return task != null;
    }

    public boolean validParentId(String parentId){
        return false;
    }
}
