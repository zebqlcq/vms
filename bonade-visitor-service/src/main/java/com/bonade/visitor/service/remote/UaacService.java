package com.bonade.visitor.service.remote;

import java.util.List;

import com.bonade.visitor.domain.remote.*;
import org.spin.common.feign.AbstractFallback;
import org.spin.common.throwable.BizException;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.spin.common.web.annotation.PutApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bonade.visitor.domain.dto.EmpDetailViewDto;
import com.bonade.visitor.domain.dto.UserViewDto;
import com.bonade.visitor.domain.vo.ApprovalOperationVo;
import com.bonade.visitor.domain.vo.ApprovalSubmitVo;
import com.bonade.visitor.domain.vo.EmployeeOrganViewVo;
import com.bonade.visitor.domain.vo.EmployeeQueryVo;
import com.bonade.visitor.domain.vo.EntSimpleFormVo;
import com.bonade.visitor.domain.vo.EnterpriseTreeVo;

import feign.hystrix.FallbackFactory;

/**
 *
 * @ClassName: UaacService
 * @Description:UAAC远程服务
 * @author: lcq
 * @date: 2019年12月20日 下午2:33:15
 * @version 1.0
 */
@FeignClient(name = "BONADE-UAAC", fallbackFactory = UaacServiceFallbackFactory.class,url="http://192.168.12.26:11000")
public interface UaacService {

    @PostMapping(value = "v1/auth/decrypt")
    List<String> decrypt(@RequestBody List<String> encoded);

	@PostApi(value = "/v2/approvalFlow/submitApproval")
	String submitApproval(@RequestBody ApprovalSubmitVo vo);


	@PostApi(value = "/v1/approvalFlow/updateApprovalStatus")
	String updateApprovalStatus(@RequestBody ApprovalOperationVo vo);

    @GetApi(value = "/v1/employee/listByEnterprise")
    List<EmployeeViewVo> getEmployee();

    //集团查询企业树形列表
    @GetApi(value = "/v1/enterprise/groupList/{id}")
    EnterpriseTreeVo groupList(@PathVariable("id") Long id);

    //集团查询企业树形列表
    @GetApi(value = "/v1/employee/listUserOrgan")
    List<EmployeeOrganViewVo> listUserOrgan(@RequestBody EmployeeQueryVo query);

    //获取用户详情
    @PostApi(value = "/v1/user/detail")
    UserViewVo userDetail(@RequestBody UserQueryVo query);

    //注册用户
    @PostApi(value = "/v1/user/autoRegister")
    void autoRegister(@RequestBody UserRegisterFormVo userRegisterFormVo);

    //注册企业员工
    @PostApi(value = "/v1/employee/register")
    EmpViewVo employeeRegister(@RequestBody EmpFormVo employeeFormVo);

    //查询员工信息
    @PostApi(value = "/v1/employee/detailByUser")
    EmployeeViewVo detailByUser(@RequestBody EmpUserQueryVo employeeFormVo);

    //简单企业注册
    @PostApi(value = "/v1/enterprise/simpleRegister")
    EnterpriseViewVo simpleRegister(@Validated @RequestBody EntSimpleFormVo form);

    @GetApi(value = "/v1/employee/detail/{enterpriseId}/{phone}")
    EmpViewVo getByUser(@PathVariable("enterpriseId") Long enterpriseId,@PathVariable("phone") String phone);

    //集团查询企业树形列表
    @GetApi(value = "/v1/enterprise/detail/{id}")
    EnterpriseViewVo getEntDetail(@PathVariable("id") Long id);

    //获取用户详情
    @GetApi(value = "/v1/user/detail/{id}")
    UserViewDto getUserDetail(@PathVariable("id") Long id);

    //获取岗位、部门
    @GetApi(value = "/v1/personal/employee")
    EmpDetailViewDto employee();

    //查询员工列表
    @PostApi(value = "/v1/employee/listEmp")
    List<EmpViewVo> listEmp(@RequestBody EmpQueryVo query);

    //通过企业名称查询企业
    @GetApi(value = "/v1/enterprise/detailByName/{name}")
    EnterpriseViewVo getEmployeeDetailByName(@PathVariable("name") String name);//通过企业名称查询企业

