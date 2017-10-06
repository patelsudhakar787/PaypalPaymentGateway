package com.user.controller;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

		public class Mailtoadmin 
		                 {
						public static  void sendEmail()
					    	{
							try
							{
						String host = "smtp.gmail.com";
						String to1="sheetal.khankar@rlard.com";
						String username = "sheetal.khankar@rlard.com";
						String pass = "rlardsheetal1234567890";
						Properties props = new Properties();
						Session sessionn = Session.getInstance(props);
						MimeMessage msg = new MimeMessage(sessionn);
						Transport t = sessionn.getTransport("smtps");
						props = new Properties();
						props.put("mail.debug", true);
						msg = new MimeMessage(sessionn);
						msg.setFrom(new InternetAddress(username));
						msg.setRecipient(RecipientType.TO, new InternetAddress(to1));
						msg.setSubject(" One Incubitee Registered On STBI Web Portal");
						 msg.setContent("Hello Admin,<br><br>One New Incubitee Registered On STBI-PORTAL.<BR><BR>TEAM<BR>SAMRUDDHI TEAM","text/html");
					        try 
					        {
					     t.connect(host, username, pass);
					     t.sendMessage(msg, msg.getAllRecipients());
					        }
					     finally 
					            {
					           t.close();
					            }
						       }
						 catch(Exception e)
									{
										System.out.println(e);
									}
	                               }
                                  }
