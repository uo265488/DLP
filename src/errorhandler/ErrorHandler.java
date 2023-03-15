package errorhandler;

import ast.type.ErrorType;
import utils.ArgumentChecks;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private List<ErrorType> errors = new ArrayList<>();
    private static ErrorHandler INSTANCE = null;

    private ErrorHandler() {
    }

    public static ErrorHandler getInstance() {
        if(INSTANCE == null) INSTANCE = new ErrorHandler();

        return INSTANCE;
    }

    public boolean anyErrors() {
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream out) {
        errors.stream().forEach(e -> out.println(e));
    }

    public void addError(ErrorType errorType) {
        ArgumentChecks.isNotNull(errorType);

        errors.add(errorType);
    }
}
