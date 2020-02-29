package com.bonade.visitor.service.remote;

import org.spin.common.feign.AbstractFallback;
import org.spin.common.throwable.BizException;
import org.spin.common.web.annotation.PostApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.bonade.visitor.domain.dto.FileDto;
import com.bonade.visitor.domain.vo.FileFormVo;

import feign.hystrix.FallbackFactory;

/**
 *
 * @ClassName:  AdminService
 * @Description:
 * @author: lcq
 * @date:   2019年12月31日 上午9:10:39
 * @version 1.0
 */
@FeignClient(name = "BONADE-ADMIN", fallbackFactory = AdminServiceFallbackFactory.class,url="http://192.168.12.26:11010")
public interface AdminService {

	@PostApi(value = "/v1/file/uploadByBase64")
	FileDto uploadByBase64(@RequestBody FileFormVo vo);


}

@Component
class AdminServiceFallbackFactory implements FallbackFactory<AdminService> {

	@Override
	public AdminService create(Throwable cause) {
		return new AdminServiceFallback(cause);
	}

	static class AdminServiceFallback extends AbstractFallback implements AdminService {

		AdminServiceFallback(Throwable cause) {
			super(cause);
		}

		@Override
		public FileDto uploadByBase64(FileFormVo vo) {
			handleKnownException();
            throw new BizException("远程调用失败，上传图片失败");
		}
	}
}