    //查询企业详情（企业ID）
    @GetApi(value = "/v1/enterprise/detail/{id}")
    EnterpriseViewVo getEnterpriseDetailById(@PathVariable("id") Long name);

    //编辑企业
    @PutApi(value = "/v1/enterprise/editSimple")
    EnterpriseViewVo editSimple(@RequestBody EnterpriseSimpleEditVo query);
}

@Component
class UaacServiceFallbackFactory implements FallbackFactory<UaacService> {

	@Override
	public UaacService create(Throwable cause) {
		return new UaacServiceFallback(cause);
	}

	static class UaacServiceFallback extends AbstractFallback implements UaacService {

		UaacServiceFallback(Throwable cause) {
			super(cause);
		}

        @Override
        public List<String> decrypt(List<String> encoded) {
            handleKnownException();
            throw new BizException("远程调用失败，密文解密失败");
        }

        @Override
		public String submitApproval(ApprovalSubmitVo vo) {
			handleKnownException();
            throw new BizException("远程调用失败，提交审批失败");
		}

		@Override
        public String updateApprovalStatus(ApprovalOperationVo vo) {
            handleKnownException();
            throw new BizException("远程调用失败，审批失败");
        }

        @Override
        public List<EmployeeViewVo> getEmployee(){
            handleKnownException();
            throw new BizException("远程调用失败，获取员工信息失败");
        }

        @Override
        public EnterpriseTreeVo groupList(Long id) {
            handleKnownException();
            throw new BizException("远程调用失败，集团查询企业树形列表失败");
        }

        @Override
        public List<EmployeeOrganViewVo> listUserOrgan(EmployeeQueryVo query) {
            handleKnownException();
            throw new BizException("远程调用失败，查询员工相关机构信息失败");
        }

        @Override
        public UserViewVo userDetail(@RequestBody UserQueryVo query){
            handleKnownException();
            throw new BizException("远程调用失败，查询用户详情信息失败");
        }

        @Override
        public void autoRegister(@RequestBody UserRegisterFormVo userRegisterFormVo){
            handleKnownException();
            throw new BizException("远程调用失败，注册用户失败");
        }

        @Override
        public EmpViewVo employeeRegister(@RequestBody EmpFormVo employeeFormVo){
            handleKnownException();
            throw new BizException("远程调用失败，注册企业员工失败");
        }

        @Override
        public EmployeeViewVo detailByUser(@RequestBody EmpUserQueryVo employeeFormVo){
            handleKnownException();
            throw new BizException("远程调用失败，获取用户信息");
        }

        @Override
        public EnterpriseViewVo simpleRegister(@Validated @RequestBody EntSimpleFormVo form){
            handleKnownException();
            throw new BizException("远程调用失败，注册企业");
        }

        @Override
        public EmpViewVo getByUser(@PathVariable Long enterpriseId,@PathVariable String phone){
            handleKnownException();
            throw new BizException("远程调用失败，获取员工用户信息");
        }

        @Override
        public EnterpriseViewVo getEntDetail(@PathVariable("id") Long id){
            handleKnownException();
            throw new BizException("远程调用失败，获取企业详情");
        }

		@Override
		public UserViewDto getUserDetail(Long id) {
			handleKnownException();
            throw new BizException("远程调用失败，获取用户详情失败");
		}

		@Override
		public EmpDetailViewDto employee() {
			handleKnownException();
            throw new BizException("远程调用失败，获取企业员工详细信息失败");
		}

        @Override
		public List<EmpViewVo> listEmp(@RequestBody EmpQueryVo query){
            handleKnownException();
            throw new BizException("远程调用失败，查询员工列表失败");
        }
        @Override
        public EnterpriseViewVo getEmployeeDetailByName(String name){
            handleKnownException();
            throw new BizException("远程调用失败，查询企业失败");
        }
        @Override
        public EnterpriseViewVo getEnterpriseDetailById(@PathVariable("id") Long name){
            handleKnownException();
            throw new BizException("远程调用失败，查询企业失败");
        }
        @Override
        public EnterpriseViewVo editSimple(@RequestBody EnterpriseSimpleEditVo query){
            handleKnownException();
            throw new BizException("远程调用失败，编辑企业失败");
        }
    }

}
