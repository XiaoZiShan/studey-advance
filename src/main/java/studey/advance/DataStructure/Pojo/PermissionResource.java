package java.studey.advance.DataStructure.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 权限相关的前端对应展示资源
 */
@Data
@AllArgsConstructor
public class PermissionResource {
    private String name;
    private String routePath;
    private String helpDescription;
    private String iconName;
    private String iconType;
}