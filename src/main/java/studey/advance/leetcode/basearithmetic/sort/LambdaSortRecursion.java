package studey.advance.leetcode.basearithmetic.sort;

import studey.advance.leetcode.datastructure.pojo.MbRelatedWeightResource;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by 使用 lambda 语法进行元素比较排序
 */
public class LambdaSortRecursion {
    // lambda 实现比较器的排序方式
    public List<MbRelatedWeightResource> lambdaSort(List<MbRelatedWeightResource> mbList) {
        return mbList.stream().sorted(comparing(MbRelatedWeightResource::getMlRecommended)
            .thenComparing(MbRelatedWeightResource::getThroughWeight)
            .thenComparing(MbRelatedWeightResource::getHeat)).collect(Collectors.toList());
    }

    // lambda 反转当前集合顺序
    public List<MbRelatedWeightResource> lambdaReversalSort(List<MbRelatedWeightResource> mbList) {
        return mbList.stream().sorted(comparing(MbRelatedWeightResource::getMlRecommended)
            .thenComparing(MbRelatedWeightResource::getThroughWeight)
            .thenComparing(MbRelatedWeightResource::getHeat).reversed()).collect(Collectors.toList());
    }

    // lambda 兼容 Comparable
    public List<ComparerSortRecursion.RelatedWeightComparable> lambdaComparableSort(List<ComparerSortRecursion.RelatedWeightComparable> mbList) {
        return mbList.stream().sorted(ComparerSortRecursion.RelatedWeightComparable::compareTo).collect(Collectors.toList());
    }

    // lambda 兼容 Comparator
    public List<MbRelatedWeightResource> lambdaComparatorSort(List<MbRelatedWeightResource> mbList) {
        return mbList.stream().
            sorted(comparing(e -> e, new ComparerSortRecursion.RelatedWeightComparator())).collect(Collectors.toList());
    }
}
