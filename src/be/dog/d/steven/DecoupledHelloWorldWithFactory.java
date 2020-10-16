package be.dog.d.steven;

public class DecoupledHelloWorldWithFactory {

    public static void main(String[] args) {
        // msf.properties providing standard renderer and provider to factory
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
        mp = MessageSupportFactory.getInstance().getMessageProvider("java");
        mr.setMessageProvider(mp);
        mr.render();
        mr = MessageSupportFactory.getInstance().getMessageRenderer("lowercase");
        mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
        mp = MessageSupportFactory.getInstance().getMessageProvider("java");
        mr.setMessageProvider(mp);
        mr.render();
    }
}