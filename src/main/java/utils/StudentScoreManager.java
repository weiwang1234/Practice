package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentScoreManager {
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n学生成绩管理系统");
            System.out.println("1. 录入学生信息");
            System.out.println("2. 显示所有学生信息");
            System.out.println("3. 查询学生成绩");
            System.out.println("4. 统计班级成绩");
            System.out.println("5. 退出程序");
            System.out.print("请选择操作（输入数字）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清空换行符

            switch (choice) {
                case 1:
                    System.out.print("请输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.print("请输入学生成绩：");
                    int score = scanner.nextInt();
                    scanner.nextLine(); // 清空换行符
                    students.add(new Student(name, score));
                    System.out.println("学生信息录入成功！");
                    break;

                case 2:
                    System.out.println("\n学生信息列表：");
                    System.out.println("姓名\t成绩");
                    for (Student student : students) {
                        System.out.println(student.name + "\t" + student.score);
                    }
                    break;

                case 3:
                    System.out.print("请输入要查询的学生姓名：");
                    String queryName = scanner.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.name.equals(queryName)) {
                            System.out.println("学生 " + queryName + " 的成绩是：" + student.score);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("未找到该学生！");
                    }
                    break;

                case 4:
                    int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
                    for (Student student : students) {
                        total += student.score;
                        if (student.score > highest) highest = student.score;
                        if (student.score < lowest) lowest = student.score;
                    }
                    double average = students.isEmpty() ? 0 : (double) total / students.size();
                    System.out.println("班级总成绩：" + total);
                    System.out.println("班级平均成绩：" + average);
                    System.out.println("班级最高分：" + highest);
                    System.out.println("班级最低分：" + lowest);
                    break;

                case 5:
                    System.out.println("程序退出，再见！");
                    return;

                default:
                    System.out.println("无效的选项，请重新选择！");
            }
        }
    }
}
