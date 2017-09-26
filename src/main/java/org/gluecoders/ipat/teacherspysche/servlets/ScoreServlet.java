package org.gluecoders.ipat.teacherspysche.servlets;

import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.usecases.Score;
import org.gluecoders.ipat.teacherspysche.validators.Validator;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class ScoreServlet extends HttpServlet<Score> {

    protected ScoreServlet(Validator<Score> validator) {
        super(validator);
    }

    @Override
    public Class<Score> getRequestType() {
        return Score.class;
    }

    @Override
    public void handleRequest(Score score) throws ResourceAlreadyExistsException {

    }

    @Override
    public Pages getSuccessPage() {
        return null;
    }
}
