package advance.leetcode.basearithmetic.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studey.advance.leetcode.basearithmetic.sort.ComparerSortRecursion;
import studey.advance.leetcode.datastructure.pojo.MbRelatedWeightResource;
import studey.advance.leetcode.datastructure.utils.JsonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 分别使用以下两种比较器接口进行元素比较排序的单元测试
 */
class ComparerSortRecursionTest extends ComparerSortRecursion {

    @Test
    @DisplayName("根据内部比较器从大到小排序")
    void comparableCompareTo() {

        ArrayList<RelatedWeightComparable> comparableToList = new ArrayList<>();
        comparableToList.add(new RelatedWeightComparable(100, 51, 20));
        comparableToList.add(new RelatedWeightComparable(101, 1, 1));
        comparableToList.add(new RelatedWeightComparable(100, 50, 20));
        comparableToList.add(new RelatedWeightComparable(100, 51, 21));
        Collections.sort(comparableToList);
        System.out.println(JsonUtil.toJson(comparableToList));
    }

    @Test
    @DisplayName("根据外部比较器从大到小排序")
    void comparatorCompareTo() {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        comparatorList.sort(new RelatedWeightComparator());
        System.out.println(JsonUtil.toJson(comparatorList));
    }

    @Test
    @DisplayName("根据lambda比较器从大到小排序")
    void comparatorChildListSort() throws InterruptedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));

        for (MbRelatedWeightResource relatedWeightComparable : comparatorList) {
            // 迭代器和增强for循环遍历时排序会 ConcurrentModificationException
            // compareToList.sort(new ComparerSortRecursion.RelatedWeightComparator());
            // lambda 排序则能运行
            comparatorList = comparatorList.stream().sorted(Comparator.comparing(MbRelatedWeightResource::getMlRecommended)
                .thenComparing(MbRelatedWeightResource::getThroughWeight)
                .thenComparing(MbRelatedWeightResource::getHeat).reversed()).collect(Collectors.toList());
        }
        System.out.println(JsonUtil.toJson(comparatorList));
    }
}
