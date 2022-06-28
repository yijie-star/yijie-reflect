package cn.cempro.user.service;

/**
 * 自定义UserException异常
 *  只是给出父类中的构造器即可！方便用来创建对象
 */
public class UserException extends Exception{
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
