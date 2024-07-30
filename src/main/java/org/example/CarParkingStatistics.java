package org.example;

import java.util.Scanner;

/**
 * @author linqf
 * @description
 * @date 2024-07-25
 */
public class CarParkingStatistics {

    /**
     * 停车场车辆统计
     *
     * 题目描述：
     * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
     * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
     * 统计停车场最少可以停多少辆车，返回具体的数目。
     *
     * 输入描述：
     * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
     *
     * 输出描述：
     * 整型数字字符串，表示最少停车数目。
     */
    public static void statistics() {
        Scanner scanner = new Scanner(System.in);
        String chars = scanner.nextLine();
        chars = chars.replaceAll(",", "");
        //0作为结束符号，防止都是1的情况
        StringBuilder sb = new StringBuilder(chars).append('0');
        chars = sb.toString();
        int total = 0;
        int seriesOne = 0;
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (c == '1') {
                seriesOne = seriesOne + 1;
            }
            //遇到0统计前面的车辆数
            if (c == '0') {
                int count = countBySeriesOne(seriesOne);
                total += count;
                seriesOne = 0;
            }
        }
        System.out.println(total);
    }

    private static int countBySeriesOne(int seriesOne) {
        int count = 0;
        if (seriesOne == 0) {
            return count;
        }
        if (seriesOne > 3) {
            count = seriesOne / 3;
            int remainder = seriesOne % 3;
            if (remainder != 0) {
                count = count + 1;
            }
        } else {
            count = 1;
        }
        return count;
    }
}
