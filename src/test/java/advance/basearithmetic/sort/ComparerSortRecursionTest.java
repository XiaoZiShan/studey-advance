package advance.basearithmetic.sort;

import org.junit.jupiter.api.Test;
import studey.advance.basearithmetic.sort.ComparerSortRecursion;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;
import studey.advance.datastructure.utils.JsonUtil;

import java.util.ArrayList;
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
    void comparatorCompareTo(){
        List<MbRelatedWeightResource> compareList = new ArrayList<>();
        compareList.add(new MbRelatedWeightResource(101,1,1));
        compareList.add(new MbRelatedWeightResource(100,50,20));
        compareList.add(new MbRelatedWeightResource(100,51,20));
        compareList.add(new MbRelatedWeightResource(100,51,21));
        compareList.sort(new ComparerSortRecursion.RelatedWeightComparator().reversed());
        System.out.println(JsonUtil.toJson(compareList));
    }
    
    
    @Test
    void  childThreadSort() throws InterruptedException {
        List<RelatedWeightComparable> compareToList = new ArrayList<>();
    
        ((Runnable) () -> {
            compareToList.add(new RelatedWeightComparable(101,1,1));
            compareToList.add(new RelatedWeightComparable(100,50,20));
            compareToList.add(new RelatedWeightComparable(100,51,20));
            compareToList.add(new RelatedWeightComparable(100,51,21));
            System.out.println(JsonUtil.toJson(compareToList));
        }).run();
    
        Thread.sleep(111);
        System.out.println(1);
        
    }
    
    
    
}