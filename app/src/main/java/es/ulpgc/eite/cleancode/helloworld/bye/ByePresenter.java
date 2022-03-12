package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;

public class ByePresenter implements ByeContract.Presenter {

    public static String TAG = ByePresenter.class.getSimpleName();

    private WeakReference<ByeContract.View> view;
    private ByeState state;
    private ByeContract.Model model;
    private AppMediator mediator;

    public ByePresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getByeState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new ByeState();

        // call the model and update the state
        state.byeMessage = model.getStoredData();

        //Comentado hasta correcta implementación
        /*
        // use passed state if is necessary

        PreviousToByeState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary

            //model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary

            //state.data = savedState.data;
        }*/
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.byeMessage);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

         //Comentado hasta correcta implementación

        // use passed state if is necessary
        //NextToByeState savedState = getStateFromNextScreen();

        HelloToByeState savedState = getDataFromHelloScreen();
        if (savedState != null) {
            state.byeMessage = savedState.message;

            // update the model if is necessary
            //model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            //state.data = savedState.data;
        }
        view.get().displayByeData(state);
        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        //view.get().onDataUpdated(state);
    }

    //Creacion de metodos siguiendo el estilo de hello

    private void startByeMessageAsyncTask(){
        state.byeMessage = model.getByeMessage();
        view.get().displayByeData(state);
    }

    public void sayByeButtonClicked(){
        state.byeMessage = "?";
        view.get().displayByeData(state);
        startByeMessageAsyncTask();
    }

    @Override
    public void goHelloButtonClicked() {
        ByeToHelloState newState = new ByeToHelloState(state.byeMessage);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

     //Comentado hasta correcta implementación

    /*private NextToByeState getStateFromNextScreen() {
        return mediator.getNextByeScreenState();
    }*/

    private HelloToByeState getDataFromHelloScreen(){return mediator.getHelloToByeState();}

    /*
    private void passStateToNextScreen(ByeToNextState state) {
        mediator.setNextByeScreenState(state);
    }

    private void passStateToPreviousScreen(ByeToPreviousState state) {
        mediator.setPreviousByeScreenState(state);
    }

    private PreviousToByeState getStateFromPreviousScreen() {
        return mediator.getPreviousByeScreenState();
    }
    */

    @Override
    public void injectView(WeakReference<ByeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ByeContract.Model model) {
        this.model = model;
    }

}