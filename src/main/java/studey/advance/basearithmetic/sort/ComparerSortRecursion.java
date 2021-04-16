package studey.advance.basearithmetic.sort;

import studey.advance.datastructure.pojo.MbRelatedWeightResource;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by 分别使用以下两种比较器接口进行元素比较排序
 *
 * @see java.lang.Comparable 该后缀 -able 表明该对象只能用于同一类型之间比较
 * @see java.util.Comparator 该后缀 -or   表明该对象可以用于不同类型之间比较
 */
public class ComparerSortRecursion {

    public static class RelatedWeightComparable extends MbRelatedWeightResource implements Comparable<MbRelatedWeightResource> {

        public RelatedWeightComparable(Integer mlRecommended, Integer throughWeight, Integer heat) {
            super(mlRecommended, throughWeight, heat);
        }

        /**
         * 根据规则进行排序
         *
         * @param o 与当前对象比较的同类元素
         * @return 比较结果 小于返回 -1; 等于返回 0; 大于返回 1;
         */
        @Override
        public int compareTo(MbRelatedWeightResource o) {

            /* 使用卫语句保持代码整洁 */

            // 先比较 千人千面推荐值
            if (!Objects.equals(this.getMlRecommended(), o.getMlRecommended())) {
                return this.getMlRecommended() > o.getMlRecommended() ? 1 : -1;
            }

            // 如果曝光价格值相等再比较
            if (!Objects.equals(this.getThroughWeight(), o.getThroughWeight())) {
                return this.getThroughWeight() > o.getThroughWeight() ? 1 : -1;
            }

            // 如果推荐值相等再比较曝光价格值
            if (!Objects.equals(this.getHeat(), o.getHeat())) {
                return this.getHeat() > o.getHeat() ? 1 : -1;
            }

            return 0;
        }
    }

    public static class RelatedWeightComparator implements Comparator<MbRelatedWeightResource> {

        /**
         * 根据规则进行排序
         *
         * @param o1 泛型对象1
         * @param o2 泛型对象2
         * @return 比较结果 小于返回 -1; 等于返回 0; 大于返回 1;
         */
        @Override
        public int compare(MbRelatedWeightResource o1, MbRelatedWeightResource o2) {
            // 先比较 千人千面推荐值
            if (!Objects.equals(o1.getMlRecommended(), o2.getMlRecommended())) {
                return o1.getMlRecommended() > o2.getMlRecommended() ? 1 : -1;
            }

            // 如果曝光价格值相等再比较
            if (!Objects.equals(o1.getThroughWeight(), o2.getThroughWeight())) {
                return o1.getThroughWeight() > o2.getThroughWeight() ? 1 : -1;
            }

            // 如果推荐值相等再比较曝光价格值
            if (!Objects.equals(o1.getHeat(), o2.getHeat())) {
                return o1.getHeat() > o2.getHeat() ? 1 : -1;
            }

            return 0;
        }

        @Override
        public Comparator<MbRelatedWeightResource> reversed() {
            return Collections.reverseOrder(this);
        }
    }
}