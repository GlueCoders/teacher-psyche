package org.gluecoders.ipat.teacherspysche.validators;

import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;

public abstract class Validator<T> {

    public abstract void validate(T t) throws ValidationException;

    protected boolean assertNotNull(Object ... args){
        for(Object arg: args){
            if(arg == null) {
                return false;
            }
        }
        return true;
    }
}
