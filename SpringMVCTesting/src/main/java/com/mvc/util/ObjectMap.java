package com.mvc.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

import com.mvc.exception.KeyNotFoundException;

import my.custom.pack.Address;


public class ObjectMap {

	private static HashMap<String,Class<?>> wrapperTypeHash = new HashMap<String,Class<?>>();
	final public static String DEFAULT = "DEFAULT";

	static{
		wrapperTypeHash.put("Short", Short.class);
		wrapperTypeHash.put("Byte", Byte.class);
		wrapperTypeHash.put("Integer", Integer.class);
		wrapperTypeHash.put("Long", Long.class);
		wrapperTypeHash.put("Double", Double.class);
		wrapperTypeHash.put("Float", Float.class);
		wrapperTypeHash.put("Void", Void.class);
		wrapperTypeHash.put("Character", Character.class);
		wrapperTypeHash.put("Boolean", Boolean.class);
	}

	private static boolean isUserDefineType(Field field){
		return !(field.getType() == String.class || field.getType().isPrimitive() || isWrrapperType(field.getType().getSimpleName()));
	}

	private static boolean isWrrapperType(String typeName){
		return (wrapperTypeHash.get(typeName) == null) ? false : true; 
	}

	public static HashMap<String,Object> objectMap(Object obj) {

		return objectMap(obj,DEFAULT);

		/*		if(obj == null)
			return null;

		Class<? extends Object> classObj = obj.getClass();

		if (!isClass(classObj))
			return null;

		System.out.println("class name : "+classObj.getName());
		HashMap<String, Object> objectMap = new HashMap<String, Object>();
		System.out.println("dss "+classObj.getDeclaredFields().length);
		for(Field field : classObj.getDeclaredFields()){
			System.out.println("field : "+field.getName());
			try {

				if(field.isAnnotationPresent(ObjectHash.class) && isUserDefineType(field)){
					ObjectHash objectHash = field.getAnnotation(ObjectHash.class);
					field.setAccessible(true);
					Object newObjectMap = (objectHash.keys().equals("")) ? objectMap(field.get(obj)) : objectMap(field.get(obj),objectHash.keys());
					objectMap.put(field.getName(),newObjectMap);
				}else if(!isUserDefineType(field)){
					field.setAccessible(true);
					objectMap.put(field.getName(),field.get(obj));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return objectMap;
		 */
		}

	private static boolean  isClass(Class<?> classObj){
		return (!(classObj.isAnnotation() || classObj.isInterface() || classObj.isEnum())); 
	} 
	
	public static String jsonString(Object obj){
		return new JSONObject(objectMap(obj)).toString();
	}
	
	public static String jsonString(Object obj,String key){
		return new JSONObject(objectMap(obj,key)).toString();
	}
	
	public static HashMap<String,Object> objectMap(Object obj,String keys) {
		if(obj == null || keys == null)
			return null;

		Class<? extends Object> classObj = obj.getClass();

		if (!isClass(classObj))
			return null;

		HashMap<String,Object> objectMap = new HashMap<String,Object>();

		String[] keyArray = keys.trim().split("~");
		Field[] fields = classObj.getDeclaredFields();

		if(!keyArray[0].equals(DEFAULT)){
			if(keyArray[0].equals("") || fields.length == 0)
				return objectMap;

			if(!isAllKeyExist(keyArray,fields))
				return null;
		}else{
			keyArray= getDefaultKeys(fields);
		}

		for(String key : keyArray){
			try {
				Field field;
				try {
					field = classObj.getDeclaredField(key.trim());
					if(field.isAnnotationPresent(ObjectHash.class) && isUserDefineType(field)){
						ObjectHash objectHash = field.getAnnotation(ObjectHash.class);
						field.setAccessible(true);
						Object newObjectMap = (objectHash.keys().equals("")) ? objectMap(field.get(obj)) : objectMap(field.get(obj),objectHash.keys());
						objectMap.put(field.getName(),newObjectMap);
					}else if(!isUserDefineType(field)){
						field.setAccessible(true);
						objectMap.put(field.getName(),field.get(obj));
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return objectMap;
	}

	private static boolean isAllKeyExist(String keys[],Field[] Fields){
		Set<String> keyMap = new HashSet<String>();
		for(Field field : Fields){
			System.out.println(field.getType().getSimpleName());
			keyMap.add(field.getName());
		}
		for(String key : keys){
			if(!keyMap.contains(key)){
				try {
					throw new RuntimeException("\""+key+"\" key not found in Object");
				} catch (KeyNotFoundException e) {
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
	}

	private static String[] getDefaultKeys(Field[] fields){
		String[] keys = new String[fields.length];
		for(int index=0 ;index < keys.length;index++){
			keys[index] = fields[index].getName();
		}
		return keys;
	}

	public static void main(String arhs[]){
		ObjectMap obj = new ObjectMap();
		Employee emp = new Employee();
		System.out.println("\n\nObject map is :  "+obj.jsonString(emp));
		System.out.println("after the exceptio................");
	}

}


class Employee{

	String name = "prakhar";
	private boolean active = true;
	Integer age = 23;
	int hieght=25;
	String[] x = {"prkhar","verma"};
	@ObjectHash
	Address add = new Address();

	public Employee(){
	}
	
	public void demo(){
	}
	
	/*
	{
		  "hieght":25, 
		"add":{
		  "tt":
		  {"heloo":"prakhar"},
		"streetName":"dwarka"}, 
		"name":"prakhar", 
		"active":true,
		"age":23
		}*/
	
}

