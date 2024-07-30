package org.example;

import java.util.Scanner;

/**
 * @author linqf
 * @description
 * @date 2024-07-25
 */
public class LongestLegalExpression {
    /**
     * 最长合法表达式
     *
     * 题目描述：
     * 提取字符串中的最长合法简单数学表达式字符串长度最长的，并计算表达式的值。如果没有返回 0，
     * 简单数学表达式只能包含以下内容
     * 1. 数字（0-9）
     * 2. 运算符（+ - * ）
     * 说明：
     * 1. 所有数字，计算结果都不超过long
     * 2. 如果有多个长度一样的，请返回第一个表达式的结果
     * 3. 数学表达式，必须是最长的，合法的
     * 4. 操作符不能连续出现，连续出现不合法
     *
     * 输入描述：
     * 字符串
     *
     * 输出描述：
     * 表达式值
     */
    public static void getExpressionAndCalculate() {
        String expression = getExpression();
        String result = calculateExpression(expression);
        System.out.println(result);
    }

    /**
     * todo
     * @param expression
     * @return
     */
    private static String calculateExpression(String expression) {
        return "";
    }

    private static String getExpression() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //记录表达式
        StringBuilder ex = new StringBuilder();
        String temp = "";
        //当前索引
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                if (index == -1) {
                    ex.append(c);
                    index = i;
                } else {
                    //判断前面是否是操作符
                    char pre = ex.charAt(ex.length() - 1);
                    if (pre == '+' || pre == '-' || pre == '*' || (pre <= '9' && pre >= '0')) {
                        ex.append(c);
                        index = i;
                    } else {
                        index = -1;
                        ex = new StringBuilder();
                    }
                    if (ex.toString().length() > temp.length()) {
                        temp = ex.toString();
                    }
                }
            } else if (c == '+' || c == '-' || c == '*') {
                if (index != -1) {
                    //判断前后是否是数字
                    char pre = ex.charAt(ex.length() - 1);
                    if (i + 1 < str.length()) {
                        char next = str.charAt(i + 1);
                        if ((pre <= '9' && pre >= '0') && (next <= '9' && next >= '0')) {
                            ex.append(c);
                            index = i;
                        } else {
                            ex = new StringBuilder();
                            index = -1;
                        }
                    } else {
                        if (pre <= '9' && pre >= '0') {
                            ex.append(c);
                            index = i;
                        } else {
                            ex = new StringBuilder();
                            index = -1;
                        }
                    }
                }

                if (ex.toString().length() > temp.length()) {
                    temp = ex.toString();
                }
            }
        }
        //输出表达式
        System.out.println(temp);
        return temp;
    }
}
