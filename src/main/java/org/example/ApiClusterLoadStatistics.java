package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author linqf
 * @description
 * @date 2024-07-25
 */
public class ApiClusterLoadStatistics {
    /**
     * Api集群负载统计
     *
     * 题目描述：
     * 某个产品的RESTful API集合部署在服务器集群的多个节点上，近期对客户端访问日志进行了采集，
     * 需要统计各个API的访问频次，根据热点信息在服务器节点之间做负载均衡，现在需要实现热点信息统计查询功能。
     * RESTful API是由多个层级构成，层级之间使用 / 连接，如 /A/B/C/D 这个地址，A属于第一级，B属于第二级，C属于第三级，D属于第四级。
     * 现在负载均衡模块需要知道给定层级上某个名字出现的频次，未出现过用0表示，实现这个功能。
     *
     * 输入描述：
     * 第一行为N，表示访问历史日志的条数，0 ＜ N ≤ 100。
     * 接下来N行，每一行为一个RESTful API的URL地址，约束地址中仅包含英文字母和连接符 / ，最大层级为10，每层级字符串最大长度为10。
     * 最后一行为层级L和要查询的关键字。
     * 输出描述：
     * 输出给定层级上，关键字出现的频次，使用完全匹配方式（大小写敏感）。
     */
    public static void statistics() {
        Scanner scanner = new Scanner(System.in);
        //api日志数量
        int logCount = scanner.nextInt();
        scanner.nextLine();
        List<String> apiPathList = new ArrayList<>();
        for (int i = 0; i < logCount; i++) {
            String apiPath = scanner.nextLine();
            apiPathList.add(apiPath);
        }
        String searchCondition = scanner.nextLine();
        String[] searchArr = searchCondition.split(" ");
        //层级
        int level = Integer.parseInt(searchArr[0]);
        //查询关键字
        String key = searchArr[1];
        int count = 0;
        for (String apiPath : apiPathList) {
            String[] pathArr = apiPath.split("/");
            for (int i = 0; i < pathArr.length; i++) {
                if (i == level && pathArr[i].equals(key)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
