package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class StudentManagementSystem {
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_PATH = "students.txt";

    public static void main(String[] args) {
        loadFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n学生成绩管理系统");
            System.out.println("1. 录入学生信息");
            System.out.println("2. 显示所有学生信息");
            System.out.println("3. 查询学生成绩");
            System.out.println("4. 删除学生信息");
            System.out.println("5. 统计班级成绩");
            System.out.println("6. 保存并退出");
            System.out.println("7. 启动图形界面");
            System.out.print("请选择操作（输入数字）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清空换行符

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    queryStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    calculateStatistics();
                    break;
                case 6:
                    saveToFile();
                    System.out.println("数据已保存，程序退出！");
                    return;
                case 7:
                    launchGUI();
                    break;
                default:
                    System.out.println("无效的选项，请重新选择！");
            }
        }
    }

    // 录入学生信息
    private static void addStudent(Scanner scanner) {
        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学生成绩：");
        int score = scanner.nextInt();
        scanner.nextLine(); // 清空换行符
        students.add(new Student(name, score));
        System.out.println("学生信息录入成功！");
    }

    // 显示所有学生信息
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.println("\n学生信息列表：");
        System.out.println("姓名\t成绩");
        for (Student student : students) {
            System.out.println(student.name + "\t" + student.score);
        }
    }

    // 查询学生成绩
    private static void queryStudent(Scanner scanner) {
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
    }

    // 删除学生信息
    private static void deleteStudent(Scanner scanner) {
        System.out.print("请输入要删除的学生姓名：");
        String deleteName = scanner.nextLine();
        boolean removed = students.removeIf(student -> student.name.equals(deleteName));
        if (removed) {
            System.out.println("学生 " + deleteName + " 已成功删除！");
        } else {
            System.out.println("未找到该学生！");
        }
    }

    // 统计班级成绩
    private static void calculateStatistics() {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        for (Student student : students) {
            total += student.score;
            if (student.score > highest) highest = student.score;
            if (student.score < lowest) lowest = student.score;
        }
        double average = (double) total / students.size();
        System.out.println("班级总成绩：" + total);
        System.out.println("班级平均成绩：" + average);
        System.out.println("班级最高分：" + highest);
        System.out.println("班级最低分：" + lowest);
    }

    // 保存数据到文件
    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.name + "," + student.score);
                writer.newLine();
            }
            System.out.println("数据已成功保存到文件！");
        } catch (IOException e) {
            System.out.println("保存数据失败：" + e.getMessage());
        }
    }

    // 从文件加载数据
    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    students.add(new Student(parts[0], Integer.parseInt(parts[1])));
                }
            }
            System.out.println("数据已成功从文件加载！");
        } catch (FileNotFoundException e) {
            System.out.println("未找到数据文件，加载失败！");
        } catch (IOException e) {
            System.out.println("加载数据失败：" + e.getMessage());
        }
    }

    // 启动图形界面
    private static void launchGUI() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("学生成绩管理系统");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea textArea = new JTextArea();
            for (Student student : students) {
                textArea.append("姓名：" + student.name + " 成绩：" + student.score + "\n");
            }
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane);

            frame.setVisible(true);
        });
    }
}
