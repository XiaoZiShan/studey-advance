package studey.advance.datastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 模仿某宝根据权重决定进行最终展示顺序
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public   class MbRelatedWeightResource {

    // 机器学习推荐值 (根据千人千面的用户画像预测)
    private Integer mlRecommended;
    // 曝光价格值 (竞价排名)
    private Integer throughWeight;
    // 热度值 (由某个时间维度的浏览量,收藏数,好评数,复购率计算...)
    private Integer heat;
}