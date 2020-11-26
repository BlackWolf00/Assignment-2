////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable {
    private String message;
    public TakeAwayBillException(String msg){
        message=msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}