package com.bonade.visitor.service.remote;

import com.bonade.visitor.domain.vo.MailFormVo;
import com.bonade.visitor.domain.vo.SmsTemplateMessageVo;
import feign.hystrix.FallbackFactory;
import org.spin.common.feign.AbstractFallback;
import org.spin.common.throwable.BizException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @ClassName:  MessageService
 * @Description:Message
 * @author: lcq
 * @date:   2019年12月26日 上午9:08:03
 * @version 1.0
 */
@FeignClient(name = "BONADE-MESSAGE", fallbackFactory = MessageServiceFallbackFactory.class,url="http://192.168.12.26:11030")
public interface MessageService {

	@PostMapping(value = "/v1/sms")
	void sendSms(@RequestBody SmsTemplateMessageVo vo);

	@PostMapping(value = "/v1/mail/add")
	void sendMail(@RequestBody MailFormVo mailVo);

}

@Component
class MessageServiceFallbackFactory implements FallbackFactory<MessageService> {

	@Override
	public MessageService create(Throwable cause) {
		return new MessageServiceFallback(cause);
	}

	static class MessageServiceFallback extends AbstractFallback implements MessageService {

		MessageServiceFallback(Throwable cause) {
			super(cause);
		}

		@Override
		public void sendSms(SmsTemplateMessageVo vo) {
			handleKnownException();
            throw new BizException("远程调用失败，发送短信失败");
		}

		@Override
		public void sendMail(MailFormVo mailVo) {
			handleKnownException();
            throw new BizException("远程调用失败，发送站内信失败");
		}
	}
}
