	package com.example.User.entity;
	
	import java.util.List;
import java.util.Random;
	
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Entity
	@Data
	@AllArgsConstructor
	
	public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer accountId;
		private String name;
		private String email;
		private String accountNumber;
		private Long phoneNumber;
		private Double balance;
		@Enumerated(EnumType.STRING)
		private AccountType accounType;

		
		public Account() {
			this.accountNumber = generatedAccountNumber();
		}
	
		private String generatedAccountNumber() {
			StringBuilder stringBuilder = new StringBuilder();
			Random random = new Random();
			stringBuilder.append(1+random.nextInt(9));
			for(int i = 0; i < 11; i++) {
				stringBuilder.append(random.nextInt(10));
				
			}
			return stringBuilder.toString();
		}
	}
