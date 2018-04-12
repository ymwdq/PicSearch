package com.ym.picsearch.core.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PicInfoJson {

    private List<EdgeCoordinate> coordinates;
    private String id;
    private JSONObject jsonObject;

    public PicInfoJson(String jsonString) {
        jsonObject = new JSONObject(jsonString);
        id = jsonObject.getString("id");
        coordinates = strings2coordinates(jsonArrayToStringList(jsonObject.getJSONArray("coordinates")));
    }

    public String getId() {
        return id;
    }

    public Collection<EdgeCoordinate> getEdgeCoordinates() {
        return coordinates;
    }

    private List<String> jsonArrayToStringList(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<String> r = new ArrayList<>(jsonArray.length() * 3);
        for (Object obj : jsonArray) {
            r.add((String)obj);
        }
        return r;
    }

    private List<EdgeCoordinate> strings2coordinates(List<String> coordinateStrings) {
        List<EdgeCoordinate> coordinates = new ArrayList<>(coordinateStrings.size() * 2);
        for (String str : coordinateStrings) {
            coordinates.add(new EdgeCoordinateImpl(str));
        }
        return coordinates;
    }
}
