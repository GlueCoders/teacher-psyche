package org.gluecoders.ipat.teacherspysche.validators;

import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.models.TestLink;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class TestLinkValidator extends Validator<TestLink> {
    @Override
    public void validate(TestLink testLink) throws ValidationException {
        if(testLink != null){
            boolean valid = assertNotNull(testLink.getToken());
            if(valid){
                return;
            }
        }
        throw new ValidationException("TestLink request is not valid");
    }
}
