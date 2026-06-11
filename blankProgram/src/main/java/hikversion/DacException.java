package hikversion;

import org.springframework.http.HttpStatus;

public class DacException extends RuntimeException {

    private static final long serialVersionUID = -2575681791792926769L;

    private String code = "0";

    private String msg;

    private int status = HttpStatus.OK.value();

    public DacException(String code) {
        super();
        this.code = code;
    }

    public DacException(String msg, String code) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public DacException(String msg, String code, int status) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public DacException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public DacException(Throwable cause, String code, int status) {
        super(cause);
        this.code = code;
        this.status = status;
    }


    public DacException(String msg, Throwable cause, String code) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public DacException(String msg, Throwable cause, String code, int status) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    protected DacException(String message, Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

}
