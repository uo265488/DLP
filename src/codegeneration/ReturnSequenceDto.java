package codegeneration;

import ast.definition.VarDefinition;

public class ReturnSequenceDto {

    public int bytesLocals;
    public int bytesParams;
    public int bytesReturn;

    public ReturnSequenceDto(int bytesReturn, int bytesLocals, int bytesParams) {
        this.bytesReturn = bytesReturn;
        this.bytesLocals = bytesLocals;
        this.bytesParams = bytesParams;
    }
}
