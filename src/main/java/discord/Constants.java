package discord; 
  
 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import discord.TokenReader;
  
 
  public class Constants { 
  	 
  	//Default channel which messages will be sent by the bot 
  	public static final Long DEFAULT_CHANNEL_ID = 485449484705202186L; 
  	//Default format for dates. 
  	public static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
           
        public static final String PREFIX= "!";
        
          //Token that is read from the local file token.json 
         public static final String TOKEN; 
          static{ 
              TOKEN = TokenReader.getToken(); 
          } 
 	 
} 
