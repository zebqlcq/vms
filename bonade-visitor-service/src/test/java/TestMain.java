import com.alibaba.fastjson.JSON;
import com.bonade.visitor.domain.entity.RoleAccessApprovalPermission;
import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.PermissionType;
import com.bonade.visitor.domain.vo.AccessApprovalPermissionVo;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {
        List<RoleAccessApprovalPermission> permissionList = new ArrayList<>();
        RoleAccessApprovalPermission r1 = new RoleAccessApprovalPermission();
        r1.setPermissionType(PermissionType.CHECKINOUTDOOR);
        r1.setPermissionRange(PermissionRange.REGION);
        r1.setRangeId(1L);
        permissionList.add(r1);
        RoleAccessApprovalPermission r2 = new RoleAccessApprovalPermission();
        r2.setPermissionType(PermissionType.CHECKINOUTDOOR);
        r2.setPermissionRange(PermissionRange.REGION);
        r2.setRangeId(2L);
        permissionList.add(r2);
        RoleAccessApprovalPermission r3 = new RoleAccessApprovalPermission();
        r3.setPermissionType(PermissionType.CHECKINOUTDOOR);
        r3.setPermissionRange(PermissionRange.REGION);
        r3.setRangeId(3L);
        permissionList.add(r3);

        RoleAccessApprovalPermission r4 = new RoleAccessApprovalPermission();
        r4.setPermissionType(PermissionType.CHECKINOUTDOOR);
        r4.setPermissionRange(PermissionRange.DATETIME);
        r4.setOpenTimeStart(LocalTime.parse("08:30:00"));
        r4.setOpenTimeEnd(LocalTime.parse("18:00:00"));
        permissionList.add(r4);
        List<AccessApprovalPermissionVo> accessApprovalPermissionList = new ArrayList<>();

        Map<String, List<RoleAccessApprovalPermission>> map = permissionList.stream().collect(Collectors.groupingBy(it -> it.getPermissionType() + ":" + it.getPermissionRange()));

        for(String key : map.keySet()){
            List<RoleAccessApprovalPermission> permissions = map.get(key);
            if(permissions.size() > 0){
                RoleAccessApprovalPermission permission = permissions.get(0);
                AccessApprovalPermissionVo permissionVo = new AccessApprovalPermissionVo();
                BeanUtils.copyProperties(permission, permissionVo);

                if(null != permission.getRangeId()){
                    List<Long> rangeIdList = permissions.stream().map(RoleAccessApprovalPermission::getRangeId).collect(Collectors.toList());
                    Long[] rangeIds = new Long[rangeIdList.size()];
                    rangeIdList.toArray(rangeIds);
                    permissionVo.setRangeIds(rangeIds);
                }

                accessApprovalPermissionList.add(permissionVo);
            }
        }
        System.out.println(JSON.toJSONString(accessApprovalPermissionList));

        AccessApprovalPermissionVo vo = accessApprovalPermissionList.stream().filter(it -> PermissionRange.REGION.equals(it.getPermissionRange())).findFirst().get();
        System.out.println(StringUtil.join(vo.getRangeIds(), ","));
    }
}
