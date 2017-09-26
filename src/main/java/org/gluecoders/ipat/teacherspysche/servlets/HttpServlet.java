package org.gluecoders.ipat.teacherspysche.servlets;

import com.google.common.io.CharStreams;
import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.helpers.JsonHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class HttpServlet<T> extends javax.servlet.http.HttpServlet {

    private static final Logger log = Logger.getLogger(HttpServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            log.info("Received request for " + req.getServletPath());
            log.fine("Converting json to pojo: " + getRequestType());
            String json = CharStreams.toString(req.getReader());
            T t = JsonHelper.toPojo(json, getRequestType());
            log.fine("Converted json to pojo, invoking handleRequest");
            handleRequest(t);
            log.info("Request is served");
        } catch (ResourceAlreadyExistsException e) {
            log.info("ResourceAlreadyExistsException occurred "+e.getMessage());
        } catch (ValidationException e) {
            log.info("Validation Error occurred "+e.getMessage());
        } catch (Exception e) {
            log.severe("Generic Error occurred " + e.getMessage());
            resp.sendRedirect(Pages.GENERIC_ERROR.get());
        }
    }

    public abstract Class<T> getRequestType();

    public abstract void handleRequest(T t) throws ValidationException, ResourceAlreadyExistsException;
}
