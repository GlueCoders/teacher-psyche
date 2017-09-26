package org.gluecoders.ipat.teacherspysche.servlets;

import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.models.TestLink;
import org.gluecoders.ipat.teacherspysche.usecases.AuthenticateTestLink;
import org.gluecoders.ipat.teacherspysche.validators.TestLinkValidator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class AuthenticateTestLinkServlet extends HttpServlet<TestLink> {

    private static final Logger log = Logger.getLogger(AuthenticateTestLinkServlet.class.getName());
    private final AuthenticateTestLink usecase;

    public AuthenticateTestLinkServlet() {
        super(new TestLinkValidator());
        usecase = new AuthenticateTestLink();
    }

    @Override
    public Class<TestLink> getRequestType() {
        return TestLink.class;
    }

    @Override
    public void handleRequest(TestLink testLink) throws ResourceAlreadyExistsException {

    }

    @Override
    protected void handleRequest(TestLink testLink, HttpServletRequest req, HttpServletResponse resp) throws ResourceAlreadyExistsException, ValidationException {
        log.info("handling testlink request");
        String id = usecase.authenticate(testLink.getToken());
        resp.addCookie(new Cookie("userid", id));
        log.info("id generated and set in cookie "+id);
    }

    @Override
    public Pages getSuccessPage() {
        return Pages.TEST_PAGE;
    }

}
