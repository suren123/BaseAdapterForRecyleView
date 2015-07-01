package com.test;

import com.test.domain.Custom;
import com.test.domain.ICustom;
import com.test.util.Command;
import com.test.util.FileUtils;

import java.io.File;

public class Main {

    public static void main(String[] args){

        ICustom custom = new Custom();
        custom.customWelcome();

        deleOldVersion();
        String commandStr = "cmd /c start autocustom.bat";
        Command.exeCmd(commandStr);
        checkNewVersion();
    }

    private static void deleOldVersion(){
        File debugVersion = new File(Constant.APP_DIR + Constant.OUT_DIR + "app-debug.apk");
        File unalignedVersion = new File(Constant.APP_DIR + Constant.OUT_DIR + "app-debug-unaligned.apk");
        FileUtils.deleteFile(debugVersion.getAbsolutePath());
        FileUtils.deleteFile(unalignedVersion.getAbsolutePath());
        if(!FileUtils.isFileExist(debugVersion.getAbsolutePath()) &&
                !FileUtils.isFileExist(unalignedVersion.getAbsolutePath())){
            System.out.println("dele old version ok");
        }
    }

    private static void checkNewVersion(){
        File debugVersion = new File(Constant.APP_DIR + Constant.OUT_DIR + "app-debug.apk");
        if(FileUtils.isFileExist(debugVersion.getAbsolutePath())){
            System.out.println("check new version ok");
        }
    }
}
