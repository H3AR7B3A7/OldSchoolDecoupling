package be.dog.d.steven;

public class HelloJavaMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello JAVA!";
    }
}
