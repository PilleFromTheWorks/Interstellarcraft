package com.pilleworks.interstellarcraft.handler;

import java.io.File;

import com.pilleworks.interstellarcraft.utility.LogHelper;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	
	public static void init(File configFile) {
		
		configuration = new Configuration(configFile);
		boolean configValue = false;
		
		try {
			
			configuration.load();
			
			configValue = configuration.getBoolean(
					"configValue",
					"ForgeCraft",
					true,
					"This is an example config value");
			
		}
		catch(Exception e) {
			
			LogHelper.error(e);
		}
		finally {
			
			if(configuration.hasChanged()) {
				
				configuration.save();
			}
		}
		
		System.out.println(configValue);
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		
		
	}
}
