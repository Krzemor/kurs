package com.kodilla.exception.nullpointer;

public class NullpointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender sender = new MessageSender();

        try {
            sender.sendMessageTo(user, "Hello World");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send, but my program is still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}
