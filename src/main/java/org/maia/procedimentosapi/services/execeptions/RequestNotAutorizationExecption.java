package org.maia.procedimentosapi.services.execeptions;

public class RequestNotAutorizationExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RequestNotAutorizationExecption() {
		super();
	}

	public RequestNotAutorizationExecption(String msg) {
		super(msg);
	}

}
