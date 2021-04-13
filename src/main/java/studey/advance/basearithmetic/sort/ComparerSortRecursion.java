package studey.advance.basearithmetic.sort;

import studey.advance.datastructure.pojo.TbRelatedWeightResource;

/**
 * Created by 分别使用以下两种比较器接口进行元素比较排序
 * @see java.lang.Comparable 该后缀 -able 表明该对象只能用于同一类型之间比较
 * @see java.util.Comparator 该后缀 -or   表明该对象可以用于不同类型之间比较
 */
public class ComparerSortRecursion {

    class RelatedWeightComparable extends TbRelatedWeightResource implements Comparable{

        @Override
        public int compareTo(Object o) {

            return 0;
        }
    }
}