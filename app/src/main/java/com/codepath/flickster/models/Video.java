package com.codepath.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hezhang on 9/16/17.
 */

public class Video {

    public String getKey() {
        return key;
    }

    public String name() {
        return name;
    }
    String name;
    String key;

    public Video(JSONObject jsonObject) throws JSONException {
        this.name = jsonObject.getString("name");
        this.key = jsonObject.getString("key");
    }

    public static ArrayList<Video> fromJSONArray(JSONArray array) {
        ArrayList<Video> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Video(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
