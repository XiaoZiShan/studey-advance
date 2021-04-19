package advance.basearithmetic.sort;

import org.junit.jupiter.api.Test;
import studey.advance.basearithmetic.sort.ComparerSortRecursion;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;
import studey.advance.datastructure.utils.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 分别使用以下两种比较器接口进行元素比较排序的单元测试
 */
class ComparerSortRecursionTest extends ComparerSortRecursion {

    @Test
    void comparableCompareTo(){
        List<RelatedWeightComparable> compareToList = new ArrayList<>();
        compareToList.add(new RelatedWeightComparable(101,1,1));
        compareToList.add(new RelatedWeightComparable(100,50,20));
        compareToList.add(new RelatedWeightComparable(100,51,20));
        compareToList.add(new RelatedWeightComparable(100,51,21));
        System.out.println(JsonUtil.toJson(compareToList));
    }

    @Test
    void  comparableChildList() throws InterruptedException {
        List<List<MbRelatedWeightResource>> compareToChildList = new ArrayList<>();
        List<MbRelatedWeightResource> compareToList1 = new ArrayList<>(11);
        compareToList1.add(new RelatedWeightComparable(101,1,1));
        compareToList1.add(new RelatedWeightComparable(100,50,20));
        compareToList1.add(new RelatedWeightComparable(100,51,20));
        compareToList1.add(new RelatedWeightComparable(100,51,21));

        List<MbRelatedWeightResource> comparToList2 = new ArrayList<>(11);
        comparToList2.add(new RelatedWeightComparable(101,1,1));
        comparToList2.add(new RelatedWeightComparable(100,50,20));
        comparToList2.add(new RelatedWeightComparable(100,51,20));
        comparToList2.add(new RelatedWeightComparable(100,51,21));

        compareToChildList.add(compareToList1);
        compareToChildList.add(comparToList2);

        Comparator relatedWeightComparator = new ComparerSortRecursion.RelatedWeightComparator();

        for (List<MbRelatedWeightResource> mbRelatedWeightResources : compareToChildList) {
            Arrays.sort(mbRelatedWeightResources.toArray(),relatedWeightComparator);
           // mbRelatedWeightResources.sort(new ComparerSortRecursion.RelatedWeightComparator().reversed());
        }

        System.out.println(JsonUtil.toJson(compareToChildList));
        // 迭代器和增强for循环遍历时修改会出问题
    }


    @Test
    void comparatorCompareTo(){
        List<MbRelatedWeightResource> compareList = new ArrayList<>();
        compareList.add(new MbRelatedWeightResource(101,1,1));
        compareList.add(new MbRelatedWeightResource(100,50,20));
        compareList.add(new MbRelatedWeightResource(100,51,20));
        compareList.add(new MbRelatedWeightResource(100,51,21));
        compareList.sort(new RelatedWeightComparator());
        System.out.println(JsonUtil.toJson(compareList));
    }




    @Test
    void  comparatorChildListSort() throws InterruptedException {
        List<MbRelatedWeightResource> compareToList = new ArrayList<>(11);
        compareToList.add(new RelatedWeightComparable(101,1,1));
        compareToList.add(new RelatedWeightComparable(100,50,20));
        compareToList.add(new RelatedWeightComparable(100,51,20));
        compareToList.add(new RelatedWeightComparable(100,51,21));

        Comparator relatedWeightComparator = new ComparerSortRecursion.RelatedWeightComparator();

        for (MbRelatedWeightResource relatedWeightComparable : compareToList) {
            //compareToList.sort(new ComparerSortRecursion.RelatedWeightComparator().reversed());
            // Collections.sort(compareToList,relatedWeightComparator);
            // compareToList.sort(new ComparerSortRecursion.RelatedWeightComparator().reversed());
           // compareToList.sort(Comparator.comparing(RelatedWeightComparable::getMlRecommended));
        }
        System.out.println(JsonUtil.toJson(compareToList));
        // 迭代器和增强for循环遍历时修改会出问题
    }

}