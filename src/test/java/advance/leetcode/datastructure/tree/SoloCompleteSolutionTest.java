package advance.leetcode.datastructure.tree;

import org.junit.jupiter.api.Test;
import studey.advance.leetcode.datastructure.enums.PermissionLevelEnum;
import studey.advance.leetcode.datastructure.pojo.PermissionResource;
import studey.advance.leetcode.datastructure.tree.SoloNode;
import studey.advance.leetcode.datastructure.tree.SoloTreeCompleteSolution;
import studey.advance.leetcode.datastructure.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SoloCompleteSolutionTest extends SoloTreeCompleteSolution {

    @Test
    void viewCompleteSoloTree() {
        List<SoloNode> soloList = new ArrayList<>();
        soloList.add(new SoloNode(1, PermissionLevelEnum.PERMISSION_MENU.getCode(),-1,Boolean.TRUE,
            new PermissionResource("A网站运营菜单","/aWebsiteOperation","A网站运营帮助...","a-website-operation","svg")));

        soloList.add(new SoloNode(2, PermissionLevelEnum.PERMISSION_MENU.getCode(),1,Boolean.TRUE,
                new PermissionResource("A统计菜单","/statistics","统计帮助...","statistics","svg")));

        soloList.add(new SoloNode(3, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),2,Boolean.FALSE,
            new PermissionResource("A转换率统计权限","/conversionRate","转换率帮助...","conversion-rate","png")));
        soloList.add(new SoloNode(4, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),2, Boolean.FALSE,
            new PermissionResource("A曝光率统计权限","/exposureRate","曝光率帮助...","exposure-rate","png")));

        soloList.add(new SoloNode(5, PermissionLevelEnum.PERMISSION_MENU.getCode(),-1,Boolean.TRUE,
            new PermissionResource("资金总账管理菜单","/fundsManagement","资金总账帮助...","funds-management","svg")));
        soloList.add(new SoloNode(6, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),5,Boolean.FALSE,
            new PermissionResource("银行对账权限","/bankReconciliation","银行对账帮助...","bank-reconciliation","svg")));


        List<SoloNode> soloTree = this.viewCompleteSoloTree(soloList);
        System.out.println(JsonUtil.toJsonPretty(soloTree));
    }
}
