package es.ulpgc.eite.cleancode.helloworld.bye;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloActivity;

public class ByeActivity
        extends AppCompatActivity implements ByeContract.View {

    public static String TAG = ByeActivity.class.getSimpleName();

    private ByeContract.Presenter presenter;

    //Creamoos las variables de la pantalla Bye
    Button sayByeButton, goHelloButton;
    TextView byeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);
        //Cambiamos el nombre de la pantalla
        getSupportActionBar().setTitle(R.string.bye_screen_title);

        sayByeButton = findViewById(R.id.sayByeButton);
        goHelloButton = findViewById(R.id.goHelloButton);
        byeMessage = findViewById(R.id.byeMessage);

        sayByeButton.setOnClickListener(v -> presenter.sayByeButtonClicked());

        goHelloButton.setOnClickListener(v -> presenter.goHelloButtonClicked());

        sayByeButton.setText(getSayByeButtonLabel());
        goHelloButton.setText(getGoHelloButtonLabel());

        // do the setup
        ByeScreen.configure(this);

        /*
        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
        */

    }

    private String getGoHelloButtonLabel() {
        return "Go Hello";
    }

    private String getSayByeButtonLabel() {
        return "Say Bye";
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResumeCalled();
    }


    //Creacion de metodo displayByeData siguiendo modelo del HelloActivity
    @Override
    public void displayByeData(ByeViewModel viewModel){
        Log.e(TAG, "displayByeData");

        byeMessage.setText(viewModel.byeMessage);
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ByeActivity.class);
        startActivity(intent);
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void injectPresenter(ByeContract.Presenter presenter) {
        this.presenter = presenter;
    }

}