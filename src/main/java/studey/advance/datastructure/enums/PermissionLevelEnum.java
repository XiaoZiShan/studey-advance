package studey.advance.datastructure.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限的层级关系Enum
 */
public enum PermissionLevelEnum implements java.studey.advance.DataStructure.Enums.BasicEnum {
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

	public static Map<Integer, String> getAllEnum() {
		Map<Integer, String> map = new HashMap<>();
		PermissionLevelEnum[] allEnums = values();
		for (PermissionLevelEnum enumObject : allEnums) {
			map.put(enumObject.getCode(), enumObject.getDescription());
		}
		return map;
	}


	public static PermissionLevelEnum getEnumByCode(Integer code) {
		if (null == code) {
			return null;
		}
		PermissionLevelEnum[] allEnums = values();
		for (PermissionLevelEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject;
			}
		}
		return null;
	}

	public static String getDescriptionByCode(Integer code) {
		if (null == code) {
			return null;
		}
		PermissionLevelEnum[] allEnums = values();
		for (PermissionLevelEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject.getDescription();
			}
		}
		return null;
	}

	public static String getNameByCode(Integer code) {
		if (null == code) {
			return null;
		}
		PermissionLevelEnum[] allEnums = values();
		for (PermissionLevelEnum enumObject : allEnums) {
			if (enumObject.getCode().equals(code)) {
				return enumObject.name();
			}
		}
		return null;
	}
}
