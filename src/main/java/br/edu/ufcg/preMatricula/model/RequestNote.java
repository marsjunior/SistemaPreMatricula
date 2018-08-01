package br.edu.ufcg.preMatricula.model;

public class RequestNote {
	
	
	private String azp;
	private String aud;
	private String sub;
	private String hd;
	private String email;
	private boolean email_verified;
	private String at_hash;
	private String exp;
	private String iss;
	private String jti;
	private String iat;
	private String name;
	private String picture;
	private String given_name;
	private String family_name;
	private String locale;
	private String alg;
	private String kid;
	
	public RequestNote(){
		
	}
	public RequestNote(String azp, String aud,	String sub, String hd, String email, boolean email_verified, String at_hash, String exp, String iss, String jti, String iat, String name, String picture, String given_name, String family_name, String locale, String alg, String kid){
		this.azp = azp;
		this.aud = aud;
		this.sub = sub;
		this.hd = hd;
		this.email = email;
		this.email_verified = email_verified;
		this.at_hash = at_hash;
		this.exp = exp;
		this.iss = iss;
		this.jti = jti;
		this.iat = iat;
		this.name = name;
		this.picture = picture;
		this.given_name = given_name;
		this.family_name = family_name;
		this.locale = locale;
		this.alg = alg;
		this.kid = kid;
	}
	
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getAzp() {
		return azp;
	}
	public void setAzp(String azp) {
		this.azp = azp;
	}
	public String getAud() {
		return aud;
	}
	public void setAud(String aud) {
		this.aud = aud;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmail_verified() {
		return email_verified;
	}
	public void setEmail_verified(boolean email_verified) {
		this.email_verified = email_verified;
	}
	public String getAt_hash() {
		return at_hash;
	}
	public void setAt_hash(String at_hash) {
		this.at_hash = at_hash;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAlg() {
		return alg;
	}
	public void setAlg(String alg) {
		this.alg = alg;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	
}
