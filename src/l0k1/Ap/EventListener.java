package l0k1.Ap;

import java.util.ArrayList;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
	
	
	public static ArrayList<String> ExcemptUsers = new ArrayList<String>();	
	public static ArrayList<String> FilteredPhrases = new ArrayList<String>();	
	
	
	public static void sendMsg(MessageReceivedEvent event, String reason) {
		if (reason == "commanded") {
			event.getChannel().sendMessage("command excectued").queue();
		} else if (reason == "filtered") {
			event.getChannel().sendMessage("Sorry, that phrase is blocked by the chat filter").queue();
		}
	}
	
	
	
	public static void addToList(String cmd) {
		
		if (cmd.contains("%addPhrase ")) {
			cmd = cmd.replaceAll("%addPhrase ", "");
			FilteredPhrases.add(cmd);
			System.out.print(FilteredPhrases);
		} 
	}
		
	
	
	public static void messageDelete(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}
		
		event.getMessage().delete().queue();
		
		
		
	}
	
	
	
		
		
	
		

	
	
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		//event.getMessage().delete().queue();
		//System.out.print("worked");
		/*
		if (event.getAuthor().isBot()) {
			return;
		}
		
		String msg = event.getMessage().getContentRaw();
		
		//TextChannel channel = event.getTextChannel()
		
		event.getChannel().sendMessage(msg).queue();
		System.out.print(msg);
		
		messageDelete(event);
		*/
		
		if (event.getAuthor().isBot()) {
			return;
		}
		
		String msg = event.getMessage().getContentRaw();
		
		
		if (FilteredPhrases.contains(msg)) {
			sendMsg(event, "filtered");
			messageDelete(event);

		}
		
		
		if (msg.contains("%")) {
		addToList(msg);
		sendMsg(event, "commanded");
		}
		
		
		
		
		
		 	}
}
