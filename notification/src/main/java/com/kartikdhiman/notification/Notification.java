package com.kartikdhiman.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notification {
	@Id
	@SequenceGenerator(
					name = "notification_id_sequence",
					sequenceName = "notification_id_sequence"
	)
	@GeneratedValue(
					strategy = GenerationType.SEQUENCE,
					generator = "notification_id_sequence"
	)
	private Integer notificationId;
	private Integer toCustomerId;
	private String toCustomerEmail;
	private String message;
	private String sender;
	private LocalDateTime sentAt;
}
