package com.ym.picsearch.core.model;

public class EdgeCoordinateImpl implements EdgeCoordinate {

    private float[] coordinate;

    public EdgeCoordinateImpl(float x, float y, float slope) {
        coordinate = new float[3];
        coordinate[0] = x;
        coordinate[1] = y;
        coordinate[2] = slope;
    }

    public EdgeCoordinateImpl(String str) {
        coordinate = new float[3];
        str = str.replace("(", "").replace(")", "");
        String[] coordinateStr = str.split(",");
        coordinate[0] = Float.valueOf(coordinateStr[0].trim());
        coordinate[1] = Float.valueOf(coordinateStr[1].trim());
        coordinate[2] = Float.valueOf(coordinateStr[2].trim());
    }

    @Override
    public float[] getCoordinate() {
        return coordinate;
    }

    @Override
    public float getX() {
        return coordinate[0];
    }

    @Override
    public float getY() {
        return coordinate[1];
    }

    @Override
    public float getSlope() {
        return coordinate[2];
    }

    @Override
    public String toString() {
        return "" + coordinate[0] + "," + coordinate[1] + "," + coordinate[2];
    }

    @Override
    public int hashCode() {
        return ("" + coordinate[0] + "," + coordinate[1] + "," + coordinate[2]).hashCode();
    }

}
