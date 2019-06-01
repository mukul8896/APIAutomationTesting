package com.mukul.pojoResponse;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu{

	@SerializedName("popup")
	@Expose
	private Popup popup;
	public Popup getPopup() {
		return popup;
	}
	public void setPopup(Popup popup) {
		this.popup = popup;
	}


	@SerializedName("id")
	@Expose
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	@SerializedName("value")
	@Expose
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


	@SerializedName("empty")
	@Expose
	private List<String> empty;
	public List<String> getEmpty() {
		return empty;
	}
	public void setEmpty(List<String> empty) {
		this.empty = empty;
	}


}
