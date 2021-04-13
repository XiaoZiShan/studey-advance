package studey.advance.datastructure.pojo;

import lombok.Data;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 模仿某宝根据权重决定进行最终展示顺序
 */
@Data
public class TbRelatedWeightResource {

    // 机器学习推荐数 (根据千人千面的用户画像预测)
    private Integer mlRecommended;
    // 热度数 (由某个时间维度的浏览量,收藏数,好评数,复购率计算...)
    private Integer heat;
    // 同类排行数
    private Integer similarRankings;
    // 直通车曝光价格数 (竞价排名)
    private Integer throughWeight;
}