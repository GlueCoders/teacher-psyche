package org.gluecoders.ipat.teacherspysche.servlets;

import com.google.common.io.CharStreams;
import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.helpers.JsonHelper;
import org.gluecoders.ipat.teacherspysche.validators.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class HttpServlet<T> extends javax.servlet.http.HttpServlet {

    private static final Logger log = Logger.getLogger(HttpServlet.class.getName());
    private final Validator<T> validator;

    protected HttpServlet(Validator<T> validator) {
        this.validator = validator;
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            log.info("Received request for " + req.getServletPath());
            T t = getBody(req);
            validator.validate(t);
            handleRequest(t, req, resp);
            success(resp);
        } catch (ResourceAlreadyExistsException e) {
            log.info("ResourceAlreadyExistsException occurred "+e.getMessage());
            handleErrorCode(ErrorMessage.ErrorCode.RESOURCE_ALREADY_EXISTS, resp);
        } catch (ValidationException e) {
            log.info("Validation Error occurred "+e.getMessage());
            handleErrorCode(ErrorMessage.ErrorCode.VALIDATION_FAILED, resp);
        } catch (Exception e) {
            log.severe("Generic Error occurred " + e.getMessage());
            handleErrorCode(ErrorMessage.ErrorCode.GENERIC_ERROR, resp);
        }
    }

    protected void success(HttpServletResponse resp) throws IOException {
        log.info("Request is served");
        resp.sendRedirect(getSuccessPage().get());
    }

    protected T getBody(HttpServletRequest req) throws IOException {
        log.fine("Converting json to pojo: " + getRequestType());
        String json = CharStreams.toString(req.getReader());
        T t = JsonHelper.toPojo(json, getRequestType());
        log.fine("Converted json to pojo");
        return t;
    }

    protected void handleErrorCode(ErrorMessage.ErrorCode errorCode, HttpServletResponse resp) {
        ErrorMessage message = new ErrorMessage(errorCode);
        String content = JsonHelper.toJson(message);
        try {
            resp.getOutputStream().print(content);
            resp.getOutputStream().flush();
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    protected void handleRequest(T t, HttpServletRequest req,HttpServletResponse resp) throws ResourceAlreadyExistsException, ValidationException {
        handleRequest(t);
    }

    public abstract void handleRequest(T t)throws ResourceAlreadyExistsException, ValidationException;

    public abstract Class<T> getRequestType();

    public abstract Pages getSuccessPage();
}
