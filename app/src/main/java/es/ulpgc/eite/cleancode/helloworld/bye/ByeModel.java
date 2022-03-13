package es.ulpgc.eite.cleancode.helloworld.bye;

public class ByeModel implements ByeContract.Model {

    public static String TAG = ByeModel.class.getSimpleName();

    //Cambiamos data por message y creamos metodo getByeMessage como en HelloModel
    private String message;

    public ByeModel(String message) { this.message = message; }

    @Override
    public String getByeMessage() { return message;}


    /*
    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return message2;
    }


    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }*/
}