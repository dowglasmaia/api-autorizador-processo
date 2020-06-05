package org.maia.procedimentosapi.services.execeptions;

public class ObjectNotFoundExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExecption() {
		super();
	}

	public ObjectNotFoundExecption(String msg) {
		super(msg);
	}

}
