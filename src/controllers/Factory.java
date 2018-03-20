package controllers;

public class Factory {
	private static final Factory instance = new Factory();
	
	private Factory(){}
	
	public static Factory getInstance(){
		return instance;
	}
	
	public IOperations getIOperations(){
		return CtrlOperations.getInstance();
	}
}
