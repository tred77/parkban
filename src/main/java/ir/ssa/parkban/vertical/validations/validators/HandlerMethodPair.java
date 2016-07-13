package ir.ssa.parkban.vertical.validations.validators;

/**
 * Created by Behrouz-ZD on 7/10/2016.
 */
public class HandlerMethodPair {

    private ValidationHandler handler;
    private String methodName;
    private Object[] arguments;

    public HandlerMethodPair(){}
    public HandlerMethodPair(ValidationHandler handler, String methodName,Object[] arguments){
        this.handler = handler;
        this.methodName = methodName;
        this.arguments=arguments;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ValidationHandler getHandler() {
        return handler;
    }

    public void setHandler(ValidationHandler handler) {
        this.handler = handler;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}
