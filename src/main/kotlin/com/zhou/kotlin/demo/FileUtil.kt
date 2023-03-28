package com.zhou.kotlin.demo

import java.io.File


fun main() {
 val dirString2 = "/Users/zhoujianbiao/Downloads/software/apktool/playitapk/smali_classes2"
 val dirString3 = "/Users/zhoujianbiao/Downloads/software/apktool/playitapk/smali_classes3"
 val dirString4 = "/Users/zhoujianbiao/Downloads/software/apktool/playitapk/smali_classes4"
    changeName(File(dirString2))
    changeName(File(dirString3))
    changeName(File(dirString4))
}

fun changeName( file: File){
    if (!file.isDirectory) return;
    file.listFiles()?.forEach {
        if (it.isDirectory){
            changeName(it)
        }else if (it.isFile){
            var name = it.path
            if (name.endsWith(".smali")){
               val newName =  name.replace(".smali",".class")
                val newFile = File(newName)
                it.renameTo(newFile)
                println("$newName")
            }
        }
    }
}