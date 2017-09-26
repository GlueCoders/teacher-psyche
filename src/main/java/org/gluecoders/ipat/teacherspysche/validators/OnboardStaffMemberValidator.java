package org.gluecoders.ipat.teacherspysche.validators;

import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

public class OnboardStaffMemberValidator extends Validator<StaffMember> {
    @Override
    public void validate(StaffMember staffMember) throws ValidationException {
        if(staffMember != null){
            boolean valid = assertNotNull(staffMember.getEmail(), staffMember.getMobile(), staffMember.getName(), staffMember.getSchool(), staffMember.getTitle());
            if(valid) {
                return;
            }
        }
        throw new ValidationException("Staff Member Onboard request is invalid");
    }
}
