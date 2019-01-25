package com.wordException;

public class WordAnalysisException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WordAnalysisException() {
		
	}
	public WordAnalysisException(String message) {
		super(message);
	}
	public WordAnalysisException(String message,Throwable cause) {
		super(message,cause);
	}

}
