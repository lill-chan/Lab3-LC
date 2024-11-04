package org.translation;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Example working with JSON data. The data consists of an array with two objects in it.
 * Each object has two key-value pairs in it.
 */
public class JSONDemo {
    /**
     * A first example of working with JSON data.
     * @param args not used
     */
    public static void main(String[] args) {
        // make a String called jsonData (2 objects, with two keys each object)
        String jsonData = "[{\"key1\" : \"string1a\", \"key2\":21}, {\"key1\" : \"string1b\", \"key2\":22}]";
        // make a JSONArray (iterable object) called jsonArray passing in the jsonData string
        JSONArray jsonArray = new JSONArray(jsonData);
        // print the contents of the jsonArray iterable object
        System.out.println(jsonArray);
        // print the length of the jsonArray object -- should be 2.
        System.out.println(jsonArray.length());
        // note that we can use jsonArray.get, but its return type is just Object,
        // which isn't as useful as below.
        // create JSON Obj class called jsonObject, and let it be the first object in jsonArray
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        // print the object
        System.out.println(jsonObject);
        // print the string paired with key1, object 1
        System.out.println(jsonObject.getString("key1"));
        // print the string of the interger paired with key2, object 1
        System.out.println(jsonObject.getInt("key2"));
        // print the string of the 2nd object's key 1.
        System.out.println(getKeyOneOfSecond(jsonArray));
    }

    /**
     * Returns the value of key "key1" from the second object in the given jsonArray.
     * The code may assume that the key exists and that the jsonArray has at least two items in it.
     * @param jsonArray the jsonArray to get the value from
     * @return value of key "key1" from the second object in the given jsonArray
     */
    public static String getKeyOneOfSecond(JSONArray jsonArray) {
        // TODO: (DONE) Complete this method.
        JSONObject jsonObject = jsonArray.getJSONObject(1);
        return jsonObject.getString("key1");
    }

}
