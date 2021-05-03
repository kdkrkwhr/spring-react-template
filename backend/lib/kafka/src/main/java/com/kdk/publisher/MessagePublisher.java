package com.kdk.publisher;

import com.kdk.channel.PaymentSuccessOutputChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessagePublisher {

  private final PaymentSuccessOutputChannel paymentSuccessOutputChannel;

  public void publishPaymentSuccessMessage(String message) {
    paymentSuccessOutputChannel.outputChannel().send(MessageBuilder.withPayload(message).build());
  }
}
