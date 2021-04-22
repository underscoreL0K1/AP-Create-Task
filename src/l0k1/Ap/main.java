package l0k1.Ap;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class main extends ListenerAdapter {
	public static JDA jda;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws LoginException {
	
		@SuppressWarnings("deprecation")
		/*JDABuilder jda = new JDABuilder(AccountType.BOT);
		String token = "ODE5OTkzMDI2ODM0MjAyNjQ2.YEusBA.W5QFo6tlTEybZIUCssvwA5gFzto";
		jda.setToken(token);
		jda.addEventListeners(new EventListener());
		jda.setActivity(Activity.playing("3"));
		jda.build();*/
		
		JDA jda = JDABuilder.createDefault("ODE5OTkzMDI2ODM0MjAyNjQ2.YEusBA.W5QFo6tlTEybZIUCssvwA5gFzto")
		.setActivity(Activity.playing("functioning"))
		.addEventListeners(new EventListener())
		.build();
		

	}
	
	

	
	
	
	
}
