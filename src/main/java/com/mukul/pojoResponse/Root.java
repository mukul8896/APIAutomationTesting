package com.mukul.pojoResponse;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Root{

	@SerializedName("root")
	@Expose
	private List<RootObject> root;
}
