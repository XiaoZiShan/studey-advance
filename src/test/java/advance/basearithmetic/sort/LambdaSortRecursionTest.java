package advance.basearithmetic.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import studey.advance.basearithmetic.sort.ComparerSortRecursion;
import studey.advance.basearithmetic.sort.LambdaSortRecursion;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;
import studey.advance.datastructure.utils.JsonUtil;

import java.util.ArrayList;

/**
 * Created by 使用 lambda 语法进行元素比较排序的测试用例
 */
@DisplayName("使用 lambda 语法进行元素比较排序的测试用例")
public class LambdaSortRecursionTest extends LambdaSortRecursion {

    @Test
    @DisplayName("实现比较器的排序方式")
    void lambdaSort() {
        ArrayList<MbRelatedWeightResource> comparableToList = new ArrayList<>();
        comparableToList.add(new MbRelatedWeightResource(100, 51, 20));
        comparableToList.add(new MbRelatedWeightResource(101, 1, 1));
        comparableToList.add(new MbRelatedWeightResource(100, 50, 20));
        comparableToList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(JsonUtil.toJson(this.lambdaSort(comparableToList)));
    }


    @Test
    @DisplayName("反转当前集合顺序")
    void lambdaReversalSort() {
        ArrayList<MbRelatedWeightResource> comparableToList = new ArrayList<>();
        comparableToList.add(new MbRelatedWeightResource(100, 51, 20));
        comparableToList.add(new MbRelatedWeightResource(101, 1, 1));
        comparableToList.add(new MbRelatedWeightResource(100, 50, 20));
        comparableToList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(JsonUtil.toJson(this.lambdaReversalSort(comparableToList)));
    }

    @Test
    @DisplayName("lambda 兼容 Comparable")
    void lambdaComparableSort() {
        ArrayList<ComparerSortRecursion.RelatedWeightComparable> comparableToList = new ArrayList<>();
        comparableToList.add(new ComparerSortRecursion.RelatedWeightComparable(100, 51, 20));
        comparableToList.add(new ComparerSortRecursion.RelatedWeightComparable(101, 1, 1));
        comparableToList.add(new ComparerSortRecursion.RelatedWeightComparable(100, 50, 20));
        comparableToList.add(new ComparerSortRecursion.RelatedWeightComparable(100, 51, 21));
        System.out.println(JsonUtil.toJson(this.lambdaComparableSort(comparableToList)));
    }

    @Test
    @DisplayName("lambda 兼容 Comparator")
    void lambdaComparatorSort() {
        ArrayList<MbRelatedWeightResource> comparableToList = new ArrayList<>();
        comparableToList.add(new MbRelatedWeightResource(100, 51, 20));
        comparableToList.add(new MbRelatedWeightResource(101, 1, 1));
        comparableToList.add(new MbRelatedWeightResource(100, 50, 20));
        comparableToList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(JsonUtil.toJson(this.lambdaComparatorSort(comparableToList)));
    }
}