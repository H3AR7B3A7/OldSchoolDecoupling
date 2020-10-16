package be.dog.d.steven;

import java.util.Properties;

public class MessageSupportFactory {

    private static final MessageSupportFactory instance;

    private MessageRenderer standard_renderer;
    private MessageRenderer lowercase_renderer;
    private MessageProvider world_provider;
    private MessageProvider java_provider;

    private MessageSupportFactory(){
        Properties props = new Properties();

        try{
            props.load(this.getClass().getResourceAsStream("msf.properties"));

            String standard_rendererClass = props.getProperty("standard_renderer.class");
            String lowercase_rendererClass = props.getProperty("lowercase_renderer.class");
            String world_providerClass = props.getProperty("world_provider.class");
            String java_providerClass = props.getProperty("java_provider.class");

            standard_renderer = (MessageRenderer) Class.forName(standard_rendererClass).getDeclaredConstructor().newInstance();
            lowercase_renderer = (MessageRenderer) Class.forName(lowercase_rendererClass).getDeclaredConstructor().newInstance();
            world_provider = (MessageProvider) Class.forName(world_providerClass).getDeclaredConstructor().newInstance();
            java_provider = (MessageProvider) Class.forName(java_providerClass).getDeclaredConstructor().newInstance();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return standard_renderer;
    }

    public MessageRenderer getMessageRenderer(String renderer){
        if(renderer.equals("standard")) {
            return standard_renderer;
        } else if(renderer.equals("lowercase")){
            return lowercase_renderer;
        } else return null;
    }

    public MessageProvider getMessageProvider(){
        return world_provider;
    }

    public MessageProvider getMessageProvider(String provider){
        if(provider.equals("world")){
            return world_provider;
        } else if (provider.equals("java")){
            return java_provider;
        } else return null;
    }
}
