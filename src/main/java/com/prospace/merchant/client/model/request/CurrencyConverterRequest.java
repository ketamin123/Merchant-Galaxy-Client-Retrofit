package com.prospace.merchant.client.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CurrencyConverterRequest implements Serializable {

	@JsonProperty("roman_i")
	private String romanI;

	@JsonProperty("roman_v")
	private String romanV;

	@JsonProperty("roman_x")
	private String romanX;

	@JsonProperty("roman_l")
	private String romanL;

	@JsonProperty("roman_c")
	private String romanC;

	@JsonProperty("roman_d")
	private String romanD;

	@JsonProperty("roman_m")
	private String romanM;

	@JsonProperty("currency_values_declaration")
	private List<String> currencyValuesDeclaration;

	@JsonProperty("questions")
	private List<String> questions;

	public CurrencyConverterRequest(String romanI, String romanV, String romanX, String romanL, String romanC, String romanD, String romanM) {
		this.romanI = romanI;
		this.romanV = romanV;
		this.romanX = romanX;
		this.romanL = romanL;
		this.romanC = romanC;
		this.romanD = romanD;
		this.romanM = romanM;
	}

	public CurrencyConverterRequest() {
	}

	public String getRomanI() {
		return romanI;
	}

	public void setRomanI(String romanI) {
		this.romanI = romanI;
	}

	public String getRomanV() {
		return romanV;
	}

	public void setRomanV(String romanV) {
		this.romanV = romanV;
	}

	public String getRomanX() {
		return romanX;
	}

	public void setRomanX(String romanX) {
		this.romanX = romanX;
	}

	public String getRomanL() {
		return romanL;
	}

	public void setRomanL(String romanL) {
		this.romanL = romanL;
	}

	public String getRomanC() {
		return romanC;
	}

	public void setRomanC(String romanC) {
		this.romanC = romanC;
	}

	public String getRomanD() {
		return romanD;
	}

	public void setRomanD(String romanD) {
		this.romanD = romanD;
	}

	public String getRomanM() {
		return romanM;
	}

	public void setRomanM(String romanM) {
		this.romanM = romanM;
	}

	public List<String> getCurrencyValuesDeclaration() {
		return currencyValuesDeclaration;
	}

	public void setCurrencyValuesDeclaration(List<String> currencyValuesDeclaration) {
		this.currencyValuesDeclaration = currencyValuesDeclaration;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
}