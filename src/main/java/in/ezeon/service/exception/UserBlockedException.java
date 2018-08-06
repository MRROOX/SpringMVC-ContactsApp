package in.ezeon.service.exception;

/**
 *
 * @author unknown
 */
public class UserBlockedException extends Exception {

    /**
     * Creates User Object without error description.
     */
    public UserBlockedException() {
    }

    /**
     * Creates User object with error description.
     *
     * @param errDesc
     */
    public UserBlockedException(String errDesc) {
        super(errDesc);
    }
}
