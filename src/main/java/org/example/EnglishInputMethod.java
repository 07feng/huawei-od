package org.example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author linqf
 * @description
 * @date 2024-07-25
 */
public class EnglishInputMethod {

    /**
     * 英文输入法
     *
     * 题目描述：
     * 主管期望你来实现英文输入法单词联想功能。需求如下：
     * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，
     * 如果联想不到，请输出用户输入的单词前缀。
     * 注意：
     * 1.英文单词联想时，区分大小写
     * 2.缩略形式如”don’t”，判定为两个单词，”don”和”t”
     * 3.输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
     *
     * 输入描述：
     * 输入为两行。
     * 首行输入一段由英文单词word和标点符号组成的语句str；
     * 接下来一行为一个英文单词前缀pre。
     * 0 < word.length() <= 20
     * 0 < str.length <= 10000
     * 0 < pre <= 20
     *
     * 输入描述：
     * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
     */
    public static void matchSearchKey() {
        Scanner scanner = new Scanner(System.in);
        String series = scanner.nextLine();
        String key = scanner.nextLine();
        Set<String> outSet = new HashSet<>();
        String[] strArr = series.split(" ");
        for (String word : strArr) {
            if (word.contains("'")) {
                String[] wordSplit = word.split("'");
                for (String c : wordSplit) {
                    if (c.startsWith(key)) {
                        outSet.add(c);
                    }
                }
                continue;
            }
            if (word.startsWith(key)) {
                outSet.add(word);
            }
        }
        if (outSet.isEmpty()) {
            outSet.add(key);
        }
        outSet = outSet.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        for (String str : outSet) {
            System.out.print(str + " ");
        }
    }
}
