package com.bookapp.JSON;

public class Item {

    private String kind;
    private String id;
    private VolumeInfo volumeInfo;

    public Item(){};

    public Item(String kind, String id, VolumeInfo volumeInfo) {
        this.kind = kind;
        this.id = id;
        this.volumeInfo = volumeInfo;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
