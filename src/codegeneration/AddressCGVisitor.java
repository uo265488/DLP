package codegeneration;

public class AddressCGVisitor extends DefaultCGVisitorImpl<Void, Void> {

    /**
     *  address[[ Variable : exp -> ID ]] =
     *          if ( exp.definition.scope == 0) {
     *              <pusha > exp.type.offset
     *          } else {
     *              <push bp>
     *              <pushi > exp.definition.offset
     *              <addi >
     *          }
     */

    /** (Wrong)
     *  address[[ Indexing: exp1 -> exp2 exp3 ]] =
     *          address[[exp2]]
     *          value[[exp3]]
     *          <pushi > exp2.type.numberOfBytes()
     *          <muli>
     *          <addi>
     */

    /** (Wrong)
     *   address[[ FieldAccess : exp1 -> exp2 ID ]] =
     *           address[[exp2]]
     *           <pushi > exp2.type.getRecordField(ID.value).offset()
     */

}
