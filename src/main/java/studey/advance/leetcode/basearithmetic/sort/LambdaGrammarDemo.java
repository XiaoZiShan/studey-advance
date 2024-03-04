package studey.advance.leetcode.basearithmetic.sort;

import studey.advance.leetcode.datastructure.utils.JsonUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 使用 lambda 语法操作数据
 */
public class LambdaGrammarDemo extends ComparerSortRecursion {

    public static void main(String[] args) {

        // 数据最终结果类型 list or map or set

        // jdk8 之前
        // 对list 进行排序
        List<RelatedWeightComparable> compareToList = new ArrayList<>();
        compareToList.add(new RelatedWeightComparable(101, 1, 1));
        compareToList.add(new RelatedWeightComparable(100, 50, 20));
        compareToList.add(new RelatedWeightComparable(100, 51, 20));
        compareToList.add(new RelatedWeightComparable(100, 51, 21));
        // 调用比较器进行排序
        compareToList.sort(new ComparerSortRecursion.RelatedWeightComparator().reversed());

        // 获取字段组成list
        List<String> strings = new ArrayList<String>();
        for (RelatedWeightComparable relatedWeightComparable : compareToList) {
            strings.add(relatedWeightComparable.getThroughWeight().toString());
        }
        // 只要前3个参数
        List<String> stringx = new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            stringx.add(strings.get(i));
        }
        System.out.println(JsonUtil.toJson(stringx));
        Set sf = new HashSet<>(stringx);

        // 再转成map ，回到第一步，麻烦


        // java8 lambda 表达式
        compareToList.sort(RelatedWeightComparable::compareTo);

        JsonUtil.toJson(compareToList.stream().sorted(Comparator.comparing(RelatedWeightComparable::getHeat).thenComparing(RelatedWeightComparable::getMlRecommended))
            .map(RelatedWeightComparable::getThroughWeight).limit(3).collect(Collectors.toList()));

        System.out.println(
            JsonUtil.toJson(compareToList.stream().sorted(Comparator.comparing(RelatedWeightComparable::getHeat).thenComparing(RelatedWeightComparable::getMlRecommended)).
                limit(3).collect(Collectors.toMap(RelatedWeightComparable::getThroughWeight, RelatedWeightComparable::getHeat))));

        compareToList.forEach(v -> {
            v.setHeat(1);
            v.setThroughWeight(0);
        });

        System.out.println(JsonUtil.toJson(compareToList.stream().map(v -> {
            v.setMlRecommended(9);
            v.setHeat(1);
            return v;
        }).collect(Collectors.toList())));
    }
}
