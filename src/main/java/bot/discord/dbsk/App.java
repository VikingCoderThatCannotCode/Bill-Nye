package bot.discord.dbsk;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import discord.*;
import bot.discord.api.API;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;

//DBSK v1.0.1

/* GUIDE ON HOW TO USE THIS STARTER KIT
 * 
 * Hello! This is a starter kit made by FrankWhoee on GitHub! Here's the link to my profile: https://github.com/FrankWhoee
 * This starter kit is not meant to do everything for you, but merely to provide some starting ground to begin your adventure.
 * You can use this kit however you like, and feel free to dive into the Discord.java file to change and make your bot even better!
 * I encourage you to play around with the JDA class in there, after you are familiar with Java and JDA. This starter kit is made for
 * BNSS Coding Club members, but anyone can use this.
 * 
 * INSTRUCTIONS FOR NON-BNSS CODING CLUB MEMBERS:
 * Some of the constants are set specifically for BNSS Coding Club, but if you are not part of that, then you should
 * go to the Constants.java file in the package discord, and change Line 9. It's the id for the text channel where messages are sent
 * by default, and it's the id for a channel in our own server, so you'll have to create your own server and text channel, copy the id
 * of the text channel and replace 485449484705202186 with your own id.
 * 
 * INSTRUCTIONS FOR EVERYONE:
 * Since you'll be creating your own bot, you need to have your own token. Here are the steps to do so:
 * 
 * PREREQUISITE(S):
 * -You must have a Discord account.
 * 
 * 1. Go to the website: https://discordapp.com/developers/applications/
 * 2. Go to the Applications tab on the top of the page and click 'Create an application'
 * 3. Customise your application, then go to the Bot section by clicking on 'Bot' on the menu on the left
 * 4. Click 'Add Bot' and confirm by clicking 'Yes, do it!'
 * 5. Click 'Click to Reveal Token' and copy it. 
 * 6. Go to Line 47 in this file and replace TOKEN with your copied token.
 * 
 * WARNING:
 * NEVER reveal your token to anyone but your people who you are collaborating with. Do not post it online where anyone can see the token!
 * */

public class App 
{
	//Declare the variable discord, making it static so we can use it in other methods.
	public static Discord discord;
    public static void main( String[] args ){    	
    	//Initialise the Discord Bot with your token.
    	discord = new Discord(Constants.TOKEN);
		
    	//Set name
    	discord.setName("Discord Bot Starter Kit");
    	
        //Send a message.
        discord.sendMessage("Bill Nye The Science Guy");

        //Set up Music
        Music.setDiscord(discord);
        Music.configureMusic();

    }
    
    public static void messageEvent(MessageReceivedEvent evt) {
    	//When a message is sent, this method will be called.
        //evt contains all the information you need about the message.
        Message objMsg = evt.getMessage();
        MessageChannel objMsgCh = evt.getChannel();

        if(!objMsg.getContentRaw().startsWith(Constants.PREFIX)){
            return;
        }
        
        
        String command = objMsg.getContentRaw().substring(1);
        try{
            command = objMsg.getContentRaw().substring(1,objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){}
        
        String input = "";
        try{
            input = objMsg.getContentRaw().substring(objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){}
        System.out.println(command + ", " + input);
        
        if(command.equals("repeat")){
            for(int i = 0; i < 5; i++){
                discord.sendMessage("I'm the smartest man in the world");
            }
        }else if(command.equals("ping")){
            discord.sendMessage("pong");
        }
        else if(command.equals("news")){
            String json = "";
            try{
                json = API.requestAPI("https://newsapi.org/v2/top-headlines?country=ca&apiKey=05b26d6d26f44cd7a9a8f0acfc87fb71");
            }catch(Exception e){}
           JsonObject news=new JsonParser().parse(json).getAsJsonObject();
           String url=news.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();
           discord.sendMessage(url);
        }
        else if(command.equals("vsauce")){
                   discord.sendMessage("Vsauce sucks");
        }
        else if(command.equals("games")){
            discord.sendMessage("Video games cause violence kids");
        }
        else if (command.equals("Tachanka")){
            discord.sendMessage("He is the lord and savior");
        }
        else if (command.equals("your iq")){
            discord.sendMessage("My iq is below 50");
        }
        else if (command.equals("list")){
            discord.sendMessage("!vsauce, !news, !games,!earth, !Tachanka, !your iq, !ping, !repeat, !ligma");
        }
        else if (command.equals("ligma")){
                discord.sendMessage("I have ligma");
        }
        else if (command.equals("earth")){
                   discord.sendMessage("The Earth is flat!");
        }
        else if (command.equals("play")){
            Music.play(input);
            
        }
        
        else if (command.equals("join")){
            Music.joinChannel( 359845141420310548L);
        }
        else if (command.equals("leave")){
            Music.exitChannel();
        }
                
        
    }
        

    
    
    public static void emojiEvent(MessageReactionAddEvent evt) {
    	//When an emoji is added to a message, this method will be called.
    	//evt contains all the information you need about the emoji.
    }
}
