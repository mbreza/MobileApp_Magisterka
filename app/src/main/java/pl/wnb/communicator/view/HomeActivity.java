package pl.wnb.communicator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import pl.wnb.communicator.R;
import pl.wnb.communicator.adapter.MessageAdapter;
import pl.wnb.communicator.model.Message;

public class HomeActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    private ListView messagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        messageAdapter = new MessageAdapter(this);
        messagesView = findViewById(R.id.list);
        messagesView.setAdapter(messageAdapter);

        messageAdapter.add(new Message("MrBujaka:", "Czesc", "10.00", false));
        messageAdapter.add(new Message("MrBujaka:", "Elo", "10.01", true));
        messageAdapter.add(new Message("MrBujaka:", "Co tam?", "10.02", false));
        messagesView.setSelection(messagesView.getCount() - 1);
    }
}
