package fi.solita.cd;

import java.util.List;

class MainPage {

    public final String build;
    public final List<Message> messages;

    public MainPage(String build, List<Message> messages) {
        this.build = build;
        this.messages = messages;
    }

}
