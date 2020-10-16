package be.dog.d.steven;

public class DecoupledHelloWorld {

    public static void main(String[] args) {
        // Providing renderer and provider:
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
        mr.setMessageProvider(new HelloJavaMessageProvider());
        mr.render();
        mr = new LowerCaseMessageRenderer();
        mr.setMessageProvider(mp);
        mr.render();
        mr.setMessageProvider(new HelloJavaMessageProvider());
        mr.render();
    }
}