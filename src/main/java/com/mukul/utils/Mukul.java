package com.mukul.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Mukul {
	public void generatePojos(JSONObject jsonobject,String folderPath,String packageName,String className) {
		Set<String> keys=jsonobject.keySet();
		//packageName=packageName.replace('.', '/')
		try {
			PrintWriter writer= new PrintWriter(new OutputStreamWriter(new FileOutputStream(folderPath+"/"+packageName.replace('.', '/')+"/"+className.substring(0,1).toUpperCase()+className.substring(1)+".java")));
			writer.println("package "+packageName+";");
			writer.println("import java.util.List;\nimport com.google.gson.annotations.Expose;\nimport com.google.gson.annotations.SerializedName;\n");
			writer.println("public class "+className.substring(0, 1).toUpperCase()+className.substring(1)+"{\n");
			for (String key : keys) {
				Object object=jsonobject.get(key);
				if(object instanceof String) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate String "+key+";");
				}else if(object instanceof Integer) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate String "+key+";");
				}else if(object instanceof Integer) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate Integer "+key+";");
				}else if(object instanceof Double) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate Double "+key+";");
				}else if(object instanceof Long) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate Long "+key+";");
				}else if(object instanceof Boolean) {
					writer.println("\tprivate Boolean "+key+";");
				}else if(object == null) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate Object "+key+";");
				}else if(object instanceof JSONArray) {
					generatePojos((JSONArray)jsonobject.get(key), folderPath, packageName, key, writer);
				}else if(object instanceof JSONObject) {
					writer.println("\t@SerializedName("+"\""+key+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate "+key.substring(0,1).toUpperCase()+key.substring(1)+" "+key+";");
					generatePojos((JSONObject) object, folderPath, packageName, key);
				}
			}
			writer.println("}");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generatePojos(JSONArray jsonArray,String folderPath,String packageName,String className,PrintWriter writer) {
		List<Object> list=(ArrayList<Object>) jsonArray;
		if(writer==null) {
			try {
				writer=new PrintWriter(new OutputStreamWriter(new FileOutputStream(folderPath+"/"+packageName.replace('.', '/')+"/"+className.substring(0,1).toUpperCase()+className.substring(1)+".java")));
				writer.println("package "+packageName+";");
				writer.println("import java.util.List;\nimport com.google.gson.annotations.Expose;\nimport com.google.gson.annotations.SerializedName;\n");
				writer.println("public class "+className.substring(0, 1).toUpperCase()+className.substring(1)+"{\n");
				if(list.isEmpty() || list.contains(null)) {
					//do nothing
				}else if(list.get(0) instanceof JSONObject){
					writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate List<"+className.substring(0,1).toUpperCase()+className.substring(1)+"Object> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"objects;");
					//System.out.println((JSONObject) list.get(0)+"mukul");
					generatePojos((JSONObject) list.get(0), folderPath, packageName, className+"Object");
				}else if(list.get(0) instanceof String) {
					writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate List<String> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"value;");
				}else if(list.get(0) instanceof Integer) {
					writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate List<Integer> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"value;");
				}else if(list.get(0) instanceof Long) {
					writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate List<Long> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"value;");
				}else if(list.get(0) instanceof Double) {
					writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
					writer.println("\t@Expose");
					writer.println("\tprivate List<Double> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"value;");
				}
				writer.println("}");
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(list.isEmpty() || list.contains(null)) {
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<"+className.substring(0, 1).toUpperCase()+className.substring(1)+"> "+className.substring(0, 1).toLowerCase()+className.substring(1)+"=null;");
				createEmptyClass(folderPath,packageName,className);
			}else if(list.get(0) instanceof JSONObject){
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<"+className.substring(0,1).toUpperCase()+className.substring(1)+"> "+className.substring(0, 1).toLowerCase()+className.substring(1)+";");
				generatePojos((JSONObject) list.get(0), folderPath, packageName, className);
			}else if(list.get(0) instanceof String) {
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<String> "+className.substring(0, 1).toLowerCase()+className.substring(1)+";");
			}else if(list.get(0) instanceof Integer) {
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<Integer> "+className.substring(0, 1).toLowerCase()+className.substring(1)+";");
			}else if(list.get(0) instanceof Long) {
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<Long> "+className.substring(0, 1).toLowerCase()+className.substring(1)+";");
			}else if(list.get(0) instanceof Double) {
				writer.println("\t@SerializedName("+"\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"\""+")");
				writer.println("\t@Expose");
				writer.println("\tprivate List<Double> "+className.substring(0, 1).toLowerCase()+className.substring(1)+";");
			}
		}
	}
	
	private void createEmptyClass(String folderPath,String packageName,String className) {
		try {
			PrintWriter writer=new PrintWriter(new OutputStreamWriter(new FileOutputStream(folderPath+"/"+packageName.replace('.', '/')+"/"+className.substring(0,1).toUpperCase()+className.substring(1)+".java")));
			writer.println("package "+packageName+";");
			writer.println("public class "+className.substring(0, 1).toUpperCase()+className.substring(1)+"{\n");
			writer.println("}");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
