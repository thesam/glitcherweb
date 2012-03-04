package se.timberline.glitcher.alerts;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;

import se.timberline.glitcher.domain.Glitch;

public class AlertServiceImpl implements AlertService {

	@Override
	public void sendGlitchAlert(final Glitch glitch) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(glitch);
			}
		}
		);
	}

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public Glitch getAlert() {
		try {
			ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive();
			return (Glitch) receivedMessage.getObject();
		} catch (JMSException jmsException) {
			throw JmsUtils.convertJmsAccessException(jmsException);
		}
	}

}
