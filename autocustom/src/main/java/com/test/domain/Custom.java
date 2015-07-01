package com.test.domain;

import com.test.Constant;
import com.test.util.FileUtils;

import java.io.File;

/**
 * Created by OA on 2015/6/29.
 */
public class Custom implements ICustom{

    public Custom(){

    }

    @Override
    public boolean customIcon() {
        File desImgDir = new File(Constant.APP_DIR + Constant.IMA_DIR + "ic_logo.png");
        File tarImgDir = new File("res/icon/ic_logo.png");
        boolean isDesExist = FileUtils.isFileExist(desImgDir.getAbsolutePath());
        boolean isTarExist = FileUtils.isFileExist(tarImgDir.getAbsolutePath());

        if(isDesExist && isTarExist){
            System.out.println("Des and tar exist");
            FileUtils.deleteFile(desImgDir.getAbsolutePath());
            FileUtils.copyFile(tarImgDir.getAbsolutePath(), desImgDir.getAbsolutePath());
            System.out.println("File copy success");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean customWelcome() {
        File desImgDir = new File(Constant.APP_DIR + Constant.IMA_DIR + "bg_item.png");
        File tarImgDir = new File("res/wel/bg_item.png");
        boolean isDesExist = FileUtils.isFileExist(desImgDir.getAbsolutePath());
        boolean isTarExist = FileUtils.isFileExist(tarImgDir.getAbsolutePath());

        if(isDesExist && isTarExist){
            System.out.println("Des and tar exist");
            FileUtils.deleteFile(desImgDir.getAbsolutePath());
            FileUtils.copyFile(tarImgDir.getAbsolutePath(), desImgDir.getAbsolutePath());
            System.out.println("File copy success");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean customLabel(String label) {
        return false;
    }
}
