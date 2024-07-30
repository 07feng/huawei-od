package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author linqf
 * @description
 * @date 2024-07-29
 */
public class OpenSourceProjectHotnessRanking {

    /**
     * 开源项目热度榜单
     * 题目描述：
     * 某个开源社区希望将最近热度比较高的开源项目出一个榜单，推荐给社区里面的开发者。
     * 对于每个开源项目，开发者可以进行关注（watch）、收藏（star）、fork、提issue、提交合并请求（MR）等。
     * 数据库里面统计了每个开源项目关注、收藏、fork、issue、MR的数量，开源项目的热度根据这5个维度的加权求和进行排序。
     * H = W(watch) x #watch + W(star) x #star + W(fork) x #fork + W(issue) x #issue + W(mr) x #mr
     * H 表示热度值
     * W(watch)、W(star)、W(fork)、W(issue)、W(mr) 分别表示5个统计维度的权重
     * #watch、#star、#fork、#issue、#mr 分别表示5个统计维度的统计值
     * 榜单按照热度值降序排序，对于热度值相等的，按照项目名字转换为全小写字母后的字典序排序（'a','b','c',...,'x','y','z'）。
     */

    static class Project {
        String name;
        int hot;
    }

    public static void getHotList() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String weights = scanner.nextLine();
        List<Project> projectList = new ArrayList<>();
        String[] weightArr = weights.split(" ");
        for (int i = 0; i < num; i++) {
            Project project = new Project();
            String projectInfo = scanner.nextLine();
            String[] projectInfoArr = projectInfo.split(" ");
            int hot = 0;
            for (int j = 0; j < projectInfoArr.length; j++) {
                if (j == 0) {
                    project.name = projectInfoArr[j];
                    continue;
                }
                hot += Integer.parseInt(weightArr[j - 1]) * Integer.parseInt(projectInfoArr[j]);
            }
            project.hot = hot;
            projectList.add(project);
        }
        projectList.sort((project1, project2) -> {
            if (project1.hot == project2.hot) {
                return project1.name.toLowerCase().compareTo(project2.name.toLowerCase());
            } else {
                return project2.hot - project1.hot;
            }
        });

        for (Project project : projectList) {
            System.out.println(project.name);
        }
    }
}
