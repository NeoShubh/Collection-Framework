package com.example.Collections.map.weakhashmap.programs;

import java.util.WeakHashMap;

public class ProgramOne {
    public static void main(String [] args) throws InterruptedException {
        WeakHashMap<String,Image> mp = new WeakHashMap<>();
        mp.put(new String("img1"),new Image("PHOTO1"));
        mp.put(new String("img2"),new Image("PHOTO2"));
        System.out.println(mp);
        System.gc(); //we recommended jvm to remove the memory
        System.out.println("important work loading ... ");
        Thread.sleep(10000);
        System.out.println(mp);

    }
}

class Image{
    private String imgName;

    public Image(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imgName='" + imgName + '\'' +
                '}';
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}