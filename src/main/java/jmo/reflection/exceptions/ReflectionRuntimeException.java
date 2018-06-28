package jmo.reflection.exceptions;

public class ReflectionRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReflectionRuntimeException() {
		super();
	}

	public ReflectionRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReflectionRuntimeException(String message) {
		super(message);
	}

	public ReflectionRuntimeException(Throwable cause) {
		super(cause);
	}
}
