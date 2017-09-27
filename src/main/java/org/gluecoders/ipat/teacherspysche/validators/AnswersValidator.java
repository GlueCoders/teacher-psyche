package org.gluecoders.ipat.teacherspysche.validators;

import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.models.Answers;
import org.gluecoders.ipat.teacherspysche.models.TestLink;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class AnswersValidator extends Validator<Answers> {
    @Override
    public void validate(Answers answers) throws ValidationException {
        if(answers != null){
            boolean valid = assertNotNull(answers.getValue());
            if(valid){
                return;
            }
        }
        throw new ValidationException("Answers request is not valid");
    }
}
