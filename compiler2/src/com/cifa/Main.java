package com.cifa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.*;

public class Main {
    static char optSingle[]={'+','-','*','/','<','>'};//单目运算符

    analyse i=new analyse();

    /**

     * 读取一个文件的内容，分行将所有的内容保存到一个list集合中
     * @param filename
     * @return
     * @return
     * @throws IOException
     */

    public  List<String> readTestFile(String filename) throws IOException{

        List<String >list=new ArrayList<String>();
        String fileContent="";
        FileReader fread = new FileReader(filename);
        BufferedReader bf=new BufferedReader(fread);
        String strLine=bf.readLine();
        int i= 0;
        while(strLine!=null){
            System.out.println("第 "+i+" 行算术表达式:"+strLine);
            list.add(strLine);
            strLine=bf.readLine();
            i++;
        }
        bf.close();
        fread.close();
        return list;
    }

    static final String symbol = "+-*/()"; //运算符
    static final String[] priority = {"+-", "*/", "()"}; //运算符优先级

    static Comparator<String> comp = new Comparator<String>() { //运算符比较器
        public int compare(String s1, String s2) {
            int n1=0, n2=0;
            for (int i=0; i<priority.length; i++) {
                if (priority[i].indexOf(s1) >= 0) {n1 = i;}
                if (priority[i].indexOf(s2) >= 0) {n2 = i;}
            }
            return (n1 - n2);
        }
    };

    public static List<String> analyze(String exp) throws Exception{
        if (exp == null) {
            //throw new Exception ("illegal parameter.");
            System.out.println("illegal parameter");
        }
        exp = exp.replaceAll("\\s*", ""); //去掉所有的空格（为了方便中间存在空格算合法）


        List<String> list = new ArrayList<String>();
        List<String> List1 = new ArrayList<String>();//记录数字
        List<String> List2 = new ArrayList<String>();//记录运算符及界符

        Stack<String> sym = new Stack<String>();//判断括号是否成对

        StringBuilder buf = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (symbol.indexOf(c) >= 0) { //如果是运算符
                List2.add(String.valueOf(c));
                if (buf.length() > 0) { //如果有操作数
                    String v = buf.toString();
                    if (! v.matches("\\d+||(\\d+\\.\\d+)")) {//正则表达式判断小数
                     //   throw new Exception ("illegal varaible("+v+").");
                        System.out.println("illegal variable("+v+")");
                    }
                    list.add(v);
                    List1.add(v);
                    buf.delete(0, buf.length());
                }
                if (c == '(') {
                    sym.push(String.valueOf(c));
                } else if (c == ')') {
                    String last = "";
                    while (sym.size() > 0) {
                        last = sym.pop();
                        if (last.equals("(")) {
                            break;
                        } else {
                            list.add(last);
                        }
                    }
                    if (!"(".equals(last)) {
                      //  throw new Exception ("illigal express.");
                        System.out.println("illegal express:LEFT_BRACKET MISSING.");
                        continue;
                    }
                } else if (sym.size() > 0) {
                    String s = String.valueOf(c);
                    String last = sym.peek();
                    if (last.equals("(") || comp.compare(s, last) > 0) {
                        sym.push(s);
                    } else {
                        last = sym.pop();
                        list.add(last);
                        sym.push(s);
                    }
                } else {
                    sym.push(String.valueOf(c));
                }
            } else { //不是运算符则当作操作数（因为已经去除所有空格，这里不再需要判断空格）
                buf.append(c);
            }
        }

        if (buf.length() > 0) {
            list.add(buf.toString());
            List1.add(buf.toString());
        }

        while (sym.size() > 0) {
            String last = sym.pop();
            if ("()".indexOf(last) >= 0) {
                //throw new Exception ("illigal express.");
                System.out.println("illegal express:RIGHT_BRACKED MISSING.");
                continue;
            }
            list.add(last);
        }
        for (int i = 0; i < List2.size() - 1; i++) {
            for (int j = List2.size() - 1; j > i; j--) {
                if (List2.get(j).equals(List2.get(i))) {
                    List2.remove(j);
                }
            }
        }
        System.out.println("参与运算的运算数有：" + List1.toString());
        System.out.println("运算符(含界符)有：" + List2.toString());
        return list;
    }

    /**

     * 根据输入的list进行划分和判断，并将判断的结果输出

     * @param list

     */

    public void Sort(String[] list) throws Exception {
        //map里面的key有word,sortclass
        List<Map> mList=new ArrayList<Map>();
        //获取经过处理的种别和关键字系列集合
        mList=i.GetStringAndSortNum(list);
        for(Map m0:mList){
            String keyword=(String) m0.get("keyword");
            String sortclass=(String) m0.get("sortclass");
            System.out.print("("+sortclass+","+keyword+")   ");
        }
    }
}
