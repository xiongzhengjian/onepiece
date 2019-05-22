package com.wistron.pojo;

public class Dictionary {
	
	private int dictionary_id;
	private String message;
	private String code;
	
	public Dictionary() {
		super();
	}
	public Dictionary(int dictionary_id, String message, String code) {
		super();
		this.dictionary_id = dictionary_id;
		this.message = message;
		this.code = code;
	}
	
	public int getDictionary_id() {
		return dictionary_id;
	}
	public void setDictionary_id(int dictionary_id) {
		this.dictionary_id = dictionary_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Dictionary [dictionary_id=" + dictionary_id + ", message=" + message + ", code=" + code + "]";
	}
	
}
