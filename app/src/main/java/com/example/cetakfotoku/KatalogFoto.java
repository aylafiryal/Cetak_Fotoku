package com.example.cetakfotoku;

public class KatalogFoto {

    private int resId;
    private String fileName;

    public KatalogFoto(int _resId, String _filename){
        resId = _resId;
        fileName = _filename;
    }
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
