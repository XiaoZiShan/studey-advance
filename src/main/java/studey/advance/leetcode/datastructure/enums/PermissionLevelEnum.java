package studey.advance.leetcode.datastructure.enums;

/**
 * 权限的层级关系Enum
 */
public enum PermissionLevelEnum implements  BasicEnum {
    PERMISSION_MENU(1, "权限菜单"),
    FINE_GRIT_PERMISSION(2, "细粒度权限");

	private Integer code;
	private String description;

	PermissionLevelEnum(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
