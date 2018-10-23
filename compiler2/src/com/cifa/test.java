package com.cifa;

import java.io.IOException;

import java.util.List;

public class test {
    public static void main(String[] args) throws Exception {
        Main m=new Main();
        List<String>strList= m.readTestFile("D:/test.txt");
        String [] list=null;
        for(int i=1;i<strList.size();i++){
            System.out.println("进行第"+(i)+"行的判断：");
            list= m.analyze(strList.get(i)).toArray(new String[0]);
            m.Sort(list);
            System.out.println("\n");
        }
    }
}
