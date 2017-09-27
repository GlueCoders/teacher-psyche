package org.gluecoders.ipat.teacherspysche.servlets;

import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.models.Answers;
import org.gluecoders.ipat.teacherspysche.usecases.Score;
import org.gluecoders.ipat.teacherspysche.validators.AnswersValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class ScoreServlet extends HttpServlet<Answers> {

    private static final Logger log = Logger.getLogger(ScoreServlet.class.getName());
    private final Score usecase;

    protected ScoreServlet() {
        super(new AnswersValidator());
        usecase = new Score();
    }

    @Override
    public Class<Answers> getRequestType() {
        return Answers.class;
    }

    @Override
    public void handleRequest(Answers answers) throws ResourceAlreadyExistsException {

    }

    @Override
    protected void handleRequest(Answers answers, HttpServletRequest req, HttpServletResponse resp) throws ResourceAlreadyExistsException, ValidationException {
    }

    @Override
    public Pages getSuccessPage() {
        return null;
    }
}
