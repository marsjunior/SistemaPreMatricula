package br.edu.ufcg.preMatricula.model;


public class LoginNote {
	
	String idTokenString;
	
	public LoginNote(){
		
	}
	public LoginNote(String idTokenString){
		this.idTokenString = idTokenString;
	}
	public String getIdTokenString() {
		return idTokenString;
	}
	public void setIdTokenString(String idTokenString) {
		this.idTokenString = idTokenString;
	}
	
}
