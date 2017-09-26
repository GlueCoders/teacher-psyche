package org.gluecoders.ipat.teacherspysche.servlets;

import org.gluecoders.ipat.teacherspysche.db.StaffMemberDao;
import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;
import org.gluecoders.ipat.teacherspysche.usecases.OnboardStaffMember;
import org.gluecoders.ipat.teacherspysche.validators.OnboardStaffMemberValidator;

import java.util.logging.Logger;

public class OnboardServlet extends HttpServlet<StaffMember> {

    private static final Logger log = Logger.getLogger(HttpServlet.class.getName());
    private final OnboardStaffMember usecase;

    public OnboardServlet() {
        super(new OnboardStaffMemberValidator());
        usecase = new OnboardStaffMember(new StaffMemberDao());
    }

    @Override
    public Class<StaffMember> getRequestType() {
        return StaffMember.class;
    }

    @Override
    public void handleRequest(StaffMember staffMember) throws ResourceAlreadyExistsException {
        log.info("Handling onboarding request");
        usecase.onboard(staffMember);
        log.info("User onboarded");
    }

    @Override
    public Pages getSuccessPage() {
        return Pages.ONBOARD_SUCCESS;
    }
}
