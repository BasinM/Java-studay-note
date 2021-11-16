package com;

import java.util.ArrayList;
import java.util.Scanner;

public class StudenManager {
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<>();


        for (; ; ) {
            System.out.println("--------学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    addStudent(array);
                    break;
                case 2:
                    removeStudent(array);
                    break;
                case 3:
                    setStudent(array);
                    break;
                case 4:

                    chaStudent(array);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("退出学生管理系统");
                    System.exit(0);
            }

        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        //为了让sid在while循环外也可以被访问
        String sid;

        while (true) {
            System.out.println("请输入学号");
            sid = sc.nextLine();
            //调用方法查看学号是否相同
            boolean jc = tonSid(array, sid);

            if (jc) {
                System.out.println("系统内已存在该学号，请重新输入");

            } else {
                break;
            }
        }

        System.out.println("请输入姓名");
        String name = sc.nextLine();
        System.out.println("请输入年龄");
        String age = sc.nextLine();
        System.out.println("请输入出生地");
        String address = sc.nextLine();

        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

        System.out.println("添加成功");
        System.out.println("学号\t姓名\t年龄\t出生地");
        System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
        System.out.println();
    }

    public static void removeStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要删除学生的学号");
        String sid = sc.nextLine();
        int index = -1;


        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);

            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("信息有误，请重新输入");
        } else {
            Student s = array.get(index);
            array.remove(index);

            System.out.println("删除成功");
            System.out.println("学号\t姓名\t年龄\t出生地");
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
            System.out.println();

        }
    }

    public static void setStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要修改学生的学号");
        String csid = sc.nextLine();

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);

            if (s.getSid().equals(csid)) {

                System.out.println("请输入学号");
                String sid = sc.nextLine();
                System.out.println("请输入姓名");
                String name = sc.nextLine();
                System.out.println("请输入年龄");
                String age = sc.nextLine();
                System.out.println("请输入出生地");
                String address = sc.nextLine();

                s.setSid(sid);
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);

                array.set(i, s);

                System.out.println("修改成功");
                System.out.println("学号\t姓名\t年龄\t出生地");
                System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
                System.out.println();
            }
        }
    }

    public static void chaStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加后再查询");
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println("学号\t姓名\t年龄\t出生地");
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());

        }
    }

    public static boolean tonSid(ArrayList<Student> array, String sid) {

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                return true;
            }
        }
        return false;
    }
}



















